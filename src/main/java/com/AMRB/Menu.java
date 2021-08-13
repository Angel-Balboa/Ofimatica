package com.AMRB;

import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {
    private Parent root;
    private @FXML
    Button btnCom;
    private @FXML Button btnInv;
    private @FXML Button btnHist;

    @FXML public void Invent() throws IOException {
        FXMLLoader Admin = new FXMLLoader(getClass().getResource("Administrar.fxml"));
        Parent root = Admin.load();
        Administrar ad= Admin.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML public void Compras() throws IOException {
        FXMLLoader Com = new FXMLLoader(getClass().getResource("Comprar.fxml"));
        Parent root = Com.load();
        Comprar ad= Com.getController();

        Scene scene2 = new Scene(root);
        Stage stage2 = new Stage();
        stage2.setScene(scene2);
        stage2.show();
    }
}
