package com.c2w.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.c2w.dao.PlayerDao;
import com.c2w.model.Player;
/**
* Controller class to manage player-related operations.
*/
public class PlayerController {
private PlayerDao c2w_pi_playerDao = new PlayerDao(); // Instance of PlayerDao to interact with the database
/**
* Method to retrieve all players from the database.
* @return A list of all Player objects.
*/
public List<Player> getAllPlayers() {
try {
return c2w_pi_playerDao.getDataList("player"); // Retrieve all players from the "player" collection

} catch (ExecutionException | InterruptedException e) {
e.printStackTrace(); // Print stack trace for debugging
}
return new ArrayList<>(); // Return an empty list if an exception occurs
}
/**
* Method to add a player to the database.
* @param c2w_pi_data The Player object to be added.
* @return true if the player is added successfully, false
otherwise.
*/
public boolean addPlayers(Player c2w_pi_data) {
try {

c2w_pi_playerDao.addData("player", c2w_pi_data.getPlayerName(), c2w_pi_data); // Add player to the "player" collection

return true; // Return true if the player is added successfully

} catch (ExecutionException | InterruptedException e) {
e.printStackTrace(); // Print stack trace for debugging
}
return false; // Return false if an exception occurs
}
/**
* Method to search for players based on a key (playerName or
country).
* @param c2w_pi_key The search key.
* @return A list of Player objects that match the search
key.
*/
public List<Player> getSearchPlayer(String c2w_pi_key) {
try {
return c2w_pi_playerDao.getSearchPlayer(c2w_pi_key);

// Search for players based on the key

} catch (ExecutionException | InterruptedException e) {
e.printStackTrace(); // Print stack trace for debugging
}
return new ArrayList<>(); // Return an empty list if an exception occurs
}
/**
* Method to retrieve all unique countries and their flags
from the player database.
* @return A map where the key is the country name and the
value is the flag URL.
*/

public Map<String, String> getAllCountries() {
Map<String, String> c2w_pi_countries = new HashMap<>();

// Map to store country names and flag URLs

List<Player> c2w_pi_playersList = getAllPlayers(); // Retrieve all players

for (Player c2w_pi_player : c2w_pi_playersList) {
if

(!c2w_pi_countries.containsKey(c2w_pi_player.getCountry())) { //If the country is not already in the map

c2w_pi_countries.put(c2w_pi_player.getCountry(),
c2w_pi_player.getFlag()); // Add country and flag to the map

}
}
return c2w_pi_countries; // Return the map of countries and flags
}
/**
* Method to retrieve all players from a specific country.
* @param c2w_pi_country The name of the country.
* @return A list of Player objects from the specified
country.
*/
public List<Player> getAllPlayersByCountry(String
c2w_pi_country) {
try {
return c2w_pi_playerDao.getDataList("Player",c2w_pi_country); // Retrieve players from the specified country
} catch (ExecutionException | InterruptedException e) {
e.printStackTrace(); // Print stack trace for debugging
}
return new ArrayList<>(); // Return an empty list if an exception occurs
}


}