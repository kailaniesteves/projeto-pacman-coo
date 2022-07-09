package utils;

import java.io.File;
import javax.sound.sampled.*;

public class AudioCerto{
		
	/**
	 * Toca musíca inicial
	 */
        public void AudioAcerto() { //Método AudioCerto para chamar na classe executavel.
        try {
            //URL do som que no caso esta no pendrive, mais ainda é uma fase de teste.
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("musica.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Erro ao executar SOM!");
            ex.printStackTrace();
        }
    }
        /**
    	 * Toca musíca de fim de jogo
    	 */
        public void AudioMorte() { //Método AudioCerto para chamar na classe executavel.
            try {
                //URL do som que no caso esta no pendrive, mais ainda é uma fase de teste.
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("morte.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                System.out.println("Erro ao executar SOM!");
                ex.printStackTrace();
            }
        }
        
        /**
    	 * Toca musíca ao comer um PacDot
    	 */
        public void AudioCome() { //Método AudioCerto para chamar na classe executavel.
            try {
                //URL do som que no caso esta no pendrive, mais ainda é uma fase de teste.
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("eat.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                System.out.println("Erro ao executar SOM!");
                ex.printStackTrace();
            }
        }
}