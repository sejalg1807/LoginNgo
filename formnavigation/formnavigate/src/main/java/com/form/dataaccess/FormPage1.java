package com.form.dataaccess;
import com.form.controller.FormNavigationApp;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

        Button bt1=new Button("Username");
        bt1.setMaxWidth(300);



        Button bt2=new Button("Password");     
        bt2.setMaxWidth(300);

        Button bt3=new Button("Volunteer");     
        bt3.setMaxWidth(300);

        Button bt4=new Button("Organization");     
        bt4.setMaxWidth(300);

        HBox hb=new HBox(10,lb3,bt3,bt4);
        hb.setAlignment(Pos.CENTER);
        
        view=new VBox(20,lb1,lb2,bt1,bt2,hb);
        view.setAlignment(Pos.CENTER);

        
        
    }
    public  VBox getview(){
        return view;
    } 
    
}
    

