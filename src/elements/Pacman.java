package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;


public class Pacman extends ElementMove  {
    
    private int score=0;
    private int remainingScore=0;
    private int numberLifes=1;
    private int numberDotstoEat=0;
    private int numberGhosttoEat=4;
    private long startTimePower=0;
    
    /**
     * Construtor da Classe 'Pacman' que recebe o nome de uma imagem e instância um objeto
     * que extende a classe Elemento que se move.
     * @param imageName
     */ 
    public Pacman(String imageName) {
        super(imageName);
        this.isMortal = true;
        
    }
    
    /**
     * Coleta a pontuação atual do pacman
     * @return int score
     */
    public int getScore(){
    	return this.score;
    }
    
    /**
     * Coleta a pontuação restante do pacman
     * @return int remainingScore
     */
    public int getRemainingScore(){
    	return this.remainingScore;
    }
    
    /**
     * Coleta o número de vidas do pacman
     * @return int numberLifes
     */
	public int getLifes() {
		return this.numberLifes;
	}
	
	/**
     * Coleta o número de pontos para comer do pacman
     * @return int numberDotstoEat
     */
	public int getNumberDotstoEat() {
		return this.numberDotstoEat;
	}
	
	public long getStartTimePower() {
		return this.startTimePower;
	}
	
	
	public void setStartTimePower(long start){
		this.startTimePower=start;
	}
	
	/**
	 * Altera o atributo 'remainingScore' de um objeto tipo Pacman
	 * @param remainingScore
	 */
	public void setRemainingScore(int remainingScore){
		this.remainingScore=remainingScore;
	}
	
	/**
	 * Altera o atributo 'numberLifes' de um objeto tipo Pacman
	 * @param numberLifes
	 */
	public void setNumberLifes(int numberLifes){
		this.numberLifes=numberLifes;
	}
	
	/**
	 * Incrementa em 1 o atributo 'numberLifes' de um objeto tipo Pacman
	 */
	public void addLife(){
		this.numberLifes++;
	}
	

	
	/**
	 * Incrementa em 1 o atributo 'numberDotstoEat' de um objeto tipo Pacman
	 */
	public void addNumberDotstoEat() {
		this.numberDotstoEat++;
	}
	/**
	 * Decrementa em 1 o atributo 'numberDotstoEat' de um objeto tipo Pacman
	 */
	public void minusNumberDotstoEat() {
		this.numberDotstoEat--;
	}
	/**
	 * Decrementa em 1 o atributo 'numberGhosttoEat' de um objeto tipo Pacman
	 */
	public void minusNumberGhotstoEat() {
		this.numberGhosttoEat--;
	}
	/**
	 * Incrementa em i o atributo 'score' de um objeto tipo Pacman
	 * @param int i
	 */
	public void addScore(int i) {
		score=score+i;
	}
	
	/**
	 * Incrementa em i o atributo 'remainingScore' de um objeto tipo Pacman
	 * @param int i
	 */
	public void addRemainingScore(int i) {
		this.remainingScore=this.remainingScore+i;
	}
    
    @Override
    public void autoDraw(Graphics g){
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }
    
    /**
     * Coleta o número fantasmas para comer do pacman
     * @return int numberGhosttoEat
     */
	public int getNumberGhosttoEat() {
		return numberGhosttoEat;
	}


}
