package elements;

import utils.Consts;
import utils.Drawing;
import java.awt.Graphics;


public class Wall extends BackgroundElement{
    
	/**
     * Construtor da Classe 'Wall' que recebe o nome de uma imagem e instância um objeto
     * que extende a classe Elemento de fundo.
     * @param imageName
     */
    public Wall(String imageName) {
        super(imageName);
        this.isTransposable = false;
    }
    
    /**
     * Método que insere o objeto na tela na posição adequada
     * @param g
     */
    public void autoDraw(Graphics g) {
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());

    }    
}
