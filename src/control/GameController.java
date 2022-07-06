package control;

import elements.*;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import utils.Consts;
import utils.Position;

public class GameController {
	
	/**
	 * Desenha todos os elementos na tela do jogo
	 * @param elemArray
	 * @param g
	 */
    public void drawAllElements(ArrayList<Element> elemArray, Graphics g){
    	Pacman pacman=(Pacman) elemArray.get(0);
    	int numberGhost=pacman.getNumberGhosttoEat();
    	for(int i=numberGhost+1; i<elemArray.size(); i++){
            elemArray.get(i).autoDraw(g);
        }
        
        for(int i=0;i<=numberGhost;i++){
        	elemArray.get(i).autoDraw(g);
        }
        
    }
    /**
     * Faz verifições constantes dos elementos do jogo, posição, sobreposição, ganho de pontos, número de vidas, etc.
     * @param elements
     * @param matrix
     * @param cont
     */
    public void processAllElements(ArrayList<Element> elements, int [][]matrix, int cont){
        if(elements.isEmpty())
            return;
    	Pacman pacman = (Pacman)elements.get(0);
    	int numberGhost = pacman.getNumberGhosttoEat();
    	
        
    	checkElementColideWall(elements, numberGhost);
    	boolean overlapGhostPacman=checkOverlapGhostPacman(elements,pacman, numberGhost);

        if(overlapGhostPacman) { 
        	pacman.setNumberLifes(pacman.getLifes()-1);
        	if(pacman.getLifes() > 0) {
        		for(int i = 0;i<Consts.NUM_CELLS;i++) {
					for(int j = 0;j<Consts.NUM_CELLS;j++) {
						switch(matrix[i][j]) {
							case 9:
								pacman.setPosition(i,j);
								break;
							default:
								break;
						}
					}
				}
				pacman.setMovDirection(0);
        	}
			else {
				Main.gamePacMan.dispose();
				JOptionPane.showMessageDialog(null, "Fim do jogo");
				System.exit(0);
			}
        		
        }
        else if(pacman.getNumberDotstoEat() == 0){  
        	Main.level += 1;
        	if(Main.level>=4){
        		Main.gamePacMan.dispose();
        		JOptionPane.showMessageDialog(null, "Fim do jogo");
        		System.exit(0);
        	}
        	else{
        		Main.gamePacMan.reStartGame(1);
        	}
        }
        else{
	        checkPacmanEatSomeOneAndOrTimeFruittoDesappear(elements,pacman);
	        checkTimetoAppearFruit(elements,matrix);
	        checkTimeGhostBeNormal(elements,pacman);
	
	        pacman.move();
	        for (int i=1;i<=pacman.getNumberGhosttoEat();i++){
	            ElementMove elementMove = (ElementMove)elements.get(i);
	            if (!elementMove.isMortal()){
	            	elementMove.move();
	            }
	            else{
	            	if (elementMove.isMortal() && cont%2==0){
	            		elementMove.move();
	            	}
	            }
	        }
        }
    }
    
