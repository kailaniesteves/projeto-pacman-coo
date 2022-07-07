package elements;

import java.awt.Graphics;

import utils.Drawing;

public class ScoreImage extends Element{
	private long startTime=0;

	public ScoreImage(String imageName, Ghost ghost) {
		super(imageName);
		this.setPosition(ghost.getPos().getX(), ghost.getPos().getY());
		this.isTransposable=true;
		this.isMortal=false;
	}
	
	/**
     * Coleta o tempo inicial de coleta da cereja
     * @return long startTime
     */
	public long getStartTime() {
		return this.startTime;
	}
	
	/**
	 * Altera o atributo 'startTime' de um objeto do tipo Cherry
	 * @param start
	 */
	public void setStartTime(long start){
		this.startTime=start;
	}

	@Override
	public void autoDraw(Graphics g) {
		Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
		
	}

}
