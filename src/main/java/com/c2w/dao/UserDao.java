package com.c2w.dao;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.c2w.model.UserDetail;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

/**
* Data Access Object (DAO) class for UserDetail entities.
*/
public class UserDao {
public static Firestore c2w_pi_db; // Firestore instance to interact with the database
/**
* Method to add data to a specific document in a collection.
* @param c2w_pi_collection The name of the collection.
* @param c2w_pi_document The name of the document.
* @param data The data to add as a map of key-value pairs.
* @throws ExecutionException If there is an issue executing
the write operation.
* @throws InterruptedException If the thread is interrupted
while waiting for the operation to complete.
*/
public void addData(String c2w_pi_collection, String c2w_pi_document, Map<String, Object> data) throws ExecutionException, InterruptedException {
DocumentReference c2w_pi_docRef = c2w_pi_db.collection(c2w_pi_collection).document(c2w_pi_document); // Reference to the document

ApiFuture<WriteResult> c2w_pi_result = c2w_pi_docRef.set(data); // Set data in the document

c2w_pi_result.get(); // Block until the operation is complete
}
/**
* Method to retrieve a single UserDetail object from a
document in a collection.
* @param c2w_pi_collection The name of the collection.
* @param c2w_pi_document The name of the document.
* @return The UserDetail object.

* @throws ExecutionException If there is an issue executing
the read operation.
* @throws InterruptedException If the thread is interrupted
while waiting for the operation to complete.
*/
public UserDetail getData(String c2w_pi_collection, String c2w_pi_document) throws ExecutionException, InterruptedException
{

try {
DocumentReference c2w_pi_docRef =c2w_pi_db.collection(c2w_pi_collection).document(c2w_pi_document); // Reference to the document

ApiFuture<DocumentSnapshot> c2w_pi_future = c2w_pi_docRef.get(); // Asynchronously retrieve document snapshot

return

c2w_pi_future.get().toObject(UserDetail.class); // Convert document snapshot to UserDetail object
} catch (Exception e) {
e.printStackTrace(); // Print stack trace for debugging

throw e; // Re-throw the exception or handle it based on your application's needs

}
}
}