import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
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
	private static JPanel[] menu;
	private static JPanel current_menu;
	private Timer timer;
	private int ticks;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int X = (int) (screenSize.getWidth()), Y = (int) (screenSize.getHeight());
	private static final int REFRESH_RATE = 1000;
	
	public Pokemon_Battle_Runner(Player you, Pokemon_Trainer opponent, Pokemon_Move you_move, Pokemon_Move opponent_move) throws IOException
	{
		this.you = you;
		this.opponent = opponent;
		this.you_field = you.getPokemon_storage().getPokemon(0);
		this.opponent_field = opponent.getPokemon_storage().getPokemon(0);
		this.you_move = null;//Will be decided by button
		this.opponent_move = null;//Will be decided by button
		this.menu = new JPanel[4];
		set_up_menus();
		
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

	private void set_up_menus() {
		for (JPanel jp : menu)
		{
			jp.setBackground(Color.BLUE);
			jp.setPreferredSize(new Dimension(X,Y));
			jp.requestFocusInWindow();
		}
		
		menu[0] = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};
		
		menu[1] = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};
		
		menu[2] = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};
		
		menu[3] = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};
		
		menu[4] = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};
		
	}

	public static void main(String[] args) throws IOException {
		new Pokemon_Battle_Runner(you, opponent, opponent_move, opponent_move);
	}

	private void start() {
		JFrame frame = new JFrame("Pokemon_Battle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.current_menu = menu[0];
		this.current_menu.requestFocusInWindow();
		
		frame.add(current_menu);
		frame.pack();
		frame.setVisible(true);
		frame.setLocation(X/10, Y/10);
		frame.add(current_menu);
		frame.pack();
		frame.setVisible(true);

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
		current_menu.repaint();
		ticks++;
	}
}
