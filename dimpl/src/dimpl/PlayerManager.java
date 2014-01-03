package dimpl;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

	private PlayerManager() {
		
	}
	
	private static PlayerManager instance = new PlayerManager();
	public static PlayerManager getInstance() {
		return instance;
	}
	
	public void registerPlayer(IPlayer player) {
		players.add(player);
	}
	
	public void unregisterPlayer(IPlayer player) {
		players.remove(player);
	}
	
	private List<IPlayer> players = new ArrayList<IPlayer>();
	
	public List<IPlayer> players() {
		return players;
	}
}
