

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
	private String sound;
	private Clip c;
	private AudioInputStream a;
	//input the name of the .wav file 
	public Audio(String s)
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		sound=s;
		 a=AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/"+sound+".wav"));
		c=AudioSystem.getClip();
		c.open(a);	} 
/*	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Audio a = new Audio("Wilhelm-Scream");
		a.playSoundtrack();
		Scanner sc = new Scanner(System.in); 
        if(sc.nextInt()==3) {
        	a.stop();
        }

   }*/  
	public void playSoundtrack() {
		c.loop(Clip.LOOP_CONTINUOUSLY);
		c.start();
	}
	public void playEffect() {
		c.start();
	}
	public void stop() {
		c.stop();
	}
}
