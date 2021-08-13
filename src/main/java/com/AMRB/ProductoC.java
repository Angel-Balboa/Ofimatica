package com.AMRB;

public class ProductoC {
    private String Producto;
    private String Descripcion;
    private int CodBar;
    private double Precio;
    private int Cant;

    public ProductoC(String Producto, String Descripcion, int Codbar, double Precio, int Cant)
    {
        this.Cant=Cant;
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
    public int getCant(){return Cant;}
    public String getDescripcion(){
        return Descripcion;
    }
}
