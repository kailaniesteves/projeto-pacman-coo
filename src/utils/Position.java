package utils;

import java.io.Serializable;


public class Position implements Serializable, Comparable<Position>{
    /* Elements are positioned in a grid layout (integers).
       However, walking is implemented with float steps (continuous).
       This is why x and y are double types.
       x and y ranges from 0 to CELL_SIZE*NUM_CELLS.
       The real pixel positioning is converted by the Drawing class.
       As consequence, any element has size 1x1 (x and y). */
    private double x;
    private double y;
    
    private double previousX;
    private double previousY;
    
    public Position getPreviousPosition() {
    	return new Position(this.previousX, this.previousY);
    }
    
    /**
     * Construtor da classe Position
     * @param x
     * @param y
     */
    public Position(double x, double y){
        this.setPosition(x,y);
    }
    /**
     * Calcula e redefine a posição de um elemento do jogo
     * @param x
     * @param y
     * @return boolean
     */
    public final boolean setPosition(double x, double y){
        int factor = (int)Math.pow(10, Consts.WALK_STEP_DEC_PLACES+1);
        x = (double)Math.round(x * factor) / factor;
        y = (double)Math.round(y * factor) / factor;
        
        if(x < 0 || x > utils.Consts.NUM_CELLS-1)
            return false;
        previousX = this.x;
        this.x = x;
        
        if(y < 0 || y > utils.Consts.NUM_CELLS-1)
            return false;
        previousY = this.y;
        this.y = y;
        return true;
    }
    /**
     * Acessa o atributo x de uma posição
     * @return double x
     */
    public double getX(){
        return x;
    }
    /**
     * Acessa o atributo y de uma posição
     * @return double y
     */
    public double getY(){
        return y;
    }
    /**
     * Faz com que um elemento tenha sua posição atual atualizada para a última posição em que esteve
     * @return boolean
     */
    public boolean comeBack(){
        return this.setPosition(previousX,previousY);
    }
    /**
     * Move um elemento pra cima
     * @return boolean
     */
    public boolean moveUp(){
        return this.setPosition(this.getX()-Consts.WALK_STEP, this.getY());
    }
    /**
     * Move um elemento pra baixo
     * @return boolean
     */
    public boolean moveDown(){
        return this.setPosition(this.getX()+Consts.WALK_STEP, this.getY());
    }
    /**
     * Move um elemento pra direita
     * @return boolean
     */
    public boolean moveRight(){
        return this.setPosition(this.getX(), this.getY()+Consts.WALK_STEP);
    }
    /**
     * Move um elemento pra esquerda
     * @return boolean
     */
    public boolean moveLeft(){
        return this.setPosition(this.getX(), this.getY()-Consts.WALK_STEP);        
    }
    /**
     * Calcula a distância entre as posições de dois elementos
     * @return double
     */
	public double distance(Position pos) {
		return Math.sqrt(Math.pow(x-pos.getX(),2)+Math.pow(y-pos.getY(),2));
	}
	
	/**
	 * Método que compara duas posições e retorna 0 caso sejam iguais e 1 se foram diferentes
	 */
	public int compareTo(Position o) {
		if((this.x == o.getX()) && this.y == o.getY()) {
			return 0;
		}
		return 1;
	}
    
}
