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
	private static String[] levels = { "Level 1", "Level 2", "Level 3" };
	
	private JComboBox<String> box;
	
	public InitialScreen(){
		configureInitialScreen();
		//configureStartButton();
		//configureOpenButton();
		configureComboBox();
	}
	
	private void configureInitialScreen(){

		
		JMenuBar menuBar = new JMenuBar();//Cria a barra de menu

		JMenu abaMenu = new JMenu("Menu");//Adiciona a aba "Menu"
		
		//Criando itens para colocar dentro do menu
		JMenuItem itemIniciar = new JMenuItem("Iniciar");
		JMenuItem itemOpen = new JMenuItem("Abrir jogo salvo(Open)");
		
		//Adicionando itens na aba
		abaMenu.add(itemIniciar);
		abaMenu.add(itemOpen);
		
		//Colocando a aba no menu
		menuBar.add(abaMenu);
		
		//Método que faz o jogo iniciar
		itemIniciar.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	Main.initialScreen.setVisible(false);  
		    	Main.initialScreen.dispose();
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

	private void configureComboBox(){
		box = new JComboBox<String>(levels);
		box.setSize(100, 40);
		box.setSelectedIndex(0);
		box.setLocation(500, 10);
		box.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent event){
				if(event.getStateChange() == ItemEvent.SELECTED){ 
					JComboBox<String> cb = (JComboBox<String>)event.getSource();
					Main.level = cb.getSelectedIndex() + 1;
				}
			}			
		});
		add(box);
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
