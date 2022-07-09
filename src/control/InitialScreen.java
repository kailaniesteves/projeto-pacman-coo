package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import utils.Consts;

public class InitialScreen extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private final String nomeImagemInicial = "inicialimagem.png";
	private static String[] levels = { "Level 1", "Level 2", "Level 3", "Level 4" }; 
	
	private JComboBox<String> box;
	
	/**
	 * Construtor da classe InitialScreen()
	 */
	public InitialScreen(){
		configureInitialScreen();
		//configureStartButton();
		//configureOpenButton();
		//configureComboBox();
	}
	
	/**
	 * Cria a tela inicial, colocando o menu na parte superior usando uma JMenuBar,
	 * e define o tamanho da altura e largura da tela
	 */
	private void configureInitialScreen(){

		
		JMenuBar menuBar = new JMenuBar();//Cria a barra de menu

		JMenu abaMenu = new JMenu("Menu");//Adiciona as abas "Menu"
		
		//Criando itens para colocar dentro do menu
		JMenuItem itemOpen = new JMenuItem("Abrir jogo salvo (Open)");
		JMenuItem itemNivel1 = new JMenuItem("Nível 1");
		JMenuItem itemNivel2 = new JMenuItem("Nível 2");
		JMenuItem itemNivel3 = new JMenuItem("Nível 3");
		JMenuItem itemNivel4 = new JMenuItem("Nível 4");
		
	
		//Adicionando itens na aba
		abaMenu.add(itemOpen);
		abaMenu.add(itemNivel1);
		abaMenu.add(itemNivel2);
		abaMenu.add(itemNivel3);
		abaMenu.add(itemNivel4);
		
		//Colocando a aba no menu
		menuBar.add(abaMenu);
		
		//Faz o jogo iniciar ao clicar no botão "nível 1" do menu
		itemNivel1.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	Main.initialScreen.setVisible(false);  
		    	Main.initialScreen.dispose();
		    	Main.level = 1;
				Main.startGame();
	        }
	    });

		//Faz o jogo iniciar ao clicar no botão "nível 2" do menu
		itemNivel2.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	Main.initialScreen.setVisible(false);  
		    	Main.initialScreen.dispose();
		    	Main.level = 2;
				Main.startGame();
	        }
	    });
		

		//Faz o jogo iniciar ao clicar no botão "nível 3" do menu
		itemNivel3.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	Main.initialScreen.setVisible(false);  
		    	Main.initialScreen.dispose();
		    	Main.level = 3;
				Main.startGame();
	        }
	    });

		//Faz o jogo iniciar ao clicar no botão "nível 4" do menu
		itemNivel4.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	Main.initialScreen.setVisible(false);  
		    	Main.initialScreen.dispose();
		    	Main.level = 4;
				Main.startGame();
	        }
	    });
		
		//Método que permite abrir um jogo novo
		itemOpen.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	Main.initialScreen.setVisible(false);  
		    	Main.initialScreen.dispose();
		    	Main.openSavedGame = true;
		    	Main.startGame();
	        }
	    });
		
		
		//Colocando o menu na janela do jogo;
		setJMenuBar(menuBar);
		
		int sizeWidth = Consts.NUM_CELLS * Consts.CELL_SIZE + getInsets().left + getInsets().right;
		int sizeHeight = Consts.NUM_CELLS * Consts.CELL_SIZE + getInsets().top + getInsets().bottom;
		
		setSize(sizeWidth, sizeHeight);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCC0604 - Pacman"); 
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(20, 20));
        setResizable(false);	
        
	    

        try{
        	setContentPane(new JLabel(new ImageIcon(new File(".").getCanonicalPath() + Consts.PATH + nomeImagemInicial)));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }	
        //pack();
	}



	public class HandlerStartButton implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Main.initialScreen.setVisible(false);  
	    	Main.initialScreen.dispose();
			Main.startGame();
		}
	}

 
	public class HandlerOpenButton implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Main.initialScreen.setVisible(false);  
	    	Main.initialScreen.dispose();
	    	Main.openSavedGame = true;
	    	Main.startGame();
		}
	}
}
