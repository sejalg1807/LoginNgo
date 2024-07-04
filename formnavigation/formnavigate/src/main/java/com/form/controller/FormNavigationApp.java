package com.form.controller;

import com.form.dataaccess.FormPage1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FormNavigationApp extends Application{
    private Stage prstage;
    private Scene page1Scene;

    private FormPage1 page1;

    @Override

    public void start(Stage prstage){
        this.prstage=prstage;

        page1=new FormPage1(this);
        page1Scene=new Scene(page1.getview(),1000,1000);

        prstage.setScene(page1Scene);
        prstage.setTitle("--login--");
        prstage.show();
    
    }

    public void navigateToFormPage1(){
        prstage.setScene(page1Scene);
    }
    
}
