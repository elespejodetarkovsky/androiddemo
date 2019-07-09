package com.sxtsoft.restpolloloko.model;

import com.google.gson.annotations.SerializedName;

public class LineaPedido {
    private Producto producto;

    @SerializedName("cantidad")
    private int qt;
    private double precio; //es para ofertas por ejemplos

    public LineaPedido(){

    }

    public LineaPedido(Producto producto, int qt, double precio) {
        this.producto = producto;
        this.qt = qt;
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
