package elements;

import utils.Consts;
import utils.Drawing;
import utils.Position;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;

public class Purply extends Ghost  {
    
	/**
     * Construtor da Classe 'Purply' que recebe o nome de uma imagem e instância um objeto
     * que extende a classe Fantasma.
     * @param imageName
     */ 
	public Purply(String imageName) {
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
