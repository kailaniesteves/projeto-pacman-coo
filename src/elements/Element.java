package elements;

import utils.Consts;
import utils.Position;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
public abstract class Element {

    protected ImageIcon imageIcon;
    protected Position pos;
    protected boolean isTransposable; 
    protected boolean isMortal;       
    
    /**
     * Construtor da Classe 'Element' que recebe o nome de uma imagem e instância um objeto
     * do tipo Elemento.
     * @param imageName
     */
    protected Element(String imageName) {
        this.pos = new Position(1, 1);
        this.isTransposable = true;
        this.isMortal = false;
        
        try {
            imageIcon = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + imageName);
            Image img = imageIcon.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIZE, Consts.CELL_SIZE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIZE, Consts.CELL_SIZE, null);
            imageIcon = new ImageIcon(bi);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public boolean overlap(Element elem) {
        double xDist = Math.abs(elem.pos.getX() - this.pos.getX());
        double yDist = Math.abs(elem.pos.getY() - this.pos.getY());
        
        if (xDist < 1.0 && yDist < 1.0)
            return true;
        else
            return false;
    }
    
    /**
     * Coleta a posição de um objeto no labirinto do jogo.
     * @return String com posição (x,y)
     */
    public String getStringPosition() {
        return ("(" + pos.getX() + ", " + pos.getY() + ")");
    }
    /**
     * Coleta o atributo 'pos' de um objeto do tipo Element.
     * @return Position pos
     */
    public Position getPos(){
    	return pos;
    }
    /**
     * Altera o valor atributo 'pos' de um objeto do tipo Element.
     * @return boolean, verdadeiro se a alteração foi feita e falso se não
     */
    public boolean setPosition(double x, double y) {
        return pos.setPosition(x, y);
    }
    
    /**
     * Coleta o valor do atributo 'isTransposable' de um objeto do tipo Element.
     * @return boolean, verdadeiro se o objeto é transponível e falso se não.
     */
    public boolean isTransposable() {
        return isTransposable;
    }
    
    /**
     * Coleta o valor do atributo 'isMortal' de um objeto do tipo Element.
     * @return boolean, verdadeiro se o objeto é mortal e falso se não.
     */
    public boolean isMortal() {
        return isMortal;
    }
    
    /**
     * Altera o valor do atributo 'isTransposable' de um objeto do tipo Element.
     */
    public void setTransposable(boolean isTransposable) {
        this.isTransposable = isTransposable;
    }

    abstract public void autoDraw(Graphics g);

 
}
