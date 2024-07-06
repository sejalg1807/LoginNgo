package com.form.controller;

import com.form.dataaccess.FormPage1;
import com.form.dataaccess.VSignup;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FormNavigationApp extends Application{
    private Stage prstage;
    private Scene page1Scene,page2Scene;

    private FormPage1 page1;
    private VSignup page2;

    @Override

    public void start(Stage prstage){
        this.prstage=prstage;

        page1=new FormPage1(this);
        page2=new VSignup(this);

        page1Scene=new Scene(page1.getView(),1000,1000);
        page2Scene=new Scene(page2.getView(),1000,1000);

        prstage.setScene(page1Scene);
        prstage.setTitle("--login--");
        prstage.show();
    
    }

    public void navigateToFormPage1(){
        prstage.setScene(page1Scene);
    }
    public void navigateToVSignup(){
        prstage.setScene(page2Scene);
    } 
}
