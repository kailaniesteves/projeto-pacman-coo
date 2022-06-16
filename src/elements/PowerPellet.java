package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;
public class PowerPellet extends ElementGivePoint {
	
	/**
     * Construtor da Classe 'PowerPellet' que recebe o nome de uma imagem e instância um objeto
     * que extende a classe Elemento dá Pontos.
     * @param imageName
     */ 
    public PowerPellet(String imageName) {
        super(imageName);
        this.numberPoints=50;
    }

    
}
