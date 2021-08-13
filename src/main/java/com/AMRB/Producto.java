package com.AMRB;

public class Producto {
    private String Producto;
    private String Descripcion;
    private int CodBar;
    private double Precio;

    public Producto(String Producto, String Descripcion, int Codbar, double Precio)
    {
        this.Precio=Precio;
        this.CodBar=Codbar;
        this.Producto=Producto;
        this.Descripcion=Descripcion;
    }

    public String getProducto(){
        return Producto;
    }
    public int getCodBar(){
        return CodBar;
    }
    public double getPrecio(){
        return Precio;
    }
    public String getDescripcion(){
        return Descripcion;
    }
}
