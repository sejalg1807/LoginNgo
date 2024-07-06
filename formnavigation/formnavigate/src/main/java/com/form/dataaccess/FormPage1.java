package com.form.dataaccess;
import com.form.controller.FormNavigationApp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class  FormPage1 {

    private FormNavigationApp app;
    private VBox view;
    
    public FormPage1(FormNavigationApp app){
        this.app=app;
        initialize();

    }

    private  void initialize(){
         Label lb1=new Label("--WEBSITE NAME--");
        Label lb2=new Label("SIGN IN  :");
        Label lb3=new Label("SIGNUP : ");

        Label lb4=new Label("Username :");
        TextField txt1=new TextField();
        
        txt1.setMaxWidth(300);



        Label lb5=new Label("Password :");
        PasswordField txt2=new PasswordField();
        txt2.setMaxWidth(300);

        Button bt2=new Button("Log In");
        bt2.setMaxWidth(300);
        bt2.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                //navigate to homepage
            }
        });





        Button bt3=new Button("Volunteer");     
        bt3.setMaxWidth(300);
        bt3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                app.navigateToVSignup();
            
        }
        });

        Button bt4=new Button("Organization");     
        bt4.setMaxWidth(300);

        HBox hb=new HBox(10,lb3,bt3,bt4);
        hb.setAlignment(Pos.CENTER);
        
        view=new VBox(20,lb1,lb2,lb4,txt1,lb5,txt2,bt2,hb);
        view.setAlignment(Pos.CENTER);

        
        
    }
    public  VBox getView(){
        return view;
    } 
    
}
    

