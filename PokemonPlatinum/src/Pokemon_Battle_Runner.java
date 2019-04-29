import java.awt.*;
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
	private static JFrame frame;
	private static JPanel[] menu;
	private static int CURRENT_MENU;
	private static int PREVIOUS_MENU;
	private Timer timer;
	private int ticks;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int INITIAL_X = (int) (screenSize.getWidth() / 2 - 300);
	public static final int X = (int) (600), Y = (int) (800);
	private static final int REFRESH_RATE = 100;
	private final int MAIN_MENU = 0;
	private final int FIGHT_MENU = 1;
	private final int TEAM_MENU = 2;
	private final int BAG_MENU = 3;
	
	public Pokemon_Battle_Runner(Player you, Pokemon_Trainer opponent, Pokemon_Move you_move, Pokemon_Move opponent_move) throws IOException
	{
		this.you = you;
		this.opponent = opponent;
		//this.you_field = you.getPokemon_storage().getPokemon(0);
		//this.opponent_field = opponent.getPokemon_storage().getPokemon(0);
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
		set_up_main_menu();
		set_up_fight_menu();
		set_up_bag_menu();
		set_up_team_menu();
		for (JPanel jp : menu)
		{
			jp.setBounds(0, 0, 750, 1000);
			jp.setPreferredSize(new Dimension(750, 1000));
			jp.setLayout(null);
		}
	}

	public static void main(String[] args) throws IOException {
		new Pokemon_Battle_Runner(you, opponent, opponent_move, opponent_move);
	}

	private void start() {
		frame = new JFrame("Pokemon_Battle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PREVIOUS_MENU = 0;
		CURRENT_MENU = 0;
		frame.add(menu[MAIN_MENU]);
		frame.add(menu[FIGHT_MENU]);
		frame.add(menu[BAG_MENU]);
		frame.add(menu[TEAM_MENU]);
		//frame.add(menu[4]);
		frame.pack();
		
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setPreferredSize(new Dimension(600, 800));
		frame.setBounds(INITIAL_X, 0, 600, 800);
		frame.pack();
		frame.setVisible(true);
		menu[0].setVisible(true);
		
		// this timer controls the actions in the game and then repaints after each update to data
		timer = new Timer(REFRESH_RATE, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateBattle();
			}
		});
		timer.start();
	}

	// this method is called every time the timer goes off (which right now is every 10 milliseconds = 100 times per second
	protected void updateBattle() {
		for(int i = 0; i < menu.length; i++)
		{
			System.out.print(i);
			if (i == this.CURRENT_MENU)
			{
				if (menu[i].isVisible())
				{
					System.out.print("A");
				}
				else
				{
					menu[i].setVisible(true);
					System.out.print("AA");
				}
			}
			else if (menu[i].isVisible())
			{
				menu[i].setVisible(false);
				System.out.print("AAA");
			}
		}
		System.out.println("");
		frame.repaint();
		menu[this.CURRENT_MENU].repaint();
		ticks++;
	}
	
	private void set_up_main_menu() {
		menu[MAIN_MENU] = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};
		
		JButton FIGHT = new JButton("FIGHT");
		FIGHT.setBounds(20, 420, 560, 260);
		FIGHT.setOpaque(true);
		FIGHT.setForeground(Color.CYAN);
		FIGHT.addActionListener(
			new ActionListener() 
			{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PREVIOUS_MENU = CURRENT_MENU;
				CURRENT_MENU = FIGHT_MENU;

				System.out.println("Switched to FIGHT_MENU");
			}
		});
		FIGHT.setVisible(true);
		menu[0].add(FIGHT);
		
		
	}
	
	private void set_up_fight_menu() {
		menu[FIGHT_MENU] = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};
	}
	
	private void set_up_team_menu() {
		menu[BAG_MENU] = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};
	}
	
	private void set_up_bag_menu() {
		menu[TEAM_MENU] = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};
	}
	
		
}
