

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
	public void swapTrack(Audio a) {
		c.stop();
		a.playSoundtrack();
	}
}


