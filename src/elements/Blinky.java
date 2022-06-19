package elements;

import utils.Drawing;
import utils.Position;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;
public class Blinky extends Ghost  {
	
	/**
     * Construtor da Classe 'Blinky' que recebe o nome de uma imagem e instância um objeto
     * que extende a classe Fantasma.
     * @param imageName
     */ 
	public Blinky(String imageName) {
	      super(imageName);
	}
	
	/**
	 * Define o padrão de movimento do fantasma, caso ele não seja mortal ele foge, caso seja ele segue o pacman.
	 * @param g
	 */
    @Override
    public void autoDraw(Graphics g){
    	if(!this.isMortal){
    		followPacman();
    	}
    	else{
    		escapePacman();
    	}
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }

    


}
