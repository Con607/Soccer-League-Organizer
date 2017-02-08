package com.teamtreehouse.model;

import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;


public class Teams {
  public Map<Integer, ArrayList> teamsMap = new TreeMap();
  public ArrayList teamArray = new ArrayList(3);

  
  public Map<Integer, ArrayList> getTeams() {
    return teamsMap;
  }

}