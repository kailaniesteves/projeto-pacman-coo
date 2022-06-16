package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;


public class PacDots extends ElementGivePoint {
    
	/**
     * Construtor da Classe 'PacDots' que recebe o nome de uma imagem e instância um objeto
     * que extende a classe Elemento dá Pontos.
     * @param imageName
     */ 
    public PacDots(String imageName) {
        super(imageName);
        this.numberPoints = 10;
    }

    
    
}
