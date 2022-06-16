package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;

public class ElementGivePoint extends Element {
    protected  int numberPoints=0;
    
    /**
     * Coleta o atributo 'numberPoints' de um objeto da classe ElementGivePoints
     * @return
     */
	public int getNumberPoints(){
		return numberPoints;
	}
	
	/**
     * Construtor da Classe 'ElementGivePoint' que recebe o nome de uma imagem e instância um objeto
     * que extende a classe Elemento.
     * @param imageName
     */ 
    public ElementGivePoint(String imageName) {
        super(imageName);
        this.isMortal = true;        
    }
    
    /**
     * Método que insere e/ou movimenta o objeto na tela na posição adequada
     * @param g
     */
    @Override
    public void autoDraw(Graphics g) {
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }
    
}
