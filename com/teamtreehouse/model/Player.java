package com.teamtreehouse.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Player implements Comparable<Player>, Serializable {
  private static final long serialVersionUID = 1L;

  private String firstName;
  private String lastName;
  private int heightInInches;
  private boolean previousExperience;

  public Player(String firstName, String lastName, int heightInInches, boolean previousExperience) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.heightInInches = heightInInches;
    this.previousExperience = previousExperience;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getHeightInInches() {
    return heightInInches;
  }

  public Boolean isPreviousExperience() {
    return previousExperience;
  }
  
  public String getFullName() {
    String fullName = firstName + " " + lastName;
    return fullName;
  }
  
  

  @Override
  public int compareTo(Player other) {
    // We always want to sort by last name then first name
    if (equals(other)){
        return 0;
    }
    int lastNameCompared = lastName.compareTo(other.lastName);
    if (lastNameCompared == 0) {
      return firstName.compareTo(other.firstName);
    }
    return lastNameCompared;
  }
  


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Player)) return false;

    Player player = (Player) o;

    if (heightInInches != player.heightInInches) return false;
    if (previousExperience != player.previousExperience) return false;
    if (!firstName.equals(player.firstName)) return false;
    return lastName.equals(player.lastName);

  }

  @Override
  public int hashCode() {
    int result = firstName.hashCode();
    result = 31 * result + lastName.hashCode();
    result = 31 * result + heightInInches;
    result = 31 * result + (previousExperience ? 1 : 0);
    return result;
  }
}


class PlayerComparatorByHeight implements Comparator<Player> {
  @Override
  public int compare(Player o1, Player o2) {
    return o1.getHeightInInches() - o2.getHeightInInches();
  }
}


