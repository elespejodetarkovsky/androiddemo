package com.sxtsoft.restpolloloko.model;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Pedido {

    private int id;
    private Date fecha;
    private int mesa;
    private Camarero camarero;
    private List<LineaPedido> lineaPedido;

    public Pedido(){

    }

    public Pedido(int id, Date fecha, int mesa, Camarero camarero, List<LineaPedido> lineaPedido) {
        this.id = id;
        this.fecha = fecha;
        this.mesa = mesa;
        this.camarero = camarero;
        this.lineaPedido = lineaPedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public Camarero getCamarero() {
        return camarero;
    }

    public void setCamarero(Camarero camarero) {
        this.camarero = camarero;
    }

    public List<LineaPedido> getLineaPedido() {
        return lineaPedido;
    }

    public void setLineaPedido(List<LineaPedido> lineaPedido) {
        this.lineaPedido = lineaPedido;
    }
}
