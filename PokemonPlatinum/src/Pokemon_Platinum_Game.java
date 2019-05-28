import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Pokemon_Platinum_Game implements Serializable{
	private Map_Storage map_storage;
	private Pokedex pokedex;
	private Movelist movelist;
	private Trainer_Map_Storage trainer_map_storage;
	private Player player;
	private Pokemon_Map current_map;
	private int store;
	private Audio transition;
	public Pokemon_Platinum_Game() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		this.pokedex = new Pokedex();
		this.movelist = new Movelist();
		this.map_storage = new Map_Storage();
		this.current_map = map_storage.getPokemon_map("Twinleaf_Town");

		this.player = new Player("Cynthia", "Cynthia", Direction.DOWN);
		this.player.getPokemon_storage().addPokemon(pokedex.getPokemon("Turtwig"));
		this.player.getPokemon_storage().getPokemon_by_index(0).addMove(movelist.getMove("SCRATCH"));
		this.player.getPokemon_storage().getPokemon_by_index(0).addMove(movelist.getMove("SCRATCH"));
		this.player.getPokemon_storage().getPokemon_by_index(0).addMove(movelist.getMove("SCRATCH"));
		this.player.getPokemon_storage().getPokemon_by_index(0).addMove(movelist.getMove("SCRATCH"));
		this.player.getPokemon_storage().getPokemon_by_index(0).setPokemon_Level(new Pokemon_Level(pokedex.getPokemon("Turtwig").getGrowth_rate(), 5));
		System.out.println(this.player.getPokemon_storage().getPokemon_by_index(0).getFront_image());

		this.player.getPokemon_storage().addPokemon(pokedex.getPokemon("Chimchar"));
		this.player.getPokemon_storage().getPokemon_by_index(1).addMove(movelist.getMove("SCRATCH"));
		this.player.getPokemon_storage().getPokemon_by_index(1).addMove(movelist.getMove("SCRATCH"));
		this.player.getPokemon_storage().getPokemon_by_index(1).addMove(movelist.getMove("SCRATCH"));
		this.player.getPokemon_storage().getPokemon_by_index(1).addMove(movelist.getMove("SCRATCH"));
		this.player.getPokemon_storage().getPokemon_by_index(1).setPokemon_Level(new Pokemon_Level(pokedex.getPokemon("Turtwig").getGrowth_rate(), 5));

		this.trainer_map_storage = new Trainer_Map_Storage(pokedex, movelist);

		addTrainers();

		this.player.setGrid_x(8);
		this.player.setGrid_y(12);
		this.transition=new Audio("Wilhelm-scream");
		this.transition.playEffect();
	}

	private void addTrainers() {
		for (Trainer_Map tm : this.trainer_map_storage.getTrainer_map_storage())
		{
			for (Pokemon_Trainer pt : tm.getTrainer_list())
			{
				System.out.println(pt.getGrid_y() + " " + pt.getGrid_x());
				this.map_storage.getPokemon_map(tm.getMap_name()).getTile(pt.getGrid_y(), pt.getGrid_x()).setPokemon_trainer(pt);   
			}
		}
	}

	// What do you want to do when a key is hit?
	public void keyHit(String s) throws IOException, UnsupportedAudioFileException, LineUnavailableException 
	{
		Tile[][] temp = current_map.getGrid();
		int r = player.getGrid_y();
		int c = player.getGrid_x();
		System.out.println("R" + r);
		System.out.println("C" + c);
		if (s.equals("up"))
		{
			player.setDirection(Direction.UP);
			if (player.isCan_move() == true) 
			{
				if (player.getDirection() == Direction.UP)
				{
					if (temp[r - 1][c].getPokemon_trainer() != null)
					{
						this.getCurrent_map().audio().stop();
						System.out.println(this.current_map.audio().running());
						new Pokemon_Battle_Runner(player, temp[r - 1][c].getPokemon_trainer());
						player.setCan_move(false);
					}
					else if (r > 0)
					{
						System.out.println(temp[r - 1][c].getType());
						switch (temp[r - 1][c].getType())
						{
						case 0:
							player.setGrid_y(r - 1);
							store=player.getY_coord();
							player.setGrid_y(r);
							System.out.println(store);
							System.out.println(player.getY_coord());
							break;

						case 1:
							player.setGrid_y(r - 1);
							store=player.getY_coord();
							player.setGrid_y(r);
							System.out.println(store);
							System.out.println(player.getY_coord());
							break;

						case 2:
							break;

						case 3: 
							break;

						case 4:
							break;

						case 5:
							break;

						case 6:
							break;

						case 7:
							break;

						case 8: 
							break;

						case 9:
							System.out.println("WARPING1");
							player.setGrid_y(this.current_map.getTile(r - 1, c).getWarp().getRow());
							player.setGrid_x(this.current_map.getTile(r - 1, c).getWarp().getCol());
							
							System.out.println(player.getGrid_x());
							System.out.println(player.getGrid_y());
							for (Pokemon_Map m : map_storage.getMap_storage())
							{
								if (m.getMap_name().equals(this.current_map.getTile(r - 1, c).getWarp().getWarp_map_name()))
								{
									this.getCurrent_map().audio().stop();
									this.current_map=m;
									if(m.audio()==null) {
										m.setAudio();
									}
									this.transition = new Audio("Wilhelm-scream");

									this.transition.playEffect();
									this.current_map.audio().swapTrack(m.audio());
									store = player.getY_coord()-6;
									break;
								}
							}
							break;

						default:
							System.out.println("??? Tile: Terrain Error");
							break;
						}
					}
					else if (temp[r][c].getType() == 9)
					{
						System.out.println("WARPING2");
						player.setGrid_y(this.current_map.getTile(r, c).getWarp().getRow());
						player.setGrid_x(this.current_map.getTile(r, c).getWarp().getCol());
						for (Pokemon_Map m : map_storage.getMap_storage())
						{
							if (m.getMap_name().equals(this.current_map.getTile(r, c).getWarp().getWarp_map_name()))
							{
								this.getCurrent_map().audio().stop();
								this.current_map = m;
								this.transition.playEffect();
								this.current_map.audio().swapTrack(m.audio());
								store = player.getY_coord();
								break;
							}
						}
					}
				}
				else
				{
					//player.setTurned(!player.isTurned());
					player.setDirection(Direction.UP);
				}
			}
		}
		else if (s.equals("down"))
		{
			player.setDirection(Direction.DOWN);
			if (player.isCan_move() == true) 
			{
				if (player.getDirection() == Direction.DOWN)
				{
					System.out.println("here?");
					if (temp[r + 1][c].getPokemon_trainer() != null)
					{
						this.getCurrent_map().audio().stop();

						new Pokemon_Battle_Runner(player, temp[r + 1][c].getPokemon_trainer());
						player.setCan_move(false);
					}

					else if (r < temp.length - 1)
					{
						System.out.println("prob");
						switch (temp[r + 1][c].getType())
						{
						case 0:
							player.setGrid_y(r + 1);
							store=player.getY_coord();
							player.setGrid_y(r);
							break;

						case 1:
							player.setGrid_y(r + 1);
							store=player.getY_coord();
							player.setGrid_y(r);
							break;

						case 2:
							player.setGrid_y(r + 1);
							store=player.getY_coord();
							player.setGrid_y(r);
							System.out.println(store);
							System.out.println(player.getY_coord());
							break;

						case 3: 

							break;

						case 4:
							break;

						case 5:
							break;

						case 6:
							break;

						case 7:
							break;

						case 8: 
							break;

						case 9:
							System.out.println("WARPING1");
							player.setGrid_y(this.current_map.getTile(r + 1, c).getWarp().getRow());
							player.setGrid_x(this.current_map.getTile(r + 1, c).getWarp().getCol());
							for (Pokemon_Map m : map_storage.getMap_storage())
							{
								if (m.getMap_name().equals(this.current_map.getTile(r + 1, c).getWarp().getWarp_map_name()))
								{
									this.getCurrent_map().audio().stop();
									this.current_map = m;
									if(m.audio()==null) {
										m.setAudio();
									}
									this.transition=new Audio("Wilhelm-scream");

									this.transition.playEffect();
									this.current_map.audio().swapTrack(m.audio());
									store = player.getY_coord()+6;
									break;
								}
							}
							break;

						default:
							System.out.println("??? Tile: Terrain Error");
							break;
						}
					}
					else if (temp[r][c].getType() == 9)
					{
						System.out.println("WARPING2");
						player.setGrid_y(this.current_map.getTile(r, c).getWarp().getRow());
						player.setGrid_x(this.current_map.getTile(r, c).getWarp().getCol());
						for (Pokemon_Map m : map_storage.getMap_storage())
						{
							if (m.getMap_name().equals(this.current_map.getTile(r, c).getWarp().getWarp_map_name()))
							{
								this.getCurrent_map().audio().stop();
								this.current_map = m;
								this.transition.playEffect();
								this.current_map.audio().swapTrack(m.audio());
								store = player.getY_coord();
								break;
							}
						}
					}
				}
				else
				{
					//player.setTurned(!player.isTurned());
					player.setDirection(Direction.DOWN);
				}
			}
		}
		else if (s.equals("left"))
		{
			player.setDirection(Direction.LEFT);
			if (player.isCan_move() == true) 
			{
				if (player.getDirection() == Direction.LEFT)
				{
					if (temp[r][c - 1].getPokemon_trainer() != null)
					{
						this.getCurrent_map().audio().stop();
						new Pokemon_Battle_Runner(player, temp[r][c - 1].getPokemon_trainer());
						player.setCan_move(false);
					}
					else if (c > 0)
					{
						System.out.println(temp[r][c - 1].getType());
						switch (temp[r][c - 1].getType())
						{
						case 0:
							player.setGrid_x(c - 1);
							store=player.getX_coord();
							player.setGrid_x(c);
							break;

						case 1:
							player.setGrid_x(c - 1);
							store=player.getX_coord();
							player.setGrid_x(c);
							while(player.getX_coord()>store) {
								player.setX_coord(player.getX_coord()-1);
							}
							break;

						case 2:
							break;

						case 3: 
							break;

						case 4:
							break;

						case 5:
							break;

						case 6:
							break;

						case 7:
							break;

						case 8: 
							break;

						case 9:
							player.setGrid_y(this.current_map.getTile(r, c - 1).getWarp().getRow());
							player.setGrid_x(this.current_map.getTile(r, c - 1).getWarp().getCol());
							for (Pokemon_Map m : map_storage.getMap_storage())
							{
								if (m.getMap_name().equals(this.current_map.getTile(r, c - 1).getWarp().getWarp_map_name()))
								{
									this.getCurrent_map().audio().stop();
									this.current_map = m;			
									if(m.audio()==null) {
										m.setAudio();
									}
									this.transition=new Audio("Wilhelm-scream");

									this.transition.playEffect();
									this.current_map.audio().swapTrack(m.audio());
									store = player.getX_coord()-8;
									break;
								}
							}
							break;

						default:
							System.out.println("??? Tile: Terrain Error");
							break;
						}
					}
					else if (temp[r][c].getType() == 9)
					{
						player.setGrid_y(this.current_map.getTile(r, c).getWarp().getRow());
						player.setGrid_x(this.current_map.getTile(r, c).getWarp().getCol());
						for (Pokemon_Map m : map_storage.getMap_storage())
						{
							if (m.getMap_name().equals(this.current_map.getTile(r, c).getWarp().getWarp_map_name()))
							{
								this.getCurrent_map().audio().stop();
								this.current_map = m;
								this.transition.playEffect();
								this.current_map.audio().swapTrack(m.audio());
								store = player.getX_coord();
								break;
							}
						}
					}
				}
				else
				{
					//player.setTurned(!player.isTurned());
					player.setDirection(Direction.LEFT);
				}
			}
		}
		else if (s.equals("right"))
		{
			player.setDirection(Direction.RIGHT);
			if (player.isCan_move() == true) 
			{

				if (player.getDirection() == Direction.RIGHT)
				{
					if (temp[r][c + 1].getPokemon_trainer() != null)
					{
						System.out.println();
						this.getCurrent_map().audio().stop();
						new Pokemon_Battle_Runner(player, temp[r][c + 1].getPokemon_trainer());
						player.setCan_move(false);
					}
					else if (c < temp[r].length - 1)
					{
						switch (temp[r][c + 1].getType())
						{
						case 0:
							player.setGrid_x(c + 1);
							store=player.getX_coord();
							player.setGrid_x(c);
							break;

						case 1:
							player.setGrid_x(c + 1);
							store=player.getX_coord();
							player.setGrid_x(c);
							break;

						case 2:
							break;

						case 3: 
							break;

						case 4:
							break;

						case 5:
							break;

						case 6:
							break;

						case 7:
							break;

						case 8: 
							break;

						case 9:
							player.setGrid_y(this.current_map.getTile(r, c + 1).getWarp().getRow());
							player.setGrid_x(this.current_map.getTile(r, c + 1).getWarp().getCol());
							for (Pokemon_Map m : map_storage.getMap_storage())
							{
								if (m.getMap_name().equals(this.current_map.getTile(r, c + 1).getWarp().getWarp_map_name()))
								{
									this.getCurrent_map().audio().stop();
									this.current_map = m;
									if(m.audio()==null) {
										m.setAudio();
									}
									this.transition=new Audio("Wilhelm-scream");

									this.transition.playEffect();
									this.current_map.audio().swapTrack(m.audio());
									store = player.getY_coord()+8;
									break;
								}
							}
							break;

						default:
							System.out.println("??? Tile: Terrain Error");
							break;
						}
					}
					else if (temp[r][c].getType() == 9)
					{
						player.setGrid_y(this.current_map.getTile(r, c).getWarp().getRow());
						player.setGrid_x(this.current_map.getTile(r, c).getWarp().getCol());
						for (Pokemon_Map m : map_storage.getMap_storage())
						{
							if (m.getMap_name().equals(this.current_map.getTile(r, c).getWarp().getWarp_map_name()))
							{
								this.getCurrent_map().audio().stop();
								this.current_map = m;
								this.transition.playEffect();
								this.current_map.audio().swapTrack(m.audio());
								store = player.getX_coord();
								break;
							}
						}
					}
				}
				else
				{
					//player.setTurned(!player.isTurned());
					player.setDirection(Direction.RIGHT);
				}
			}
		}	
	}

	public void draw(Graphics g) {
		if(player.getDirection().equals(Direction.UP)) {
			if(!player.isTurned() && player.getY_coord()>store) {
				if(player.getY_coord()-player.getSlide_y()<6) {
					player.setY_coord(player.getSlide_y()-3);
					g.drawImage(player.getMovements().getUp().getMove_1(),player.getX_coord(),player.getSlide_y(),null);
				}
				else {
					player.setY_coord(player.getSlide_y()-3);
					g.drawImage(player.getMovements().getUp().getMove_2(),player.getX_coord(),player.getSlide_y(),null);
				}
			}
			else {
				g.drawImage(player.getMovements().getUp().getStop(),player.getX_coord(),player.getSlide_y(),null);
			}
		}
		if(player.getDirection().equals(Direction.DOWN)) {
			if(!player.isTurned() && player.getY_coord()<store) {
				if(Math.abs(player.getY_coord()-player.getSlide_y())<6) {
					player.setY_coord(player.getSlide_y()+3);
					g.drawImage(player.getMovements().getDown().getMove_1(),player.getX_coord(),player.getSlide_y(),null);
				}
				else {
					player.setY_coord(player.getSlide_y()+3);
					g.drawImage(player.getMovements().getDown().getMove_2(),player.getX_coord(),player.getSlide_y(),null);
				}
			}
			else {
				g.drawImage(player.getMovements().getDown().getStop(),player.getX_coord(),player.getSlide_y(),null);
			}}
		if(player.getDirection().equals(Direction.LEFT)) {
			if(!player.isTurned() && player.getX_coord()>store) {
				if(Math.abs(player.getX_coord()-player.getSlide_x())<8) {
					player.setX_coord(player.getSlide_x()-4);
					g.drawImage(player.getMovements().getLeft().getMove_1(),player.getSlide_x(),player.getY_coord(),null);
				}
				else {
					player.setX_coord(player.getSlide_x()-4);
					g.drawImage(player.getMovements().getLeft().getMove_2(),player.getSlide_x(),player.getY_coord(),null);
				}
			}
			else {
				g.drawImage(player.getMovements().getLeft().getStop(),player.getX_coord(),player.getSlide_y(),null);
			}}
		if(player.getDirection().equals(Direction.RIGHT)) {
			if(!player.isTurned() && player.getX_coord()<store) {
				if(Math.abs(player.getX_coord()-player.getSlide_x())<8) {
					player.setX_coord(player.getSlide_x()+4);
					g.drawImage(player.getMovements().getRight().getMove_1(),player.getSlide_x(),player.getY_coord(),null);
				}
				else {
					player.setX_coord(player.getSlide_x()+4);
					g.drawImage(player.getMovements().getRight().getMove_2(),player.getSlide_x(),player.getY_coord(),null);
				}
			}
			else {
				g.drawImage(player.getMovements().getRight().getStop(),player.getX_coord(),player.getSlide_y(),null);
			}
		}
	}

	public Player getPlayer()
	{
		return player;
	}

	public Pokemon_Map getCurrent_map()
	{
		return current_map;
	}

	public Pokedex getPokedex() {
		return pokedex;
	}

	public void setPokedex(Pokedex pokedex) {
		this.pokedex = pokedex;
	}

	public Movelist getMovelist() {
		return movelist;
	}

	public void setMovelist(Movelist movelist) {
		this.movelist = movelist;
	}

	public Trainer_Map_Storage getTrainer_map_storage() {
		return trainer_map_storage;
	}

	public void setTrainer_map_storage(Trainer_Map_Storage trainer_map_storage) {
		this.trainer_map_storage = trainer_map_storage;
	}
}