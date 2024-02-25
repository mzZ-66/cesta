/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pablo
 */
public class Dietetico extends Alimento {
    private int nCalorias;

    public Dietetico(int codigo, String marca, String descripcion, float precio, int nCalorias) {
        super(codigo, marca, descripcion, precio);
        this.nCalorias = nCalorias;
    }

    public int getNCalorias() {
        return nCalorias;
    }
    public void setNCalorias(int nCalorias) {
        this.nCalorias = nCalorias;
    }

    @Override
    public String toString() {
        return "Dietetico{" + super.toString() + "nCalorias=" + nCalorias + '}';
    }
}
