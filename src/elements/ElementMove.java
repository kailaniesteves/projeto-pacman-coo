package elements;

import utils.Drawing;
import utils.Position;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;

public abstract class ElementMove extends Element  {
    
    public static final int STOP = 0;
    public static final int MOVE_LEFT = 1;
    public static final int MOVE_RIGHT = 2;
    public static final int MOVE_UP = 3;
    public static final int MOVE_DOWN = 4;
    
    private int movDirection = STOP;
    
    /**
     * Coleta a direção de movimento do elemento
     * @return int movDirection
     */
    public int getMoveDirection(){
    	return movDirection;
    }
    
    /**
     * Construtor da Classe 'ElementMove' que recebe o nome de uma imagem e instância um objeto
     * que extende a classe Elemento.
     * @param imageName
     */ 
    public ElementMove(String imageName) {
        super(imageName);
    }
    
     
    /**
     * Método abstrato que insere e/ou movimenta o objeto na tela
     * @param g
     */
    abstract public void autoDraw(Graphics g);
    
    
    /**
     * Retorna o valor do atributo 'pos' para o valor anterior ao atual
     */
    public void backToLastPosition(){
        this.pos.comeBack();
    }
    
    /**
     * Altera o valor do atributo 'movDirection' de um objeto do tipo ElementMove
     * @param direction
     */
    public void setMovDirection(int direction) {
        movDirection = direction;
    }
    
    /**
     * Altera o valor do atributo 'movDirection' de um objeto do tipo ElementMove, dependendo da escolha do
     * jogador.
     */
    public void move() {
        switch (movDirection) {
            case MOVE_LEFT:
                this.moveLeft();
                break;
            case MOVE_RIGHT:
                this.moveRight();
                break;
            case MOVE_UP:
                this.moveUp();
                break;
            case MOVE_DOWN:
                this.moveDown();
                break;
            default:
                break;
        }
    }
    /**
     * Altera o valor do atributo 'pos' de um objeto do tipo ElementMove, movendo uma casa
     * para cima.
     */
    public boolean moveUp() {
        return this.pos.moveUp();
    }
    /**
     * Altera o valor do atributo 'pos' de um objeto do tipo ElementMove, movendo uma casa
     * para baixo.
     */
    public boolean moveDown() {
        return this.pos.moveDown();
    }
    /**
     * Altera o valor do atributo 'pos' de um objeto do tipo ElementMove, movendo uma casa
     * para direita.
     */
    public boolean moveRight() {
        return this.pos.moveRight();
    }
    /**
     * Altera o valor do atributo 'pos' de um objeto do tipo ElementMove, movendo uma casa
     * para esquerda.
     */
    public boolean moveLeft() {
        return this.pos.moveLeft();
    }


}
