import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.Border;



public class Pokemon_Battle_Runner{
	private static Player you;
	private static Pokemon_Trainer opponent;
	private static Pokemon you_field;
	private static Pokemon opponent_field;
	private static Pokemon_Move you_move;
	private static Pokemon_Move opponent_move;
	private static JFrame frame;
	private static JLabel textbox;
	private static JLabel your_hp;
	private static JLabel their_hp;
	private static int your_hp_max;
	private int your_hp1;
	private int your_hp2;
	private int your_hp3;
	private int your_hp4;
	private int your_hp5;
	private int your_hp6;
	private static int their_hp_max;
	private int their_hp1;
	private int their_hp2;
	private int their_hp3;
	private int their_hp4;
	private int their_hp5;
	private int their_hp6;
	private static JPanel[] menu;
	private static JPanel fight_screen;
	private static Image your_sprite;
	private static Image their_sprite;
	private static int CURRENT_MENU;
	private transient Timer timer;
	private int ticks;
	private Audio a;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int INITIAL_X = (int) (screenSize.getWidth() / 2 - 300);
	public static final int X = (int) (600), Y = (int) (800);
	private static final int REFRESH_RATE = 10;
	private final int MAIN_MENU = 0;
	private final int FIGHT_MENU = 1;
	private final int BAG_MENU = 2;
	private final int TEAM_MENU = 3;
	private static int selected;
	private final Border border;

