package com.c2w.dao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import com.c2w.model.Player;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
/**
* Data Access Object (DAO) class for Player entities.
*/
    public class PlayerDao {
        public static Firestore c2w_pi_db; // Firestore instance to interact with the database
/**
* Constructor for PlayerDao.
* (Currently empty, but can be used for initialization if
needed)
*/
    public PlayerDao() {
// Constructor (if needed for any initialization)
}
/**

* Method to add data to a specific document in a collection.
* @param c2w_pi_collection The name of the collection.
* @param c2w_pi_document The name of the document.
* @param c2w_pi_data The Player object to add.
* @throws ExecutionException If there is an issue executing
the write operation.
* @throws InterruptedException If the thread is interrupted
while waiting for the operation to complete.
*/
        public void addData(String c2w_pi_collection, String c2w_pi_document, Player c2w_pi_data) throws ExecutionException,InterruptedException {

            DocumentReference c2w_pi_docRef = c2w_pi_db.collection(c2w_pi_collection).document(c2w_pi_document); // Reference to the document

            ApiFuture<WriteResult> c2w_pi_result = c2w_pi_docRef.set(c2w_pi_data); // Set data in the document
            c2w_pi_result.get(); // Block until operation is complete
        }
/**
* Method to retrieve a single Player object from a document
in a collection.
* @param c2w_pi_collection The name of the collection.
* @param c2w_pi_document The name of the document.
* @return The Player object.
* @throws ExecutionException If there is an issue executing
the read operation.
* @throws InterruptedException If the thread is interrupted
while waiting for the operation to complete.
*/
    public Player getData(String c2w_pi_collection, String c2w_pi_document) throws ExecutionException, InterruptedException {

        try {

        DocumentReference c2w_pi_docRef = c2w_pi_db.collection(c2w_pi_collection).document(c2w_pi_document); // Reference to the document

        ApiFuture<DocumentSnapshot> c2w_pi_future = c2w_pi_docRef.get(); // Asynchronously retrieve document snapshot
        return c2w_pi_future.get().toObject(Player.class); //Convert document snapshot to Player object  

        } catch (Exception e) {
        e.printStackTrace(); // Print stack trace for debugging

        throw e; // Re-throw exception or handle based on application's needs

        }
    }
/**
* Method to retrieve a list of Player objects from a
collection.
* @param c2w_pi_collection The name of the collection.
* @return A list of Player objects.
* @throws ExecutionException If there is an issue executing
the read operation.
* @throws InterruptedException If the thread is interrupted
while waiting for the operation to complete.
*/
    public List<Player> getDataList(String c2w_pi_collection)throws ExecutionException, InterruptedException {

        try {
            CollectionReference c2w_pi_colRef = c2w_pi_db.collection(c2w_pi_collection); // Reference to the collection

            ApiFuture<QuerySnapshot> c2w_pi_future = c2w_pi_colRef.get(); // Asynchronously retrieve all documents in collection
            QuerySnapshot c2w_pi_querySnapshot = c2w_pi_future.get(); // Get query snapshot containing all documents

            List<QueryDocumentSnapshot> c2w_pi_documents = c2w_pi_querySnapshot.getDocuments(); // Extract list of document snapshots

            List<Player> c2w_pi_dataList = new ArrayList<>();
            for (QueryDocumentSnapshot c2w_pi_document : c2w_pi_documents) {

                Player c2w_pi_object = c2w_pi_document.toObject(Player.class); // Convert each document snapshot to Player object

                c2w_pi_dataList.add(c2w_pi_object); // Add Player object to list
            }
        return c2w_pi_dataList; // Return list of Player objects

        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging

            throw e; // Re-throw exception or handle based on application's needs
            }
    }
/**
* Method to retrieve a filtered list of Player objects based
on country.
* @param c2w_pi_collection The name of the collection.
* @param country The country to filter by.
* @return A filtered list of Player objects.
* @throws ExecutionException If there is an issue executing
the read operation.
* @throws InterruptedException If the thread is interrupted
while waiting for the operation to complete.
*/
    public List<Player> getDataList(String c2w_pi_collection,String country) throws ExecutionException, InterruptedException {

    try {

    CollectionReference c2w_pi_colRef = c2w_pi_db.collection(c2w_pi_collection); // Reference to the collection

    Query query = c2w_pi_colRef.whereEqualTo("country",country); // Query to filter documents by country

    ApiFuture<QuerySnapshot> c2w_pi_future = query.get();

// Asynchronously retrieve filtered query snapshot
    QuerySnapshot c2w_pi_querySnapshot = c2w_pi_future.get(); // Get query snapshot containing filtered documents

    List<QueryDocumentSnapshot> c2w_pi_documents = c2w_pi_querySnapshot.getDocuments(); // Extract list of document snapshots

    List<Player> c2w_pi_dataList = new ArrayList<>();
    for (QueryDocumentSnapshot c2w_pi_document : c2w_pi_documents) {

        Player c2w_pi_object = c2w_pi_document.toObject(Player.class); // Convert each document snapshot to Player object

        c2w_pi_dataList.add(c2w_pi_object); // Add Player object to list
        }
    return c2w_pi_dataList; // Return filtered list of Player objects

    }catch (Exception e) {
        e.printStackTrace(); // Print stack trace for debugging

        throw e; // Re-throw exception or handle based on application's needs

        }
    }

  

/**
* Method to search for Player objects based on a key
(playerName or country).
* @param c2w_pi_key The key to search by (playerName or
country).

* @return A list of Player objects matching the search key.
* @throws ExecutionException If there is an issue executing
the read operation.
* @throws InterruptedException If the thread is interrupted
while waiting for the operation to complete.
*/
    public List<Player> getSearchPlayer(String c2w_pi_key) throwsExecutionException, InterruptedException {
        CollectionReference c2w_pi_players = c2w_pi_db.collection("player"); // Reference to the "player" collection

        Query c2w_pi_nameQuery = c2w_pi_players.whereEqualTo("playerName", c2w_pi_key); // Query to filter by playerName

        Query c2w_pi_countryQuery = c2w_pi_players.whereEqualTo("country", c2w_pi_key); // Query to filter by country

        ApiFuture<QuerySnapshot> c2w_pi_nameQuerySnapshot = c2w_pi_nameQuery.get(); // Asynchronously retrieve query snapshot for playerName

        ApiFuture<QuerySnapshot> c2w_pi_countryQuerySnapshot = c2w_pi_countryQuery.get(); // Asynchronously retrieve query snapshot for country

        List<QueryDocumentSnapshot> c2w_pi_nameDocuments = c2w_pi_nameQuerySnapshot.get().getDocuments(); // Get documentsmatching playerName query

        List<QueryDocumentSnapshot> countryDocuments = c2w_pi_countryQuerySnapshot.get().getDocuments(); // Get documents matching country query

        Set<DocumentSnapshot> c2w_pi_uniqueDocuments = new HashSet<>();

        c2w_pi_uniqueDocuments.addAll(c2w_pi_nameDocuments); //Add documents from playerName query to set


        c2w_pi_uniqueDocuments.addAll(countryDocuments); // Add documents from country query to set

        List<Player> c2w_pi_userList = new ArrayList<>();
        for (DocumentSnapshot c2w_pi_document :c2w_pi_uniqueDocuments) {

                if (c2w_pi_document.exists()) {
                    Player c2w_pi_user = c2w_pi_document.toObject(Player.class); // Convert document snapshot to Player object

                    c2w_pi_userList.add(c2w_pi_user); // Add Player object to list
            }
        }
        return c2w_pi_userList; // Return list of Player objects matching search key
    }
}