package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;
public class Cherry extends ElementGivePoint {
	private long startTime=0;
	/**
     * Construtor da Classe 'Cherry' que recebe o nome de uma imagem e instância um objeto
     * que extende a classe Element dá Ponto.
     * @param imageName
     */ 
    public Cherry(String imageName) {
        super(imageName);
        this.numberPoints=100;
        this.startTime=System.currentTimeMillis();
    }
    
    /**
     * Coleta o tempo inicial de coleta da cereja
     * @return long startTime
     */
	public long getStartTime() {
		return this.startTime;
	}
	
	/**
	 * Altera o atributo 'startTime' de um objeto do tipo Cherry
	 * @param start
	 */
	public void setStartTime(long start){
		this.startTime=start;
	}

    
}
