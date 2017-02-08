package com.teamtreehouse;

import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.model.Team;
import com.teamtreehouse.model.Teams;
//import com.teamtreehouse.PlayerComparatorByHeight;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;


public class UI {
  private BufferedReader mReader;
  private Map<String, String> mMenu;
  private Map<String, String> organizersMenu;
  private Map<String, String> coachsMenu;
  private Map<String, String> playersMenu;
  private Map<String, String> teamsMenu;
  private Map<String, String> reportsMenu;
  private String currentMenu = "mainMenu";
  //private Teams mTeams = new Teams();
  private Set<Team> mTeams = new HashSet<Team>();
  //private Map<String, Player> mPlayers = new TreeMap<String, Player>();
  private Set<Player> mAvailablePlayers = new TreeSet<Player>();
  private Map<Integer, Player> availablePlayersMap = new TreeMap<Integer, Player>();
  Map<Integer, Team> teamsMap = new TreeMap();
  private boolean noTeams = true;
  private Set<Player> teamPlayers = new HashSet<Player>();
  private Map<Integer, Player> teamPlayersMap = new TreeMap<Integer, Player>();
  private Team team;
  
  public UI(Set<Team> teams, Set<Player> availablePlayers) {
    mTeams = teams;
    mAvailablePlayers = availablePlayers;
    mReader = new BufferedReader(new InputStreamReader(System.in));
    mMenu = new TreeMap<String, String>();
    mMenu.put("organizer", "Organizer's menu");
    mMenu.put("coach", "Coach's menu");
    mMenu.put("quit", "Quit program");
    organizersMenu = new TreeMap<String, String>();
    organizersMenu.put("mainmenu", "Main menu.");
    organizersMenu.put("teams", "Teams menu.");
    organizersMenu.put("players", "Players menu.");
    organizersMenu.put("reports", "Reports menu.");
    teamsMenu = new TreeMap<String, String>();
    teamsMenu.put("showteams", "Show a list of teams.");
    teamsMenu.put("addteam", "Add a new team.");
    teamsMenu.put("addplayer", "Add a player to a team.");
    teamsMenu.put("removeplayer", "Remove a player from a team.");
    teamsMenu.put("organizer", "Back to organizer's menu.");
    teamsMenu.put("perteam", "Show a list of players per team.");
    teamsMenu.put("available", "Show a list of available players.");
    playersMenu = new TreeMap<String, String>();
    playersMenu.put("register", "Register a new player.");
    playersMenu.put("unregister", "Remove a player from the registrations list.");
    playersMenu.put("available", "Show a list of available players.");
    playersMenu.put("organizer", "Back to organizer's menu.");
    reportsMenu = new TreeMap<String, String>();
    reportsMenu.put("byheight", "Show a list of players sorted by height per team.");
    reportsMenu.put("balance", "Show a League Balance Report by experience.");
    reportsMenu.put("organizer", "Back to organizer's menu.");
    coachsMenu = new TreeMap<String, String>();
    coachsMenu.put("mainmenu", "Main menu.");
    coachsMenu.put("roster", "Print the roster of your team.");
    organizersMenu.put("players", "Players menu.");
    organizersMenu.put("reports", "Reports menu.");
  }
  
  private String promptAction(String currentMenu) throws IOException  {
    String choice = "";
    switch(currentMenu) {
      case "mainMenu":
        choice = showMenu(mMenu);
        break;
      case "organizersMenu":
        choice = showMenu(organizersMenu);
        break;
      case "teamsMenu":
        choice = showMenu(teamsMenu);
        break;
      case "playersMenu":
        choice = showMenu(playersMenu);
        break;
      case "reportsMenu":
        choice = showMenu(reportsMenu);
        break;
      case "coachsMenu":
        choice = showMenu(coachsMenu);
        break;
      default:
        System.out.printf("Unknown choice: %s. Choose again. %n%n%n",
                             currentMenu);
    }
    return choice;
  }
  
  private String showMenu(Map<String, String> menu) throws IOException {
    for (Map.Entry<String, String> option : menu.entrySet()) {
      System.out.printf("%S - %s %n",
                        option.getKey(),
                        option.getValue());
    }
    System.out.printf("%nChoose an option please:  ");
    String choice = mReader.readLine();
    System.out.println("");
    return choice.trim().toLowerCase();
  }
  
