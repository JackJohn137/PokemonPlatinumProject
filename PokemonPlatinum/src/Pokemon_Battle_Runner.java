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
	private Timer timer;
	private int ticks;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int INITIAL_X = (int) (screenSize.getWidth() / 2 - 300);
	public static final int X = (int) (600), Y = (int) (800);
	private static final int REFRESH_RATE = 10;
	private final int MAIN_MENU = 0;
	private final int FIGHT_MENU = 1;
	private final int BAG_MENU = 2;
	private final int TEAM_MENU = 3;
	
	public Pokemon_Battle_Runner(Player you, Pokemon_Trainer opponent) throws IOException
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
			jp.setBounds(0, 0, 600, 800);
			jp.setPreferredSize(new Dimension(600, 800));
			jp.setLayout(null);
		}
	}

	public static void main(String[] args) throws IOException {
		new Pokemon_Battle_Runner(you, opponent);
	}

	private void start() {
		frame = new JFrame("Pokemon_Battle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

	//this method is called every time the timer goes off (which right now is every 10 milliseconds = 100 times per second
	protected void updateBattle() {
		for(int i = 0; i < menu.length; i++)
		{
			if (i == this.CURRENT_MENU)
			{
				if (menu[i].isVisible() == false)
				{
					menu[i].setVisible(true);
				}
			}
			else if (menu[i].isVisible())
			{
				menu[i].setVisible(false);
			}
		}
		System.out.println("");
		frame.repaint();
		menu[this.CURRENT_MENU].repaint();
		ticks++;
	}
	
	/**
	 * This is the screen that shows up when battles are initiated
	 * the FIGHT Button enters the screen to pick 4 pokemon moves
	 * the RUN button immediately ends the battle; paying the fee not added yet
	 * the BAG button opens up the pokemon bag, to be added
	 * the TEAM button opens up a menu to switch pokemon
	 */
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
		FIGHT.setForeground(Color.BLACK);
		FIGHT.addActionListener(
			new ActionListener() 
			{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CURRENT_MENU = FIGHT_MENU;
				System.out.println("Switched to FIGHT_MENU");
			}
		});
		
		FIGHT.setVisible(true);
		menu[MAIN_MENU].add(FIGHT);
		
		JButton BAG = new JButton("BAG");
		BAG.setBounds(20, 700, 180, 60);
		BAG.setOpaque(true);
		BAG.setForeground(Color.BLACK);
		BAG.addActionListener(
			new ActionListener() 
			{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CURRENT_MENU = BAG_MENU;
				System.out.println("Switched to BAG_MENU");
			}
		});
		BAG.setVisible(true);
		menu[MAIN_MENU].add(BAG);
		
		JButton RUN = new JButton("RUN");
		RUN.setBounds(210, 700, 180, 60);
		RUN.setOpaque(true);
		RUN.setForeground(Color.BLACK);
		RUN.addActionListener(
			new ActionListener() 
			{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				timer.stop();
				System.out.println("YOU RAN AWAY! COWARD!");
			}
		});
		RUN.setVisible(true);
		menu[MAIN_MENU].add(RUN);
		
		JButton TEAM = new JButton("TEAM");
		TEAM.setBounds(400, 700, 180, 60);
		TEAM.setOpaque(true);
		TEAM.setForeground(Color.BLACK);
		TEAM.addActionListener(
			new ActionListener() 
			{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CURRENT_MENU = TEAM_MENU;
				System.out.println("Switched to TEAM_MENU");
			}
		});
		TEAM.setVisible(true);
		menu[MAIN_MENU].add(TEAM);
	}
	
	private void set_up_fight_menu() {
		menu[FIGHT_MENU] = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};
		
		JButton MOVE_ONE = new JButton("MOVE_ONE");
		MOVE_ONE.setBounds(10, 420, 280, 120);
		MOVE_ONE.setOpaque(true);
		MOVE_ONE.setForeground(Color.BLACK);
		MOVE_ONE.addActionListener(
			new ActionListener() 
			{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You used MOVE_ONE");
			}
		});
		MOVE_ONE.setVisible(true);
		menu[FIGHT_MENU].add(MOVE_ONE);
		
		JButton MOVE_TWO = new JButton("MOVE_TWO");
		MOVE_TWO.setBounds(310, 420, 280, 120);
		MOVE_TWO.setOpaque(true);
		MOVE_TWO.setForeground(Color.BLACK);
		MOVE_TWO.addActionListener(
			new ActionListener() 
			{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You used MOVE_TWO");
			}
		});
		MOVE_TWO.setVisible(true);
		menu[FIGHT_MENU].add(MOVE_TWO);
		
		JButton MOVE_THREE = new JButton("MOVE_THREE");
		MOVE_THREE.setBounds(10, 550, 280, 120);
		MOVE_THREE.setOpaque(true);
		MOVE_THREE.setForeground(Color.BLACK);
		MOVE_THREE.addActionListener(
			new ActionListener() 
			{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You used MOVE_THREE");
			}
		});
		MOVE_THREE.setVisible(true);
		menu[FIGHT_MENU].add(MOVE_THREE);
		
		JButton MOVE_FOUR = new JButton("MOVE_FOUR");
		MOVE_FOUR.setBounds(310, 550, 280, 120);
		MOVE_FOUR.setOpaque(true);
		MOVE_FOUR.setForeground(Color.BLACK);
		MOVE_FOUR.addActionListener(
			new ActionListener() 
			{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You used MOVE_FOUR");
			}
		});
		MOVE_FOUR.setVisible(true);
		menu[FIGHT_MENU].add(MOVE_FOUR);
		
		JButton CANCEL = new JButton("CANCEL");
		CANCEL.setBounds(10, 680, 580, 90);
		CANCEL.setOpaque(true);
		CANCEL.setForeground(Color.BLACK);
		CANCEL.addActionListener(
			new ActionListener() 
			{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CURRENT_MENU = MAIN_MENU;
				System.out.println("Return to MAIN_MENU");
			}
		});
		CANCEL.setVisible(true);
		menu[FIGHT_MENU].add(CANCEL);
	}
	
	private void set_up_bag_menu() {
		menu[BAG_MENU] = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};
	}
	
	private void set_up_team_menu() {
		menu[TEAM_MENU] = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};
		
		
	}	
}
