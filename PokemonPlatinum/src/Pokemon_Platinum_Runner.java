import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;



public class Pokemon_Platinum_Runner{
	private JPanel panel;
	private Pokemon_Platinum_Game game;
	private Timer timer;
	private int ticks;
	private Direction direction;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int X = (int) (screenSize.getWidth()), Y = (int) (screenSize.getHeight());
	private static final int REFRESH_RATE = 100;
	private boolean step=true;

	public Pokemon_Platinum_Runner() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try 
				{
					FileInputStream saveFile = new FileInputStream("SaveState");
					ObjectInputStream saveState = new ObjectInputStream(saveFile);
					game = (Pokemon_Platinum_Game) saveState.readObject();
					saveState.close();
					saveFile.close();
				}
				catch (ClassNotFoundException | IOException e) 
				{
					System.out.println("No Prior Save Files! Starting New Game!");
					direction = Direction.NONE; 
					try {
						game = new Pokemon_Platinum_Game();
					} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e1) {
						e1.printStackTrace();
					}
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						start();
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e2) {
						e2.printStackTrace();
					}
				} 

			}
		});
	}

	public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		new Pokemon_Platinum_Runner();
	}

	private void start() {
		game.getCurrent_map().audio().playSoundtrack();
		JFrame frame = new JFrame("Pokemon_Platinum");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);

				game.getCurrent_map().draw(g);//Draws whatever map is currently showing
				game.draw(g);
			}
		};
		// random color to the background
		panel.setBackground(Color.BLUE);

		// so that the frame isn't minimized
		panel.setPreferredSize(new Dimension(X,Y));
		frame.setLocation(X/10, Y/10);
		mapKeyStrokesToActions(panel);

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		panel.requestFocusInWindow();

		// this timer controls the actions in the game and then repaints after each update to data
		timer = new Timer(REFRESH_RATE, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateGame();
			}
		});
		timer.start();
	}

	// this method is called every time the timer goes off (which right now is every 10 milliseconds = 100 times per second
	protected void updateGame() {
		if(game.getPlayer().isCan_move()==true) 
			game.getCurrent_map().audio().playSoundtrack();
		panel.repaint();//Repaints after each update

		ticks++;//Adds to the timer

		if(ticks / REFRESH_RATE % 10 == 0) 
		{

			direction = Direction.NONE;
		}

	}

	private void mapKeyStrokesToActions(JPanel panel) {

		// A map is an Data storage interface which defines
		// an association of a key with a value
		// to "add" to a map you use the "put" method
		// to "get" from a map you use "get(key)" and the 
		// value associated with the key is returned (or null)
		ActionMap map = panel.getActionMap();
		InputMap inMap = panel.getInputMap();

		// code below associates pressing the up arrow with the command "up"
		// essentially creating the command "up" being broadcast any time the 
		// up key is hit
		inMap.put(KeyStroke.getKeyStroke("pressed UP"), "up");
		inMap.put(KeyStroke.getKeyStroke("pressed W"), "up");
		map.put("up", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					hit("up");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
		inMap.put(KeyStroke.getKeyStroke("pressed DOWN"), "down");
		inMap.put(KeyStroke.getKeyStroke("pressed S"), "down");
		map.put("down", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					hit("down");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
		inMap.put(KeyStroke.getKeyStroke("pressed LEFT"), "left");
		inMap.put(KeyStroke.getKeyStroke("pressed A"), "left");
		panel.getActionMap().put("left",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					hit("left");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		inMap.put(KeyStroke.getKeyStroke("pressed RIGHT"), "right");
		inMap.put(KeyStroke.getKeyStroke("pressed D"), "right");
		map.put("right", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					hit("right");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		inMap.put(KeyStroke.getKeyStroke("pressed SPACE"), "SAVE_GAME");
		map.put("SAVE_GAME", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					FileOutputStream saveFile = new FileOutputStream("SaveState");
					ObjectOutputStream saveState = new ObjectOutputStream(saveFile);
					saveState.writeObject(game);
					saveState.close();
					System.out.printf("Serialized data is saved in SaveState");
				}  

				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
		});
	}

	public void hit(String s) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		if (ticks>2) {
			ticks = 0;

			if (s.equals("up"))
			{
				direction = Direction.UP;
			}
			else if (s.equals("down"))
			{
				direction = Direction.DOWN;
			}
			else if (s.equals("left"))
			{
				direction = Direction.LEFT;
			}
			else if (s.equals("right"))
			{
				direction = Direction.RIGHT;
			}

			game.keyHit(s);
			panel.repaint();
		}
	}
}