  public void run() {
    String choice = "";
    do {
      try {
        choice = promptAction(currentMenu);
        switch(choice) {
          case "organizer":
            currentMenu = "organizersMenu";
            break;
          case "coach":
            currentMenu = "coachsMenu";
            break;
          case "addteam":
            createTeam();
            break;
          case "addplayer":
            addPlayerToTeam();
            break;
          case "removeplayer":
            removePlayerFromTeam();
            break;
          case "showteams":
            showTeams();
            break;
          case "available":
            showAvailablePlayers();
            break;
          case "perteam":
            showPlayersPerTeam();
            break;
          case "byheight":
            playersByHeight();
            break;
          case "balance":
            playersByExperience();
            break;
          case "register":
            // TODO: Register new players
            break;
          case "unregister":
            // TODO: Unregister players
            break;
          case "mainmenu":
            currentMenu = "mainMenu";
            break;
          case "reports":
            currentMenu = "reportsMenu";
            break;
          case "teams":
            currentMenu = "teamsMenu";
            break;
          case "players":
            currentMenu = "playersMenu";
            break;
          case "roster":
            showPlayersPerTeam();
            break;
          case "quit":
            System.out.printf("%nExiting program.%n%n");
            break;
          default:
            System.out.printf("Unknown choice: %s. Choose again. %n%n%n",
                             choice);
        }
      } catch(IOException ioe) {
        System.out.println("Problem with input");
        ioe.printStackTrace();
      }
    } while(!choice.equals("quit"));
  }
  
  public void showTeams() {
    int counter = 1;
    for (Team team : mTeams) {
      teamsMap.put(counter, team);
      counter++;
    }
    if (teamsMap.size() == 0) {
      System.out.printf("%nThere are no teams created yet.%n%n");
      noTeams = true;
    } else {
      noTeams = false;
      System.out.printf("%nNumber | Team Name | Coach Name%n");
      for(Map.Entry<Integer, Team> entry : teamsMap.entrySet()) {
        //System.out.println(Integer.toString(entry.getKey())); for debug loop
        Team team = entry.getValue();
        System.out.printf("%d | %s | %s %n",
                          entry.getKey(),
                          team.getTeamName(), 
                          team.getCoachName());
      }
      System.out.println("");
    }
  }
  
  public void createTeam() throws IOException {
    if (mAvailablePlayers.size() == 0) {
      System.out.printf("%nNot enough players to create more teams%n");
      return;
    }
    System.out.printf("%nEnter the team's name:  ");
    String teamsName = mReader.readLine();
    System.out.printf("%nEnter the coach's name:  ");
    String coachsName = mReader.readLine();
    mTeams.add(new Team(teamsName, coachsName));
    System.out.printf("%nTeam created succesfully.%n%n");
  }
  
  public void showAvailablePlayers() {
    availablePlayersMap.clear();
    int counter = 1;
    for (Player player : mAvailablePlayers) {
      availablePlayersMap.put(counter, player);
      counter++;
    }
    System.out.println("All available players:");
    System.out.println("Number | Lastname | Firstname | Height(in) | Experience |"); 
    for(Map.Entry<Integer, Player> entry : availablePlayersMap.entrySet()) {
      //System.out.println(Integer.toString(entry.getKey())); for debug loop
      int key = entry.getKey();
      Player player = entry.getValue();
      System.out.printf("%d | %s | %s | %d | %s |%n", 
                        key,
                        player.getLastName(),
                        player.getFirstName(),
                        player.getHeightInInches(),
                        player.isPreviousExperience());
    }
    System.out.println("");
  }
  
  public void addPlayerToTeam() throws IOException {
    //System.out.printf("%nI chose to add a player to a team.%n%n");
    // Choose a player
    showAvailablePlayers();
    System.out.printf("%nPlease type the number of the player:  ");
    String playerIndex = mReader.readLine();
    if (!isInteger(playerIndex)) {
      return;
    }
      if (!availablePlayersMap.containsKey(Integer.parseInt(playerIndex))) {
        System.out.printf("%nUnknown choice.%n%n");
        return;
      } else {
        // Choose a team
        showTeams();
        if (noTeams) {
          return;
        } else {
          System.out.printf("%nPlease type the number of the team:  ");
          String teamIndex = mReader.readLine();
          if (!isInteger(teamIndex)) {
            return;
          }
          Team team = teamsMap.get(Integer.parseInt(teamIndex));
          Player player = availablePlayersMap.get(Integer.parseInt(playerIndex));
          team.addPlayer(player);
          mAvailablePlayers.remove(player);
        }
      }
  }
  
  public void removePlayerFromTeam() throws IOException {
    showTeams();
    if (noTeams) {
       return;
    } else {
      System.out.printf("%nPlease type the number of the team:  ");
      String teamIndex = mReader.readLine();
      if (!isInteger(teamIndex)) {
        return;
      }
      showTeamPlayers(teamIndex);
      System.out.printf("%nPlease type the number of the player you want to remove:  ");
      String playerIndex = mReader.readLine();
      if (!isInteger(playerIndex)) {
        return;
      }
      Player player = teamPlayersMap.get(Integer.parseInt(playerIndex));
      boolean playerRemoved = team.removePlayer(player);
      if (!playerRemoved) {
        return;
      }
      System.out.printf("Player removed successfully. %n%n%n");
      mAvailablePlayers.add(player);
    }
  }
  