    /**
     * Checa se o pacman está sobrepondo algum fantasma no tabuleiro
     * @param elements
     * @param pacman
     * @param numberGhost
     * @return boolean, com verdadeiro caso o pacman esteja sobrepondo alguém e falso se não
     */
	private boolean checkOverlapGhostPacman(ArrayList<Element> elements, Pacman pacman,int numberGhost) {
        boolean overlapGhostPacman=false;
        for (int i=1;i<=numberGhost;i++){
        	if(elements.get(i).overlap(pacman) & !elements.get(i).isMortal()){
        		overlapGhostPacman=true;
        	}
        }
        return overlapGhostPacman;
	}
	/**
	 * Checa se algum objeto que estende ElementMove está sobrepondo a parede
	 * @param elements
	 * @param numberGhost
	 */
	private void checkElementColideWall(ArrayList<Element> elements, int numberGhost) {
    	for (int i=0;i<=numberGhost;i++){
        	ElementMove elementMove = (ElementMove)elements.get(i);
        	if (!isValidPosition(elements, elementMove)) {
        		elementMove.backToLastPosition();
        		elementMove.setMovDirection(ElementMove.STOP);
        		//return;
        	}
        }
		
	}
	/**
	 * Checa se o pacman comeu um fantasma, calcula e soma os pontos ao comer pac-dots, frutas,  
	 * altera a cor dos fantasmas ao comer um power pellet e remove as frutas da tela depois do
	 * tempo determinado.
	 * @param elements
	 * @param pacman
	 */
	private void checkPacmanEatSomeOneAndOrTimeFruittoDesappear(ArrayList<Element> elements, Pacman pacman) {

        Element eTemp;
        for(int i =1; i < elements.size(); i++){
            eTemp = elements.get(i);
            if(pacman.overlap(eTemp)){
                if(eTemp.isTransposable() && eTemp.isMortal()){
                    elements.remove(eTemp);
                    if (eTemp instanceof Ghost){
                  	  pacman.minusNumberGhotstoEat();
                  	  pacman.addScore(200*(4-pacman.getNumberGhosttoEat()));
                  	  pacman.addRemainingScore(200*(4-pacman.getNumberGhosttoEat()));
                    } 
                    
                    if (eTemp instanceof ElementGivePoint){                     
                      pacman.addScore(((ElementGivePoint) eTemp).getNumberPoints());
                      pacman.addRemainingScore(((ElementGivePoint) eTemp).getNumberPoints());
                      
                      if (eTemp instanceof PacDots){
                    	  pacman.minusNumberDotstoEat();
                      }
                      if (eTemp instanceof PowerPellet){
                    	  for(int k=1;k<=pacman.getNumberGhosttoEat(); k++){
                    		  ((Ghost)elements.get(k)).changeGhosttoBlue("ghostBlue.png");
                    	  }
                    	  pacman.setStartTimePower(System.currentTimeMillis());
                      }    
                      
                    }
                }
                int remainingScore=pacman.getRemainingScore();
                if(remainingScore>1000){
                	pacman.addLife();
                	pacman.setRemainingScore(remainingScore-1000);
                }
                
            }   
            else{
            	if (eTemp instanceof Cherry){
            		long elapsed = System.currentTimeMillis()-((Cherry)eTemp).getStartTime();
            		if (elapsed>=15000){
            			elements.remove(eTemp);
            		}
            		
            		
            	}
            	if (eTemp instanceof Strawberry){
            		long elapsed = System.currentTimeMillis()-((Strawberry)eTemp).getStartTime();
            		if (elapsed>=15000){
            			elements.remove(eTemp);
            		}
            	}
                 	
            }
        }
        
	}
	/**
	 * Checa se é o momento certo para uma fruta aparecer, se sim, configura sua posição
	 * e adiciona ela ao elemArray
	 * @param elements
	 * @param matrix
	 */
	private void checkTimetoAppearFruit(ArrayList<Element> elements,  int [][]matrix) {
        
        long elapsedTime = System.currentTimeMillis()-Main.time;
        if (elapsedTime%75000<=10){
        	Strawberry straw=new Strawberry("strawberry.png");
        	straw.setStartTime(System.currentTimeMillis());
        	Position pos=getValidRandomPositionMatrix(matrix);
            straw.setPosition (pos.getX(),pos.getY());
            elements.add(straw);
        }
        if (elapsedTime%50000<=10){
        	Cherry cherry=new Cherry("cherry.png");
        	cherry.setStartTime(System.currentTimeMillis());
        	Position pos=getValidRandomPositionMatrix(matrix);
            cherry.setPosition (pos.getX(),pos.getY());
            elements.add(cherry);
        }
		
	}
	/**
	 * Procura por uma posição válida na matriz do jogo, que não esteja sobrepondo uma parede
	 * @param matrix
	 * @return Position 
	 */
	private Position getValidRandomPositionMatrix(int[][] matrix) {
		Random gerador = new Random();
		int x;
		int y;
		Position pos=new Position(0,0);
		do{
			x=gerador.nextInt(Consts.NUM_CELLS);		
			y=gerador.nextInt(Consts.NUM_CELLS);
		}while(matrix[x][y]==1);
		pos.setPosition(x, y);
		return pos;
	}
	/**
	 * Verifica se o tempo dos fantasmas voltarem a ser mortais depois de um power pellet, caso sim,
	 * configura todos eles para a cor e comportamentos normais
	 * @param elements
	 * @param pacman
	 */
	private void checkTimeGhostBeNormal(ArrayList<Element> elements,
			Pacman pacman) {
        long start=pacman.getStartTimePower();
        if (start!=0){
        	long elapsedTimePower = System.currentTimeMillis()-start;
        	if(elapsedTimePower>=7000){
        		
        		pacman.setStartTimePower(0);
        		Element e;
        		for (int i=1;i<=pacman.getNumberGhosttoEat();i++){
        			e = elements.get(i);
        			if(e instanceof Blinky){
        				((Blinky) e).changeGhosttoNormal("blinky.png");
        			}
        			if(e instanceof Pinky){
        				((Pinky) e).changeGhosttoNormal("pinky.png");
        			}
        			if(e instanceof Inky){
        				((Inky) e).changeGhosttoNormal("inky.png");
        			}
        			if(e instanceof Clyde){
        				((Clyde) e).changeGhosttoNormal("clyde.png");
        			}
        			
                }		
        			
        	}
        	
        }
        

		
	}
	
	/**
	 * Verifica se a poição de um elemento é válida ou sobrepõe algum outro
	 * @param elemArray
	 * @param elem
	 * @return true se é válida e false caso contrário
	 */
	public boolean isValidPosition(ArrayList<Element> elemArray, Element elem){
        Element elemAux;
        for(int i = 1; i < elemArray.size(); i++){
            elemAux = elemArray.get(i);            
            if(!elemAux.isTransposable())
                if(elemAux.overlap(elem))
                    return false;
        }        
        return true;
    }
}
