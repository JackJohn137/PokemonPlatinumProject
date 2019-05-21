

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
		try {
		 a=AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/"+sound+".wav"));
		c=AudioSystem.getClip();
		c.open(a);
		}
		catch(Exception NullPointerExeption){
			
		}
	}
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	/*	Audio a = new Audio("Wilhelm-Scream");
		a.playSoundtrack();
		Scanner sc = new Scanner(System.in); 
        if(sc.nextLine().equals("stop")) {
        	a.stop();
        }
        if(sc.nextLine().equals("resume")) {
        	a.resume();
        }
*/
   } 
   
	public void resume() throws LineUnavailableException {
		c.open();
		System.out.println("resuming");
	}
	public void playSoundtrack() {
		c.loop(Clip.LOOP_CONTINUOUSLY);
		c.start();
		System.out.println("playing");
	}
	public void playEffect() {
		c.start();
	}
	public void stop() {
		c.stop();
	}
	public boolean running() {
		return c.isRunning();
	}
	public void swapTrack(Audio a) {
		c.stop();
		a.playSoundtrack();
	}
}


