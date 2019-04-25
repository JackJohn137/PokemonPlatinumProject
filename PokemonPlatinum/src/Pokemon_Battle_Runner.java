import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Map;

import javax.swing.*;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;



public class Pokemon_Battle_Runner {
	private static Player you;
	private static Pokemon_Trainer opponent;
	private static Pokemon you_field;
	private static Pokemon opponent_field;
	private static Pokemon_Move you_move;
	private static Pokemon_Move opponent_move;
	private int init;
	private JPanel panel;
	private Timer timer;
	private int ticks;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int X = (int) (screenSize.getWidth()), Y = (int) (screenSize.getHeight());
	private static final int REFRESH_RATE = 1000;
	
	public Pokemon_Battle_Runner(Player you, Pokemon_Trainer opponent, Pokemon you_field, Pokemon opponent_field, Pokemon_Move you_move, Pokemon_Move opponent_move) throws IOException
	{
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					start();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
				}
			}
		});
	}

	public static void main(String[] args) throws IOException {
		new Pokemon_Battle_Runner(you, opponent, opponent_field, opponent_field, opponent_move, opponent_move);
	}

	private void start() {
		JFrame frame = new JFrame("Pokemon_Battle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};
		
		panel.setBackground(Color.BLUE);
		panel.setPreferredSize(new Dimension(X,Y));
		frame.setLocation(X/10, Y/10);

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
		panel.repaint();
		ticks++;
	}
}