	public Pokemon_Battle_Runner(Player you, Pokemon_Trainer opponent) throws IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		border = BorderFactory.createLineBorder(Color.getHSBColor(100, 200, 100));
		textbox = new JLabel();
		this.you = you;
		this.opponent = opponent;
		reloadOpponentPokemon();
		this.you_field = you.getPokemon_storage().getPokemon_by_index(0);
		this.opponent_field = opponent.getPokemon_storage().getPokemon_by_index(0);
		try
		{
			this.your_hp1 = this.you.getPokemon_storage().getPokemon_by_index(0).getStats().getMax_Hp();
		}
		catch (Exception e)
		{
			
		}
		try
		{
			this.your_hp2 = this.you.getPokemon_storage().getPokemon_by_index(1).getStats().getMax_Hp();
		}
		catch (Exception e)
		{
			
		}
		try
		{
			this.your_hp3 = this.you.getPokemon_storage().getPokemon_by_index(2).getStats().getMax_Hp();
		}
		catch (Exception e)
		{
			
		}
		try
		{
			this.your_hp4 = this.you.getPokemon_storage().getPokemon_by_index(3).getStats().getMax_Hp();
		}
		catch (Exception e)
		{
			
		}
		try
		{
			this.your_hp5 = this.you.getPokemon_storage().getPokemon_by_index(4).getStats().getMax_Hp();
		}
		catch (Exception e)
		{
			
		}
		try
		{
			this.your_hp6 = this.you.getPokemon_storage().getPokemon_by_index(5).getStats().getMax_Hp();
		}
		catch (Exception e)
		{
			
		}
		try
		{
			this.their_hp1 = this.opponent.getPokemon_storage().getPokemon_by_index(0).getStats().getMax_Hp();
		}
		catch (Exception e)
		{
			
		}
		try
		{
			this.their_hp2 = this.opponent.getPokemon_storage().getPokemon_by_index(1).getStats().getMax_Hp();
		}
		catch (Exception e)
		{
			
		}
		try
		{
			this.their_hp3 = this.opponent.getPokemon_storage().getPokemon_by_index(2).getStats().getMax_Hp();
		}
		catch (Exception e)
		{
			
		}
		try
		{
			this.their_hp4 = this.opponent.getPokemon_storage().getPokemon_by_index(3).getStats().getMax_Hp();
		}
		catch (Exception e)
		{
			
		}
		try
		{
			this.their_hp5 = this.opponent.getPokemon_storage().getPokemon_by_index(4).getStats().getMax_Hp();
		}
		catch (Exception e)
		{
			
		}
		try
		{
			this.their_hp6 = this.opponent.getPokemon_storage().getPokemon_by_index(5).getStats().getMax_Hp();
		}
		catch (Exception e)
		{
			
		}
		your_hp_max = this.your_hp1;
		their_hp_max = this.their_hp1;
		you_move = null;//Will be decided by button
	    opponent_move = null;//Will be decided by button
	    your_sprite = you_field.getBack_image();
	    their_sprite = opponent_field.getFront_image();
		menu = new JPanel[4];
		set_up_menus();
		a=new Audio("Battle_Trainer");

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					try {
						start();
					} catch (LineUnavailableException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
				}
			}
		});
	}

	private void reloadOpponentPokemon() throws IOException {
		System.out.println("Reloading images");
		int burmy = 1, wormadam = 1, cherrim = 1, shellos = 1, gastrodon = 1, giratina = 1;
		String add = "";
		for (int i = 0; i < opponent.getPokemon_storage().getPokemon_storage().length; i++)
		{
			if (opponent.getPokemon_storage().getPokemon_storage()[i] == null)
			{
				break;
			}
			if (opponent.getPokemon_storage().getPokemon_storage()[i].getName().toLowerCase().equals("burmy"))
			{
				switch (burmy)
				{
					case 1: add = "_grass";
					burmy = 2;
					break;
					
					case 2: add = "_sand";
					burmy = 3;
					break;
					
					case 3: add = "_trash";
					burmy = 1;
					break;
				}
			}
			
			if (opponent.getPokemon_storage().getPokemon_storage()[i].getName().toLowerCase().equals("wormadam"))
			{
				switch (wormadam)
				{
					case 1: add = "_grass";
					wormadam = 2;
					break;
					
					case 2: add = "_sand";
					wormadam = 3;
					break;
					
					case 3: add = "_trash";
					wormadam = 1;
					break;
				}
			}
			
			if (opponent.getPokemon_storage().getPokemon_storage()[i].getName().toLowerCase().equals("cherrim"))
			{
				switch (cherrim)
				{
					case 1: add = "_overcast";
					cherrim = 2;
					break;
					
					case 2: add = "_sunshine";
					cherrim = 1;
					break;
				}
			}
			
			if (opponent.getPokemon_storage().getPokemon_storage()[i].getName().toLowerCase().equals("shellos"))
			{
				switch (shellos)
				{
					case 1: add = "_west";
					shellos = 2;
					break;
					
					case 2: add = "_east";
					shellos = 1;
					break;
				}
			}
			
			if (opponent.getPokemon_storage().getPokemon_storage()[i].getName().toLowerCase().equals("gastrodon"))
			{
				switch (gastrodon)
				{
					case 1: add = "_west";
					gastrodon = 2;
					break;
					
					case 2: add = "_east";
					gastrodon = 1;
					break;
				}
			}
			
			if (opponent.getPokemon_storage().getPokemon_storage()[i].getName().toLowerCase().equals("giratina"))
			{
				switch (giratina)
				{
					case 1: add = "_altered";
					giratina = 2;
					break;
					
					case 2: add = "_origin";
					giratina = 1;
					break;
				}
			}
			
			if (opponent.getPokemon_storage().getPokemon_storage()[i].getFront_image() == null)
			{
				opponent.getPokemon_storage().getPokemon_storage()[i].setFront_image(ImageIO.read(getClass().getResource("pokemon_front/" + opponent.getPokemon_storage().getPokemon_storage()[i].getName().toLowerCase() + add + ".front.png")));
			}
			
			if (opponent.getPokemon_storage().getPokemon_storage()[i].getBack_image() == null)
			{
				opponent.getPokemon_storage().getPokemon_storage()[i].setBack_image(ImageIO.read(getClass().getResource("pokemon_back/" + opponent.getPokemon_storage().getPokemon_storage()[i].getName().toLowerCase() + add + ".back.png")));
			}
			
			add = "";
		}
	}

	private void set_up_menus() {
		set_up_main_menu();
		set_up_fight_menu();
		set_up_bag_menu();
		set_up_team_menu();
		set_up_fight_screen();

		for (JPanel jp : menu)
		{
			jp.setBounds(0, 400, 600, 400);
			jp.setPreferredSize(new Dimension(600, 800));
			jp.setLayout(null);
		}

		fight_screen.setBounds(0, 0, 600, 400);
		fight_screen.setPreferredSize(new Dimension(600, 800));
		fight_screen.setLayout(null);

	}

	public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		new Pokemon_Battle_Runner(you, opponent);
	}

	private void start() throws LineUnavailableException, IOException {
		selected = -1;
		frame = new JFrame("Pokemon_Battle");

		//this frame will close when the battle ends, not when you click close window. you can always run if necessary
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		CURRENT_MENU = 0;
		frame.add(menu[MAIN_MENU]);
		frame.add(menu[FIGHT_MENU]);
		frame.add(menu[BAG_MENU]);
		frame.add(menu[TEAM_MENU]);
		frame.add(fight_screen);

		frame.pack();
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setPreferredSize(new Dimension(600, 800));
		frame.setBounds(INITIAL_X, 0, 600, 800);
		frame.pack();
		frame.setVisible(true);
		menu[0].setVisible(true);
		a.playSoundtrack();
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
			if (i == CURRENT_MENU)
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
		
		frame.repaint();
		

		ticks++;
	}

	/**
	 * This method creates the top JPanel that will be displaying the actual fight
	 * This is the top screen of the device
	 */
	private void set_up_fight_screen() {
		fight_screen = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(your_sprite, 20, 200, null);
				g.drawImage(their_sprite, 400, 20, null);
			}
		};

		textbox = new JLabel("What will you do?");
		textbox.setVisible(true);
		textbox.setBounds(20, 310, 560, 80);
		textbox.setOpaque(true);
		textbox.setBackground(Color.WHITE);
		textbox.setFont(new Font("Serif", Font.PLAIN, 16));
		textbox.setBorder(border);

		your_hp = new JLabel("your_hp");
		try
		{
			your_hp.setText(you.getPokemon_storage().getPokemon_by_index(0).getStats().getHp() + "/" + you.getPokemon_storage().getPokemon_by_index(0).getStats().getMax_Hp());
		}
		catch (Exception e)
		{
			System.out.println("YOUR HP IS INVALID");
		}
		your_hp.setVisible(true);
		your_hp.setBounds(20, 120, 60, 20);
		your_hp.setOpaque(false);
		your_hp.setBackground(Color.WHITE);
		your_hp.setFont(new Font("Serif", Font.PLAIN, 16));

		their_hp = new JLabel("their_hp");
		try
		{
			their_hp.setText(opponent.getPokemon_storage().getPokemon_by_index(0).getStats().getHp() + "/" + opponent.getPokemon_storage().getPokemon_by_index(0).getStats().getMax_Hp());
		}
		catch (Exception e)
		{
			System.out.println("YOUR HP IS INVALID");
		}
		their_hp.setVisible(true);
		their_hp.setBounds(420, 20, 60, 20);
		their_hp.setOpaque(false);
		their_hp.setBackground(Color.WHITE);
		their_hp.setFont(new Font("Serif", Font.PLAIN, 16));


		fight_screen.add(textbox);
		fight_screen.add(your_hp);
		fight_screen.add(their_hp);
		fight_screen.setVisible(true);
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
		FIGHT.setBounds(20, 20, 560, 260);
		FIGHT.setOpaque(true);
		FIGHT.setForeground(Color.BLACK);
		FIGHT.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						CURRENT_MENU = FIGHT_MENU;
						textbox.setText("Which move will you use?");
					}
				});
		FIGHT.setVisible(true);
		menu[MAIN_MENU].add(FIGHT);

		JButton BAG = new JButton("BAG");
		BAG.setBounds(20, 300, 180, 60);
		BAG.setOpaque(true);
		BAG.setForeground(Color.BLACK);
		BAG.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						CURRENT_MENU = BAG_MENU;
						textbox.setText("Which Item will you use?");
					}
				});
		BAG.setVisible(true);
		menu[MAIN_MENU].add(BAG);

		JButton RUN = new JButton("RUN");
		RUN.setBounds(210, 300, 180, 60);
		RUN.setOpaque(true);
		RUN.setForeground(Color.BLACK);
		RUN.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						frame.dispose();
						timer.stop();
						try
						{
							you.setCan_move(true);
							a.stop();
						}
						catch (Exception e)
						{
						}
						System.out.println("YOU RAN AWAY! COWARD!");
					}
				});
		RUN.setVisible(true);
		menu[MAIN_MENU].add(RUN);

		JButton TEAM = new JButton("TEAM");
		TEAM.setBounds(400, 300, 180, 60);
		TEAM.setOpaque(true);
		TEAM.setForeground(Color.BLACK);
		TEAM.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						CURRENT_MENU = TEAM_MENU;
						textbox.setText("Which pokemon will you swap?");
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


		JButton MOVE_ONE = new JButton("Move_One");
		try
		{
			MOVE_ONE.setText(you.getPokemon_storage().getPokemon_by_index(0).getMoveset().get(0).getMove_name());
		}
		catch (Exception e)
		{
			textbox.setText("Can't use this move!");
		}
		MOVE_ONE.setBounds(10, 20, 280, 120);
		MOVE_ONE.setOpaque(true);
		MOVE_ONE.setForeground(Color.BLACK);
		MOVE_ONE.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try
						{
							textbox.setText(you.getPokemon_storage().getPokemon_by_index(0).getName() + " used " + you.getPokemon_storage().getPokemon_by_index(0).getMoveset().get(0).getMove_name());
							new Pokemon_Battle_Turn(you.getPokemon_storage().getPokemon_by_index(0), 
									opponent.getPokemon_storage().getPokemon_by_index(0), 
									you.getPokemon_storage().getPokemon_by_index(0).getMoveset().get(0), 
									opponent.getPokemon_storage().getPokemon_by_index(0).getMoveset().get(0));
							CURRENT_MENU = MAIN_MENU;
							their_hp.setText(opponent_field.getStats().getHp() + "/" + their_hp_max);
							your_hp.setText(you_field.getStats().getHp() + "/" + your_hp_max);
							if (you_field.getStats().getHp() <= 0)
							{
								JOptionPane.showMessageDialog(null, "YOU LOST!", "DEFEAT", 1);
								you.setCan_move(true);
								frame.dispose();
								timer.stop();
								a.stop();

							}
							else if (opponent_field.getStats().getHp() <= 0)
							{
								JOptionPane.showMessageDialog(null, "YOU WON!", "VICTORY", 1);
								you.setCan_move(true);
								frame.dispose();
								timer.stop();
								a.stop();

							}
							updateBattle();
						}
						catch (Exception e)
						{
							e.printStackTrace();
							textbox.setText("You used MOVE_ONE");
						}
					}
				});
		MOVE_ONE.setVisible(true);
		menu[FIGHT_MENU].add(MOVE_ONE);

		JButton MOVE_TWO = new JButton("Move_Two");
		try
		{
			MOVE_TWO.setText(you.getPokemon_storage().getPokemon_by_index(0).getMoveset().get(1).getMove_name());
		}
		catch (Exception e)
		{
			textbox.setText("MOVE TWO NOT AVALIABLE");
		}
		MOVE_TWO.setBounds(310, 20, 280, 120);
		MOVE_TWO.setOpaque(true);
		MOVE_TWO.setForeground(Color.BLACK);
		MOVE_TWO.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try
						{
							textbox.setText(you.getPokemon_storage().getPokemon_by_index(0).getName() + " used " + you.getPokemon_storage().getPokemon_by_index(0).getMoveset().get(1).getMove_name());
							new Pokemon_Battle_Turn(you.getPokemon_storage().getPokemon_by_index(0), 
									opponent.getPokemon_storage().getPokemon_by_index(0), 
									you.getPokemon_storage().getPokemon_by_index(0).getMoveset().get(1), 
									opponent.getPokemon_storage().getPokemon_by_index(0).getMoveset().get(1));
							CURRENT_MENU = MAIN_MENU;
							their_hp.setText(opponent_field.getStats().getHp() + "/" + their_hp_max);
							your_hp.setText(you_field.getStats().getHp() + "/" + your_hp_max);
							if (you_field.getStats().getHp() <= 0)
							{
								JOptionPane.showMessageDialog(null, "YOU LOST!", "DEFEAT", 1);
								you.setCan_move(true);
								frame.dispose();
								timer.stop();
								a.stop();

							}
							else if (opponent_field.getStats().getHp() <= 0)
							{
								JOptionPane.showMessageDialog(null, "YOU WON!", "VICTORY", 1);
								you.setCan_move(true);
								frame.dispose();
								timer.stop();
								a.stop();

							}
							updateBattle();
						}
						catch (Exception e)
						{
							textbox.setText("You used MOVE_TWO");
						}
					}
				});
		MOVE_TWO.setVisible(true);
		menu[FIGHT_MENU].add(MOVE_TWO);

		JButton MOVE_THREE = new JButton("Move_Three");
		try
		{
			MOVE_THREE.setText(you.getPokemon_storage().getPokemon_by_index(0).getMoveset().get(2).getMove_name());
		}
		catch (Exception e)
		{
			textbox.setText("MOVE THREE NOT AVALIABLE");
		}
		MOVE_THREE.setBounds(10, 150, 280, 120);
		MOVE_THREE.setOpaque(true);
		MOVE_THREE.setForeground(Color.BLACK);
		MOVE_THREE.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try
						{
							textbox.setText(you.getPokemon_storage().getPokemon_by_index(0).getName() + " used " + you.getPokemon_storage().getPokemon_by_index(0).getMoveset().get(2).getMove_name());
							new Pokemon_Battle_Turn(you.getPokemon_storage().getPokemon_by_index(0), 
									opponent.getPokemon_storage().getPokemon_by_index(0), 
									you.getPokemon_storage().getPokemon_by_index(0).getMoveset().get(2), 
									opponent.getPokemon_storage().getPokemon_by_index(0).getMoveset().get(2));
							CURRENT_MENU = MAIN_MENU;
							their_hp.setText(opponent_field.getStats().getHp() + "/" + their_hp_max);
							your_hp.setText(you_field.getStats().getHp() + "/" + your_hp_max);
							if (you_field.getStats().getHp() <= 0)
							{
								JOptionPane.showMessageDialog(null, "YOU LOST!", "DEFEAT", 1);
								you.setCan_move(true);
								frame.dispose();
								timer.stop();
								a.stop();

							}
							else if (opponent_field.getStats().getHp() <= 0)
							{
								JOptionPane.showMessageDialog(null, "YOU WON!", "VICTORY", 1);
								you.setCan_move(true);
								frame.dispose();
								a.stop();

								timer.stop();
							}
							
							updateBattle();
						}
						catch (Exception e)
						{
							textbox.setText("You used MOVE_THREE");
						}
					}
				});
		MOVE_THREE.setVisible(true);
		menu[FIGHT_MENU].add(MOVE_THREE);

		JButton MOVE_FOUR = new JButton("Move_Four");
		try
		{
			MOVE_FOUR.setText(you.getPokemon_storage().getPokemon_by_index(0).getMoveset().get(3).getMove_name());
		}
		catch (Exception e)
		{
			textbox.setText("MOVE FOUR NOT AVALIABLE");
		}
		MOVE_FOUR.setBounds(310, 150, 280, 120);
		MOVE_FOUR.setOpaque(true);
		MOVE_FOUR.setForeground(Color.BLACK);
		MOVE_FOUR.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try
						{
							textbox.setText(you.getPokemon_storage().getPokemon_by_index(0).getName() + " used " + you.getPokemon_storage().getPokemon_by_index(0).getMoveset().get(3).getMove_name());
							new Pokemon_Battle_Turn(you.getPokemon_storage().getPokemon_by_index(0), 
									opponent.getPokemon_storage().getPokemon_by_index(0), 
									you.getPokemon_storage().getPokemon_by_index(0).getMoveset().get(3), 
									opponent.getPokemon_storage().getPokemon_by_index(0).getMoveset().get(3));
							CURRENT_MENU = MAIN_MENU;
							their_hp.setText(opponent_field.getStats().getHp() + "/" + their_hp_max);
							your_hp.setText(you_field.getStats().getHp() + "/" + your_hp_max);
							if (you_field.getStats().getHp() <= 0)
							{
								JOptionPane.showMessageDialog(null, "YOU LOST!", "DEFEAT", 1);
								you.setCan_move(true);
								frame.dispose();

								a.stop();
								timer.stop();
							}
							else if (opponent_field.getStats().getHp() <= 0)
							{JOptionPane.showMessageDialog(null, "YOU WON!", "VICTORY", 1);
							you.setCan_move(true);
							frame.dispose();
							
							a.stop();
							timer.stop();
							}
							updateBattle();
						}
						catch (Exception e)
						{
							textbox.setText("You used MOVE_FOUR");
						}
					}
				});
		MOVE_FOUR.setVisible(true);
		menu[FIGHT_MENU].add(MOVE_FOUR);

		JButton CANCEL = new JButton("CANCEL");
		CANCEL.setBounds(10, 280, 580, 90);
		CANCEL.setOpaque(true);
		CANCEL.setForeground(Color.BLACK);
		CANCEL.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						CURRENT_MENU = MAIN_MENU;
						textbox.setText("Return to MAIN_MENU");
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

		JButton POKEMON_ONE = new JButton("POKEMON_ONE");
		try 
		{
			POKEMON_ONE.setText(you.getPokemon_storage().getPokemon_by_index(0).getName());
		}
		catch (Exception e)
		{
			System.out.println("POKEMON_ONE NOT AVALIABLE");
		}
		POKEMON_ONE.setBounds(10, 20, 280, 80);
		POKEMON_ONE.setOpaque(true);
		POKEMON_ONE.setForeground(Color.BLACK);
		POKEMON_ONE.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try
						{
							textbox.setText(you.getPokemon_storage().getPokemon_by_index(0).getName() + "is already out in the field!");
						}
						catch (Exception e)
						{
							textbox.setText("Pokemon 1 is already out!");
						}			
					}
				});
		POKEMON_ONE.setVisible(true);
		menu[TEAM_MENU].add(POKEMON_ONE);

		JButton POKEMON_TWO = new JButton("POKEMON_TWO");
		try 
		{
			POKEMON_TWO.setText(you.getPokemon_storage().getPokemon_by_index(1).getName());
		}
		catch (Exception e)
		{
			System.out.println("POKEMON_TWO NOT AVALIABLE");
		}
		POKEMON_TWO.setBounds(310, 20, 280, 80);
		POKEMON_TWO.setOpaque(true);
		POKEMON_TWO.setForeground(Color.BLACK);
		POKEMON_TWO.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try
						{
							you.getPokemon_storage().getPokemon_by_index(1);
							if (selected != 1)
							{
								selected = 1;
								try
								{
									textbox.setText("Switch to " + you.getPokemon_storage().getPokemon_by_index(selected).getName() + "?");
								}
								catch (Exception e)
								{
									textbox.setText("Switch to Pokemon 2?");
								}
							}
							else
							{
								try
								{
									textbox.setText("Send out " + you.getPokemon_storage().getPokemon_by_index(selected).getName());
									you.getPokemon_storage().switchPokemon(0, selected);
									you_field = you.getPokemon_storage().getPokemon_by_index(0);
									your_sprite = you_field.getBack_image();
									POKEMON_ONE.setText(you.getPokemon_storage().getPokemon_by_index(0).getName());
									POKEMON_TWO.setText(you.getPokemon_storage().getPokemon_by_index(selected).getName());
									your_hp_max = your_hp2;
									their_hp.setText(opponent_field.getStats().getHp() + "/" + their_hp_max);
									your_hp.setText(you_field.getStats().getHp() + "/" + your_hp_max);
									your_hp2 = your_hp1;
									your_hp1 = your_hp_max;
									selected = -1;
									updateBattle();
								}
								catch (Exception e)
								{
									textbox.setText("Switched to Pokemon 2");
								}
								CURRENT_MENU = MAIN_MENU;
							}
						}
						catch (Exception e)
						{
							textbox.setText("Pokemon 2 not avaliable");
						}

					}
				});
		POKEMON_TWO.setVisible(true);
		menu[TEAM_MENU].add(POKEMON_TWO);

		JButton POKEMON_THREE = new JButton("POKEMON_THREE");
		try 
		{
			POKEMON_THREE.setText(you.getPokemon_storage().getPokemon_by_index(2).getName());
		}
		catch (Exception e)
		{
			System.out.println("POKEMON_THREE NOT AVALIABLE");
		}
		POKEMON_THREE.setBounds(10, 110, 280, 80);
		POKEMON_THREE.setOpaque(true);
		POKEMON_THREE.setForeground(Color.BLACK);
		POKEMON_THREE.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try
						{
							you.getPokemon_storage().getPokemon_by_index(2);
							if (selected != 2)
							{
								selected = 2;
								try
								{
									textbox.setText("Switch to " + you.getPokemon_storage().getPokemon_by_index(selected).getName() + "?");
								}
								catch (Exception e)
								{
									textbox.setText("Switch to Pokemon 3?");
								}
							}
							else
							{
								try
								{
									textbox.setText("Send out " + you.getPokemon_storage().getPokemon_by_index(selected).getName());
									you.getPokemon_storage().switchPokemon(0, selected);
									you_field = you.getPokemon_storage().getPokemon_by_index(0);
									your_sprite = you_field.getBack_image();
									POKEMON_ONE.setText(you.getPokemon_storage().getPokemon_by_index(0).getName());
									POKEMON_THREE.setText(you.getPokemon_storage().getPokemon_by_index(selected).getName());
									your_hp_max = your_hp3;
									their_hp.setText(opponent_field.getStats().getHp() + "/" + their_hp_max);
									your_hp.setText(you_field.getStats().getHp() + "/" + your_hp_max);
									your_hp3 = your_hp1;
									your_hp1 = your_hp_max;
									selected = -1;
									your_sprite = you_field.getBack_image();
									updateBattle();
								}
								catch (Exception e)
								{
									textbox.setText("Switched to Pokemon 3");
								}
								CURRENT_MENU = MAIN_MENU;
							}
						}
						catch (Exception e)
						{
							textbox.setText("Pokemon 3 not avaliable");
						}
					}
				});
		POKEMON_THREE.setVisible(true);
		menu[TEAM_MENU].add(POKEMON_THREE);

		JButton POKEMON_FOUR = new JButton("POKEMON_FOUR");
		try 
		{
			POKEMON_FOUR.setText(you.getPokemon_storage().getPokemon_by_index(3).getName());
		}
		catch (Exception e)
		{
			System.out.println("POKEMON_FOUR NOT AVALIABLE");
		}
		POKEMON_FOUR.setBounds(310, 110, 280, 80);
		POKEMON_FOUR.setOpaque(true);
		POKEMON_FOUR.setForeground(Color.BLACK);
		POKEMON_FOUR.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try 
						{
							you.getPokemon_storage().getPokemon_by_index(3);
							if (selected != 3)
							{
								selected = 3;
								try
								{
									textbox.setText("Switch to " + you.getPokemon_storage().getPokemon_by_index(selected).getName() + "?");
								}
								catch (Exception e)
								{
									textbox.setText("Switch to Pokemon 4?");
								}
							}
							else
							{
								try
								{
									textbox.setText("Send out " + you.getPokemon_storage().getPokemon_by_index(selected).getName());
									you.getPokemon_storage().switchPokemon(0, selected);
									you_field = you.getPokemon_storage().getPokemon_by_index(0);
									your_sprite = you_field.getBack_image();
									POKEMON_ONE.setText(you.getPokemon_storage().getPokemon_by_index(0).getName());
									POKEMON_FOUR.setText(you.getPokemon_storage().getPokemon_by_index(selected).getName());
									your_hp_max = your_hp4;
									their_hp.setText(opponent_field.getStats().getHp() + "/" + their_hp_max);
									your_hp.setText(you_field.getStats().getHp() + "/" + your_hp_max);
									your_hp4 = your_hp1;
									your_hp1 = your_hp_max;
									selected = -1;
									your_sprite = you_field.getBack_image();
									updateBattle();
								}
								catch (Exception e)
								{
									textbox.setText("Switched to Pokemon 4");
								}
								CURRENT_MENU = MAIN_MENU;
							}
						}
						catch (Exception e)
						{
							textbox.setText("Pokemon 4 is not avaliable");
						}
					}
				});
		POKEMON_FOUR.setVisible(true);
		menu[TEAM_MENU].add(POKEMON_FOUR);

		JButton POKEMON_FIVE = new JButton("POKEMON_FIVE");
		try 
		{
			POKEMON_FIVE.setText(you.getPokemon_storage().getPokemon_by_index(4).getName());
		}
		catch (Exception e)
		{
			System.out.println("POKEMON_FIVE NOT AVALIABLE");
		}
		POKEMON_FIVE.setBounds(10, 200, 280, 80);
		POKEMON_FIVE.setOpaque(true);
		POKEMON_FIVE.setForeground(Color.BLACK);
		POKEMON_FIVE.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try
						{
							you.getPokemon_storage().getPokemon_by_index(4);
							if (selected != 4)
							{
								selected = 4;
								try
								{
									textbox.setText("Switch to " + you.getPokemon_storage().getPokemon_by_index(selected).getName() + "?");
								}
								catch (Exception e)
								{
									textbox.setText("Switch to Pokemon 5?");
								}
							}
							else
							{
								try
								{
									textbox.setText("Send out " + you.getPokemon_storage().getPokemon_by_index(selected).getName());
									you.getPokemon_storage().switchPokemon(0, selected);
									you_field = you.getPokemon_storage().getPokemon_by_index(0);
									your_sprite = you_field.getBack_image();
									POKEMON_ONE.setText(you.getPokemon_storage().getPokemon_by_index(0).getName());
									POKEMON_FIVE.setText(you.getPokemon_storage().getPokemon_by_index(selected).getName());
									your_hp_max = your_hp5;
									their_hp.setText(opponent_field.getStats().getHp() + "/" + their_hp_max);
									your_hp.setText(you_field.getStats().getHp() + "/" + your_hp_max);
									your_hp5 = your_hp1;
									your_hp1 = your_hp_max;
									selected = -1;
									your_sprite = you_field.getBack_image();
									updateBattle();
								}
								catch (Exception e)
								{
									textbox.setText("Switched to Pokemon 5");
								}
								CURRENT_MENU = MAIN_MENU;
							};
						}
						catch (Exception e)
						{
							textbox.setText("Pokemon 5 is not avaliable");
						}
					}
				});
		POKEMON_FIVE.setVisible(true);
		menu[TEAM_MENU].add(POKEMON_FIVE);

		JButton POKEMON_SIX = new JButton("POKEMON_SIX");
		try 
		{
			POKEMON_SIX.setText(you.getPokemon_storage().getPokemon_by_index(5).getName());
		}
		catch (Exception e)
		{
			System.out.println("POKEMON_SIX NOT AVALIABLE");
		}
		POKEMON_SIX.setBounds(310, 200, 280, 80);
		POKEMON_SIX.setOpaque(true);
		POKEMON_SIX.setForeground(Color.BLACK);
		POKEMON_SIX.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try
						{
							you.getPokemon_storage().getPokemon_by_index(5);
							if (selected != 5)
							{
								selected = 5;
								try
								{
									textbox.setText("Switch to " + you.getPokemon_storage().getPokemon_by_index(selected).getName() + "?");	
								}
								catch (Exception e)
								{
									textbox.setText("Switch to Pokemon 6?");
								}
							}
							else
							{
								try
								{
									textbox.setText("Send out " + you.getPokemon_storage().getPokemon_by_index(selected).getName());
									you.getPokemon_storage().switchPokemon(0, selected);
									you_field = you.getPokemon_storage().getPokemon_by_index(0);
									your_sprite = you_field.getBack_image();
									POKEMON_ONE.setText(you.getPokemon_storage().getPokemon_by_index(0).getName());
									POKEMON_SIX.setText(you.getPokemon_storage().getPokemon_by_index(selected).getName());
									your_hp_max = your_hp6;
									their_hp.setText(opponent_field.getStats().getHp() + "/" + their_hp_max);
									your_hp.setText(you_field.getStats().getHp() + "/" + your_hp_max);
									your_hp6 = your_hp1;
									your_hp1 = your_hp_max;
									selected = -1;
									your_sprite = you_field.getBack_image();
									updateBattle();
								}
								catch (Exception e)
								{
									textbox.setText("Switched to Pokemon 6");
								}
								CURRENT_MENU = MAIN_MENU;
							};
						}
						catch (Exception e)
						{
							textbox.setText("Pokemon 6 is not avaliable");
						}
					}
				});
		POKEMON_SIX.setVisible(true);
		menu[TEAM_MENU].add(POKEMON_SIX);

		JButton CANCEL = new JButton("CANCEL");
		CANCEL.setBounds(10, 280, 580, 90);
		CANCEL.setOpaque(true);
		CANCEL.setForeground(Color.BLACK);
		CANCEL.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						CURRENT_MENU = MAIN_MENU;
						textbox.setText("Return to MAIN_MENU");
					}
				});
		CANCEL.setVisible(true);
		menu[TEAM_MENU].add(CANCEL);///WORKING ON POSITIONS 
	}
}
