package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;

public class Strawberry extends ElementGivePoint {
	private long startTime=0;
	/**
     * Construtor da Classe 'Strawberry' que recebe o nome de uma imagem e instância um objeto
     * que extende a classe Element dá Ponto.
     * @param imageName
     */ 
	public Strawberry(String imageName) {
        super(imageName);
        this.numberPoints=300;
        this.startTime=System.currentTimeMillis();
    }
	
	/**
     * Coleta o tempo inicial de coleta do morango
     * @return long startTime
     */
	public long getStartTime() {
		return this.startTime;
	}
	
	/**
	 * Altera o atributo 'startTime' de um objeto do tipo Strawberry
	 * @param start
	 */
	public void setStartTime(long start){
		this.startTime=start;
	}

}
