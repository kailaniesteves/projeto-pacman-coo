package elements;

import utils.Drawing;
import utils.Position;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;
public class Pinky extends Ghost  {
    
	/**
     * Construtor da Classe 'Pinky' que recebe o nome de uma imagem e instância um objeto
     * que extende a classe Fantasma.
     * @param imageName
     */ 
	public Pinky(String imageName) {
	      super(imageName);
	}
	
	/**
	 * Define o padrão de movimento do fantasma, caso ele não seja mortal ele segue o pacman horizontalmente, caso seja ele foge.
	 * @param g
	 */
    @Override
    public void autoDraw(Graphics g){
    	Pacman pacman=Drawing.getGameScreen().getPacman();
        Position posPacman=pacman.getPos();
        int movDirectionPacman=pacman.getMoveDirection();
        if (movDirectionPacman==MOVE_LEFT ||movDirectionPacman==MOVE_RIGHT){
        	if(!this.isMortal){
        		followPacmanHorizontal(movDirectionPacman, posPacman);
        	}
        	else{
        		escapePacmanHorizontal(movDirectionPacman, posPacman);
        	}
        }
        else if(movDirectionPacman==MOVE_DOWN ||movDirectionPacman==MOVE_UP){
        	moveRandom();

        	}
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());

    }



}
