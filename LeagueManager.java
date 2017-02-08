import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.UI;
import com.teamtreehouse.model.Teams;
import com.teamtreehouse.model.Team;


import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;


public class LeagueManager {
  //public static Teams teams = new Teams();
  public static Players mPlayers = new Players();
  public static Set<Player> availablePlayers = new TreeSet<Player>();
  public static Set<Team> mTeams = new TreeSet<Team>();

  public static void main(String[] args) {
    Player[] players = Players.load();
    System.out.printf("%nThere are currently %d registered players.%n%n", players.length);
    // Your code here!
    
    availablePlayers.addAll(Arrays.asList(players));
    // **** PRINT AVAILABLE PLAYERS CODE ****
    /*System.out.println("All available players:");
    for (Player player : availablePlayers) {
      System.out.printf("%s %s %s %s %n", 
                        player.getFirstName(),
                        player.getLastName(),
                        player.getHeightInInches(),
                        player.isPreviousExperience());
    }*/
    // ************
    
    //mPlayers.addPlayersToSet(Players.load());
    //mPlayers.addPlayersToMap(Players.load());
    
    //System.out.printf("%nSet size is: %d %n", mPlayers.playersSet.size());
    
    /*for (Player player : mPlayers.playersSet) {
      System.out.printf("%s%n", player.getFirstName());
    }
    
    for(Map.Entry<String, Player> entry : mPlayers.playersMap.entrySet()) {
      //System.out.println(Integer.toString(entry.getKey())); for debug loop
      String key = entry.getKey();
      Player player = entry.getValue();
      System.out.printf("key: %s, lastname: %s, firstname: %s%n", 
                        key, 
                        player.getFirstName(),
                        player.getLastName());
    }*/
    
    /*for (Iterator<Player> iterator = mPlayers.playersSet.iterator(); iterator.hasNext();) {
      Player o = iterator.next();
      System.out.printf("%s ", o.getFirstName());
    }*/
    
    UI ui = new UI(mTeams, availablePlayers);
    ui.run();
    
  }
  
}
