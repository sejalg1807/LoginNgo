package com.c2w.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
/**
* Controller class to fetch and manage background images from the
Unsplash API.
*/
public class BackgroundImageController {
/**
* Method to get response data from the Unsplash API.
* @return URL of the small-sized image or a default image
path in case of failure.
* @throws IOException If an input or output exception
occurred.
*/
public String getResponseData() throws IOException {
// API URL to fetch a random cricket ground image from Unsplash

String c2w_pi_url ="https://api.unsplash.com/photos/random?client_id=WkAm6IeswQZm3YQulmwHAwnMLUQW6cp85UN35MII4XY&width=800&height=600&query=cricket%20ground";

// Open connection to the API URL
HttpURLConnection c2w_pi_httpClient = (HttpURLConnection) new URL(c2w_pi_url).openConnection();

c2w_pi_httpClient.setRequestMethod("GET"); // Set request method to GET

StringBuffer c2w_pi_response = new StringBuffer();
// Get response code from the HTTP request
int c2w_pi_responseCode = c2w_pi_httpClient.getResponseCode();

if (c2w_pi_responseCode == HttpURLConnection.HTTP_OK) {

// If response code is 200 (OK)

// Read the response from the API
BufferedReader c2w_pi_in = new BufferedReader(new InputStreamReader(c2w_pi_httpClient.getInputStream()));

String c2w_pi_inputLine;
// Append each line of the response to the response buffer

while ((c2w_pi_inputLine = c2w_pi_in.readLine()) !=null) {

c2w_pi_response.append(c2w_pi_inputLine);
}
c2w_pi_in.close(); // Close the BufferedReader
// Parse the response JSON object
JSONObject c2w_pi_obj = new
JSONObject(c2w_pi_response.toString());
JSONObject c2w_pi_urlObject = c2w_pi_obj.getJSONObject("urls"); // Get the "urls" object
// Return the URL of the small-sized image
return c2w_pi_urlObject.getString("small");
} else {
// Return default image path if response code is not 200

return "images/default.jpg";
}

}
/**
* Method to fetch image data URL.
* @return URL of the fetched image or a default image path
in case of failure.
*/
public String imageData() {
String c2w_pi_response = null;
try {
c2w_pi_response = getResponseData(); // Fetch response data from the API

} catch (IOException ie) {
ie.printStackTrace(); // Print stack trace for debugging
}
return c2w_pi_response; // Return the image URL or default path
}
}