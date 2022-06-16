package elements;

import utils.Consts;
import utils.Drawing;
import utils.Position;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;

public class Clyde extends Ghost  {
    
	/**
     * Construtor da Classe 'Clyde' que recebe o nome de uma imagem e instância um objeto
     * que extende a classe Fantasma.
     * @param imageName
     */ 
	public Clyde(String imageName) {
	      super(imageName);
	}
	/**
	 * Define o padrão de movimento do fantasma, caso ele não seja mortal ele segue o pacmans, caso seja ele foge.
	 * @param g
	 */
    @Override
    public void autoDraw(Graphics g){
    	Pacman pacman=Drawing.getGameScreen().getPacman();
        Position posPacman=pacman.getPos();
        double distancia=posPacman.distance(this.pos);
        
        if(distancia<Consts.DISTANCEGHOST){
        	moveRandom();
        }
        else{
        	if(!this.isMortal){
        		followPacman();
        	}
        	else{
        		escapePacman();
        	}
        }
        	

        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());

    }


}
