

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio implements Serializable{
	private transient String sound;
	private transient Clip c;
	private transient AudioInputStream a;
	//input the name of the .wav file 
	public Audio(String s)
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		sound = s;
		try {
		a = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/"+sound+".wav"));
		c = AudioSystem.getClip();
		c.open(a);
		}
		catch(Exception NullPointerExeption){
			
		}
	}

/*	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Audio a = new Audio("Wilhelm-Scream");
		a.playSoundtrack();
		Scanner sc = new Scanner(System.in); 
        while(!sc.next().equals("stop")) {
        	
        }
        a.stop();
        while(!sc.next().equals("resume")) {
        }
        a.playSoundtrack();
        while(1==1) {
        		
        }
        
	} 
  */ 
	public void resume() throws LineUnavailableException {
		c.start();
		System.out.println("resuming");
	}
  
	public void playSoundtrack() {
		c.loop(Clip.LOOP_CONTINUOUSLY);
		c.start();
	}
  
	public void playEffect() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	c.start();
	while(running()) {
		System.out.println("a");
	}
	}
  
	public void stop() {
		c.stop();
	}
  
	public boolean running() {
		return c.isRunning();
	}
  
	public void swapTrack(Audio a) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		c.close();
		a.playSoundtrack();
		this.a = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/"+sound+".wav"));

		c.open(this.a);
	}
}


