package com.c2w.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class ImageUpload {
private static final String BUCKET_NAME = "java-fx-firebase-store.appspot.com"; // Replace with your Google Cloud Storage bucket name
/**
* Uploads an image file to Google Cloud Storage and returns
the publicly accessible URL.
* @param c2w_pi_localFilePath The local file path of the
image to upload.
* @param c2w_pi_uploadFileName The name of the file to be
uploaded.
* @return The publicly accessible URL of the uploaded image.
*/
public static String uploadImage(String c2w_pi_localFilePath,String c2w_pi_uploadFileName) {

try {
// Read service account credentials from a JSON file

FileInputStream c2w_pi_serviceAccount = new FileInputStream("players_info/src/main/resources/firebase_private_key.json");

// Authenticate and create a storage instance
Storage c2w_pi_storage = StorageOptions.newBuilder()
.setCredentials(GoogleCredentials.fromStream(c2w_pi_serviceAccount))

.build()
.getService();

// Read bytes from the local file
Path c2w_pi_path = Paths.get(c2w_pi_localFilePath);
byte[] c2w_pi_bytes = Files.readAllBytes(c2w_pi_path);

// Define Blob ID and BlobInfo
BlobId c2w_pi_blobId = BlobId.of(BUCKET_NAME,c2w_pi_uploadFileName);

BlobInfo c2w_pi_blobInfo = BlobInfo.newBuilder(c2w_pi_blobId)

.setContentType("image/jpeg") // Set content type

.setAcl(Arrays.asList(Acl.of(Acl.User.ofAllUsers(),Acl.Role.READER))) // Make file publicly accessible

.build();
// Upload the image bytes to Google Cloud Storage
c2w_pi_storage.create(c2w_pi_blobInfo, c2w_pi_bytes);
// Return the URL of the uploaded image
return "https://storage.googleapis.com/" + BUCKET_NAME + "/" + c2w_pi_uploadFileName;

} catch (IOException e) {
e.printStackTrace();
return null; // Return null if there's an exception


}
}
}