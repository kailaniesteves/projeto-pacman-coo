package elements;

import utils.Consts;
import utils.Drawing;
import java.awt.Graphics;

public abstract class BackgroundElement extends Element{
    
	/**
     * Construtor da Classe 'BackgroundElement' que recebe o nome de uma imagem e instância um objeto
     * que extende a classe Elemento.
     * @param imageName
     */
    public BackgroundElement(String imageName) {
        super(imageName);
    }
    
    /**
     * Método abstrato que insere o objeto na tela
     * @param g
     */
    public abstract void autoDraw(Graphics g);
}
