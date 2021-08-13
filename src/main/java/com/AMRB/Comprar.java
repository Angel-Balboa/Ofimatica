package com.AMRB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class Comprar {
    @FXML
    private TableView<ProductoC> tblprod;
    @FXML private TextField txtcant;
    @FXML private TextField txtnom;
    @FXML private TableColumn colProd;
    @FXML private TableColumn colCod;
    @FXML private TableColumn colDes;
    @FXML private TableColumn ColPrec;
    @FXML private TableColumn colCant;
    private Statement st;
    String path = Administrar.class.getResource("Productos.db").toString();
    String url = "jdbc:sqlite:" + path;
    private ObservableList<ProductoC> productos;

    private double total;


    public void initialize() throws SQLException {
        productos = FXCollections.observableArrayList();
        this.colProd.setCellValueFactory(new PropertyValueFactory("Producto"));
        this.colCod.setCellValueFactory(new PropertyValueFactory("CodBar"));
        this.colDes.setCellValueFactory(new PropertyValueFactory("Descripcion"));
        this.ColPrec.setCellValueFactory(new PropertyValueFactory("Precio"));
        this.colCant.setCellValueFactory(new PropertyValueFactory("Cant"));


    }
    public void Añadir(ActionEvent actionEvent) throws SQLException {
        String nombre=txtnom.getText();
        int cant= Integer.parseInt(txtcant.getText());
        String path = Administrar.class.getResource("Productos.db").toString();
        String url = "jdbc:sqlite:" + path;
        System.out.println(url);
        Statement st;
        Connection connection = DriverManager.getConnection(url);
        st=connection.createStatement();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM Productos WHERE Producto='"+nombre+"';");
            ProductoC p = new ProductoC(rs.getString("Producto"),rs.getString("Descripción"),rs.getInt("CodBar"),rs.getDouble("Precio"),cant);
            this.productos.add(p);
            this.tblprod.setItems(productos);
            this.total=total+(rs.getDouble("Precio")*cant);
        }
        catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No se encontro el producto");
            alert.showAndWait();
        }
    }

    public void Comprar(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Cuenta");
        alert.setContentText("El total a pagar es: "+this.total);
        alert.showAndWait();
    }
}
