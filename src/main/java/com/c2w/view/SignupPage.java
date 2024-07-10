package com.c2w.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import com.c2w.controller.BackgroundImageController;
import com.c2w.controller.UserController;
/**
* This class represents the signup page of the application.
*/
public class SignupPage {
private UserController c2w_pi_userController = new UserController(); // Controller for user-related operations
private BackgroundImageController c2w_pi_backgroundImg = new BackgroundImageController(); // Controller for background image
/**
* Creates and returns the signup scene.
*

* @param c2w_pi_backHandler A Runnable to handle the action
of going back to the previous scene.
* @return The signup scene.
*/
public Scene createSignupScene(Runnable c2w_pi_backHandler) {
// Logo image
ImageView c2w_pi_logo = new ImageView("images/c2w.png");
c2w_pi_logo.setFitWidth(40);
c2w_pi_logo.setPreserveRatio(true);
// Title label
Label c2w_pi_title = new Label("Welcome to Players Info");

c2w_pi_title.setStyle("-fx-font-size:25 ;-fx-font-weight: bold; -fx-pref-width: 600; -fx-pref-height: 30; -fx-alignment : CENTER; -fx-text-fill:#FFFFFF");

// Header VBox containing logo and title
VBox c2w_pi_header = new VBox(10, c2w_pi_logo, c2w_pi_title);

c2w_pi_header.setAlignment(Pos.CENTER);
// Label and TextField for username
Label c2w_pi_userLabel = new Label("Username:");
TextField c2w_pi_userTextField = new TextField();
c2w_pi_userTextField.setPromptText("Enter Username");
c2w_pi_userTextField.setFocusTraversable(false);
c2w_pi_userTextField.setStyle("-fx-max-width: 270; -fx-min-height: 30;-fx-background-radius: 15;");
// Label and PasswordField for password
Label c2w_pi_passLabel = new Label("Password:");
PasswordField c2w_pi_passField = new PasswordField();
c2w_pi_passField.setFocusTraversable(false);
c2w_pi_passField.setPromptText("Enter Password");

c2w_pi_passField.setStyle("-fx-min-width: 270; -fx-min-height: 30;-fx-background-radius: 15;");
// Button to trigger signup action
Button c2w_pi_signupButton = new Button("Signup");
c2w_pi_signupButton.setStyle("-fx-pref-width: 70;-fx-min-height: 30;-fx-background-radius: 15; -fx-background-color : #2196F3 ;-fx-text-fill:#FFFFF");

// Label to navigate to login scene
Label c2w_pi_loginButton = new Label("Login");
c2w_pi_loginButton.setStyle(" -fx-background-radius: 15; -fx-text-fill : white");

// TextField to show password in plain text
TextField c2w_pi_textFieldPassword = new TextField();
c2w_pi_textFieldPassword.setPromptText("Enter Password");
c2w_pi_textFieldPassword.setFocusTraversable(false);
c2w_pi_textFieldPassword.setVisible(false);
c2w_pi_textFieldPassword.setStyle("-fx-min-width: 270; -fx-min-height: 30; -fx-background-radius: 15;");
c2w_pi_textFieldPassword.textProperty().bindBidirectional(c2w_pi_passField.textProperty());
// Images for toggle icon
Image c2w_pi_hide = new Image("images/hide.png");
Image c2w_pi_show = new Image("images/show.png");
ImageView c2w_pi_icon = new ImageView(c2w_pi_show);
c2w_pi_icon.setFitWidth(30);
c2w_pi_icon.setPreserveRatio(true);
// HBox for password fields
HBox c2w_pi_passBox = new HBox(10, c2w_pi_passField);
c2w_pi_passBox.setPrefWidth(400);
// HBox for toggle icon

HBox c2w_pi_iconBox = new HBox(10, c2w_pi_icon);
c2w_pi_iconBox.setMaxWidth(70);
c2w_pi_iconBox.setAlignment(Pos.BASELINE_LEFT);
// StackPane for password field and icon
StackPane c2w_pi_passFieldStackPane = new StackPane(c2w_pi_passBox, c2w_pi_iconBox);
c2w_pi_passFieldStackPane.setAlignment(Pos.BASELINE_RIGHT);

// Label for output messages
Label c2w_pi_output = new Label();
c2w_pi_output.setStyle("-fx-text-fill: white;");
// Style the labels
c2w_pi_userLabel.setStyle("-fx-text-fill: white;");
c2w_pi_passLabel.setStyle("-fx-text-fill: white;");
// VBox layouts for the fields and buttons
VBox c2w_pi_fieldBox1 = new VBox(10, c2w_pi_userLabel, c2w_pi_userTextField);

c2w_pi_fieldBox1.setMaxSize(300, 30);
VBox c2w_pi_fieldBox2 = new VBox(10, c2w_pi_passLabel, c2w_pi_passFieldStackPane);

c2w_pi_fieldBox2.setMaxSize(300, 30);
// Set action for the signup button
c2w_pi_signupButton.setOnAction(new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent c2w_pi_event) {
if (!c2w_pi_userTextField.getText().isEmpty() && !c2w_pi_passField.getText().isEmpty()) {

if

(c2w_pi_userController.handleSignup(c2w_pi_userTextField.getText(
), c2w_pi_passField.getText())) {

LoginPage c2w_pi_loginPage = new LoginPage();

c2w_pi_loginPage.getLoginScene();
} else {
c2w_pi_output.setText("User not Registered");

}
} else {
c2w_pi_output.setText("Please Enter Username and Password");
}
}
});
// Set action for the login button
c2w_pi_loginButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent c2w_pi_event) {
c2w_pi_backHandler.run();
}
});
// Toggle visibility of password
c2w_pi_icon.setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent c2w_pi_event) {
if (c2w_pi_passField.isVisible()) {
c2w_pi_passField.setVisible(false);
c2w_pi_textFieldPassword.setVisible(true);
c2w_pi_passBox.getChildren().remove(0);
c2w_pi_passBox.getChildren().add(0, c2w_pi_textFieldPassword);

c2w_pi_icon.setImage(c2w_pi_hide);
} else {
c2w_pi_passField.setVisible(true);

c2w_pi_textFieldPassword.setVisible(false);
c2w_pi_passBox.getChildren().remove(0);
c2w_pi_passBox.getChildren().add(0, c2w_pi_passField);

c2w_pi_icon.setImage(c2w_pi_show);
}
}
});
// Main VBox layout for the signup page
VBox c2w_pi_loginBox = new VBox(20, c2w_pi_header, c2w_pi_fieldBox1, c2w_pi_fieldBox2, c2w_pi_signupButton, c2w_pi_loginButton, c2w_pi_output);

c2w_pi_loginBox.setStyle("-fx-pref-height : 200 ; -fx-alignment : TOP_CENTER ; -fx-padding : 30 ;-fx-background-color : rgba(0, 0, 0, 0.5);");
c2w_pi_loginBox.setAlignment(Pos.CENTER);
c2w_pi_loginBox.setMaxSize(400, 200);
c2w_pi_loginBox.setOpacity(0.8);
// StackPane for the signup page
StackPane c2w_pi_sp = new StackPane(c2w_pi_loginBox);
c2w_pi_sp.setStyle("-fx-background-image:url('" + c2w_pi_backgroundImg.imageData() + "');-fx-background-size: cover; ");

// Return the signup scene
return new Scene(c2w_pi_sp, 1000, 800);
}
}