package com.form.dataaccess;

import javafx.event.EventHandler;
import com.form.controller.FormNavigationApp;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class VSignup {
    private FormNavigationApp app;
    private VBox vb;

    public VSignup(FormNavigationApp app){
        this.app=app;
        initialize();
    }

        private void initialize(){

            Label lb1 =new Label("Name : ");
        TextField txt1=new TextField();

        Label lb2 =new Label("Mobile Number : ");
        TextField txt2=new TextField();

        Label lb3 =new Label("Email : ");
        TextField txt3=new TextField();

        Label lb4 =new Label("UserName : ");
        TextField txt4=new TextField();

        Label lb5 =new Label("Password : ");
        PasswordField txt5=new PasswordField();

        Label lb6 =new Label("Confirm Password : ");
        PasswordField txt6=new PasswordField();

        Button bt1=new Button("Submit");
        bt1.setAlignment(Pos.CENTER);
        /*bt1.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event ){
                System.out.println("Successful !!!!!!");
            }
        });*/

        Button bt2=new Button("Back");
        bt2.setAlignment(Pos.BOTTOM_LEFT);
        bt2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                app.navigateToFormPage1();
            }
            
        });

        GridPane gp=new GridPane();

        gp.add(lb1,0,0);
        gp.add(lb2,0,1);
        gp.add(lb3,0,2);
        gp.add(lb4,0,3);
        gp.add(lb5,0,4);
        gp.add(lb6,0,5);
        gp.add(txt1,1,0);
        gp.add(txt2,1,1);
        gp.add(txt3,1,2);
        gp.add(txt4,1,3);
        gp.add(txt5,1,4);
        gp.add(txt6,1,5);

        gp.setHgap(10);
        gp.setVgap(20);
        gp.setAlignment(Pos.CENTER);

        vb=new VBox(20,gp,bt1);
        vb.setAlignment(Pos.CENTER);
            
        
    }

    public VBox getView(){
        return vb;
    }
   
    
}
