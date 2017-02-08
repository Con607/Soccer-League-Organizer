package com.teamtreehouse.model;

import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.UI;
import com.teamtreehouse.model.Teams;

import java.util.TreeSet;
import java.util.HashSet;
import java.util.Set;
//import java.util.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Team implements Comparable<Team> {
  private Map<Integer, TreeSet> players = new TreeMap();
  public Map<Integer, ArrayList> teamsMap = new TreeMap();
  private String mTeamName;
  private String mCoachName;
  public TreeSet teamSet = new TreeSet();
  public ArrayList teamArray = new ArrayList(3);
  //private Teams mTeams = new Teams();
  private Set<Team> mTeams = new HashSet<Team>();
  private Set<Player> teamPlayers = new TreeSet<Player>();
  
  public Team(String teamName, String coachName) {
    mTeamName = teamName;
    mCoachName = coachName;
  }
  
  public String getTeamName() {
    return mTeamName;
  }
  
  public String getCoachName() {
    return mCoachName;
  }
  
  public void addPlayer(Player player) {
    teamPlayers.add(player);
  }
  
  public Set<Player> players() {
    return teamPlayers;
  }
  
  public boolean removePlayer(Player player) {
    return teamPlayers.remove(player);
  }
  
  
  
  @Override
  public int compareTo(Team other) {
    // We always want to sort by last name then first name
    if (equals(other)){
        return 0;
    }
    return mTeamName.compareTo(other.mTeamName);
  }

  /*
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Player)) return false;

    Player player = (Player) o;

    if (heightInInches != player.heightInInches) return false;
    if (previousExperience != player.previousExperience) return false;
    if (!firstName.equals(player.firstName)) return false;
    return lastName.equals(player.lastName);

  }*/

  @Override
  public int hashCode() {
    int result = mTeamName.hashCode();
    result = 31 * result + mCoachName.hashCode();
    return result;
  }
  
  
}