package utils;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Assert.*;
import elements.*;
import control.*;

public class GameTests {
	private String imageName = "C:\\git\\projeto-pacman-coo\\imgs";
	private Element elem;
	private Ghost ghost = new Blinky(imageName);
	private double x =3;
	private double y =5;
	
	@Test
	public void testePacman() {
		Pacman pacman = new Pacman(imageName);
		pacman.setNumberLifes(5);
		int vidas = pacman.getLifes();
		pacman.setRemainingScore(300);
		assertTrue(vidas == 5);
		assertTrue(pacman.getRemainingScore() == 300);
	}
	
	@Test
	public void testeGhost() {
		this.ghost.setPosition(x, y);
		this.ghost.setMovDirection(2);
		assertTrue(ghost.getMoveDirection() == 2);
		assertTrue(ghost.getPos().equals(new Position(x,y)));
	}
	
	@Test
	public void testeAddElemArray() {
		GameScreen gameScreen = new GameScreen();
		gameScreen.addElement(elem);
		ArrayList<Element> teste = gameScreen.getElemArray();
		assertTrue(teste.get(0).equals(elem));
	}
}
