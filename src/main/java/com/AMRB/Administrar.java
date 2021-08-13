package com.AMRB;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.TextBoundsType;

import java.sql.*;

public class Administrar {
    private ObservableList<Producto>productos;
    @FXML private TextField txtNom;
    @FXML private Label lblres;
    @FXML private TextField txtcodigobarras;
    @FXML private TextField txtdesc;
    @FXML private TextField txtprecio;
    @FXML private TextField txtcodbus;
    @FXML private TextField txtNomdel;
    @FXML private TableView<Producto>tblPro;
    @FXML private TableColumn colNom;
    @FXML private TableColumn colCod;
    @FXML private TableColumn colDes;
    @FXML private TableColumn colPrec;

    private Statement st;
    String path = Administrar.class.getResource("Productos.db").toString();
    String url = "jdbc:sqlite:" + path;


    public void initialize() throws SQLException {
        productos = FXCollections.observableArrayList();
        this.colNom.setCellValueFactory(new PropertyValueFactory("Producto"));
        this.colCod.setCellValueFactory(new PropertyValueFactory("CodBar"));
        this.colDes.setCellValueFactory(new PropertyValueFactory("Descripcion"));
        this.colPrec.setCellValueFactory(new PropertyValueFactory("Precio"));

    }
    public void Agregar(ActionEvent actionEvent) throws SQLException {
        String nombre= txtNom.getText();
        int cod = Integer.parseInt(txtcodigobarras.getText());
        String desc= txtdesc.getText();
        double prec= Double.parseDouble(txtprecio.getText());
        String sql= "Insert into Productos values"+"('"+cod+"','"+nombre+"','"+desc+"','"+prec+"')";
        Connection connection = DriverManager.getConnection(url);
        st=connection.createStatement();
        try{
            st.execute(sql);
        }
        catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error en la captura de datos");
            alert.showAndWait();
        }

    }
    public String selectAllFirstNames() throws SQLException {
        String result = "";
        String path = Administrar.class.getResource("Productos.db").toString();
        String url = "jdbc:sqlite:" + path;
        System.out.println(url);
        Statement st;
        Connection connection = DriverManager.getConnection(url);
        st=connection.createStatement();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM Productos;");
            while (rs.next()) {
                // result += rs.getString(1) + " ";
                //result += rs.getString("Nombre") + " ";
                result +=rs.getString("CodBar")+" ";
                result +=rs.getString("Producto")+" ";
                result +=rs.getString("Descripción")+"          ";
                result +=rs.getString("Precio")+"          ";
                System.out.println("-");
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        this.tblPro.setItems(productos);
        return result;
    }
    public void Eliminar(ActionEvent actionEvent) throws SQLException {

        String nombre=txtNomdel.getText();
        String sql= "DELETE FROM Productos Where Producto='"+nombre+"'";
        Connection connection = DriverManager.getConnection(url);
        Statement st;
        st=connection.createStatement();
        try {
            st.execute(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(selectAllFirstNames());
    }

    public void Buscar(ActionEvent actionEvent) throws SQLException {
        String nombre=txtcodbus.getText();
        String result="";
        String path = Administrar.class.getResource("Productos.db").toString();
        String url = "jdbc:sqlite:" + path;
        System.out.println(url);
        Statement st;
        Connection connection = DriverManager.getConnection(url);
        st=connection.createStatement();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM Productos WHERE CodBar='"+nombre+"';");
            Producto p = new Producto(rs.getString("Producto"),rs.getString("Descripción"),rs.getInt("CodBar"),rs.getDouble("Precio"));
            this.productos.add(p);
            this.tblPro.setItems(productos);
        }
        catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No se encontro el producto");
            alert.showAndWait();
        }
    }

    public void Actualizar(ActionEvent actionEvent) throws SQLException {
        String nombre= txtNom.getText();
        int cod = Integer.parseInt(txtcodigobarras.getText());
        String desc= txtdesc.getText();
        double prec= Double.parseDouble(txtprecio.getText());
        String codb=txtcodbus.getText();
        String sql = "UPDATE Productos SET Producto= '"+nombre+"',CodBar='"+cod+"',Descripción='"+desc+"',Precio='"+prec+"' WHERE CodBar='"+codb+"'";
        Connection connection = DriverManager.getConnection(url);
        st=connection.createStatement();
        try{
            st.execute(sql);
            Producto p= new Producto(nombre,desc,cod,prec);
            this.productos.add(p);
            this.tblPro.setItems(productos);
        }
        catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error en la captura de datos");
            alert.showAndWait();
        }
    }
}
