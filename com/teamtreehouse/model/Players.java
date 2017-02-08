package com.teamtreehouse.model;

import com.teamtreehouse.model.Player;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Players {
  public Set<Player> playersSet = new HashSet<Player>();
  public Map<String, Player> playersMap = new TreeMap<String, Player>();
  

  public static Player[] load() {
    return new Player[] {
      new Player("Joe", "Smith", 42, true),
      new Player("Jill", "Tanner", 36, true),
      new Player("Bill", "Bon", 43, true),
      new Player("Eva", "Gordon", 45, false),
      new Player("Matt", "Gill", 40, false),
      new Player("Kimmy", "Stein", 41, false),
      new Player("Sammy", "Adams", 45, false),
      new Player("Karl", "Saygan", 42, true),
      new Player("Suzane", "Greenberg", 44, true),
      new Player("Sal", "Dali", 41, false),
      new Player("Joe", "Kavalier", 39, false),
      new Player("Ben", "Finkelstein", 44, false),
      new Player("Diego", "Soto", 41, true),
      new Player("Chloe", "Alaska", 47, false),
      new Player("Arfalseld", "Willis", 43, false),
      new Player("Phillip", "Helm", 44, true),
      new Player("Les", "Clay", 42, true),
      new Player("Herschel", "Krustofski", 45, true),
      new Player("Andrew", "Chalklerz", 42, true),
      new Player("Pasan", "Membrane", 36, true),
      new Player("Kenny", "Lovins", 35, true),
      new Player("Alena", "Sketchings", 45, false),
      new Player("Carling", "Seacharpet", 40, false),
      new Player("Joseph", "Freely", 41, false),
      new Player("Gabe", "Listmaker", 45, false),
      new Player("Jeremy", "Smith", 42, true),
      new Player("Ben", "Droid", 44, true),
      new Player("James", "Dothnette", 41, false),
      new Player("Nick", "Grande", 39, false),
      new Player("Will", "Guyam", 44, false),
      new Player("Jason", "Seaver", 41, true),
      new Player("Johnny", "Thunder", 47, false),
      new Player("Ryan", "Creedson", 43, false)
    };

  }
  
  /*public void addPlayersToSet(Player[] players) {
    List< Player > list = Arrays.asList(players);
		playersSet = new HashSet< Player >(list);
  }*/
  
  /*public void addPlayersToMap(Player[] players) {
    for (int i = 0; i < players.length; i++) {
      Player player = players[i];
      playersMap.put(player.getLastName() + " " + player.getFirstName(), player);
    }
  }*/

}