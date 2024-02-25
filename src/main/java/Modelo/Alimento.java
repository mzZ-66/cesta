/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pablo
 */
public class Alimento {
    private int codigo;
    private String marca;
    private String descripcion;
    private float precio;
    
    public Alimento(int codigo, String marca, String descripcion, float precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Alimento{" + "codigo=" + codigo + ", marca=" + marca + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }
}