  public void showTeamPlayers(String teamIndex) {
    team = teamsMap.get(Integer.parseInt(teamIndex));
    teamPlayers = team.players();
    teamPlayersMap.clear();
    int counter = 1;
    for (Player player : teamPlayers) {
      teamPlayersMap.put(counter, player);
      counter++;
    }
    System.out.println("Players in the team:");
    System.out.println("Number | Lastname | Firstname | Height(in) | Experience |"); 
    for(Map.Entry<Integer, Player> entry : teamPlayersMap.entrySet()) {
      int key = entry.getKey();
      Player player = entry.getValue();
      System.out.printf("%d | %s | %s | %d | %s |%n", 
                        key,
                        player.getLastName(),
                        player.getFirstName(),
                        player.getHeightInInches(),
                        player.isPreviousExperience());
    }
  }
  
  public void showPlayersPerTeam() throws IOException {
    showTeams();
    if (noTeams) {
      return;
    } else {
      System.out.printf("%nPlease type the number of the team:  ");
      String teamIndex = mReader.readLine();
      if (!isInteger(teamIndex)) {
        return;
      }
      showTeamPlayers(teamIndex);
      System.out.printf("%n");
    }
  }
  
  public void playersByExperience() throws IOException {
    System.out.printf("%nPlayers by experience per team report:  %n");
    for (Team team : mTeams) {
      List<Player> playerWithExperienceList = new ArrayList<Player>();
      List<Player> playerWithNoExperienceList = new ArrayList<Player>();
      playerWithExperienceList = groupByExperience(team.players(), true);
      playerWithNoExperienceList = groupByExperience(team.players(), false);
      Integer experiencePercentage = (playerWithExperienceList.size()*100)/team.players().size();
      System.out.printf("%nTeam %s has a total of %d%% experienced players:  ",
                       team.getTeamName(),
                       experiencePercentage);
      System.out.printf("%nExperienced: %d " +
                        "%nUnexperienced: %d %n",
                       playerWithExperienceList.size(),
                       playerWithNoExperienceList.size());
    }
    System.out.println("");
  }
  
  public void playersByHeight() throws IOException {
    showTeams();
    if (noTeams) {
      return;
    } else {
      System.out.printf("%nPlease type the number of the team:  ");
      String teamIndex = mReader.readLine();
      if (!isInteger(teamIndex)) {
        return;
      }
      team = teamsMap.get(Integer.parseInt(teamIndex));
      teamPlayers = team.players();
      Map<String, List<Player>> playersByHeightRange = new TreeMap<String, List<Player>>();
      playersByHeightRange.put("35 - 40",
                              groupByHeight(teamPlayers, 35, 40));
      playersByHeightRange.put("41 - 45",
                              groupByHeight(teamPlayers, 41, 45));
      playersByHeightRange.put("46 - 50",
                              groupByHeight(teamPlayers, 46, 50));
      System.out.println("");
      for(Map.Entry<String, List<Player>> entry : playersByHeightRange.entrySet()) {
        System.out.printf("There are %d players with height range %s in this team: %n",
                          entry.getValue().size(),
                          entry.getKey());
        for(Player player : entry.getValue()) {
          System.out.printf("%s, height: %d %n",
                            player.getFullName(),
                            player.getHeightInInches());
        }
        System.out.println("");
      }
    }
  }
  
  public List<Player> groupByHeight(Set<Player> players, int lowerLimit, int upperLimit) {
    Set<Player> playersSet = new HashSet<Player>();
    playersSet = players;
    List<Player> playersByHeightRange = new ArrayList<Player>();
    for (Player player : players) {
      if ((player.getHeightInInches() >= lowerLimit) && (player.getHeightInInches() <= upperLimit)) {
        playersByHeightRange.add(player);
      }
    }
    return playersByHeightRange;
  }
  
  public List<Player> groupByExperience(Set<Player> players, boolean experienced) {
    Set<Player> playersSet = new HashSet<Player>();
    playersSet = players;
    List<Player> playersByExperience = new ArrayList<Player>();
    for (Player player : players) {
      if (experienced) {
        if (player.isPreviousExperience()) {
          playersByExperience.add(player);
        }
      } else {
        if (!player.isPreviousExperience()) {
          playersByExperience.add(player);
        }
      }
    }
    return playersByExperience;
  }
  
  public static boolean isInteger(String s) {
      try { 
          Integer.parseInt(s); 
      } catch(NumberFormatException e) { 
          return false; 
      } catch(NullPointerException e) {
          return false;
      }
      // only got here if we didn't return false
      return true;
  }
  
}