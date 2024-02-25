/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pablo
 */
public class Ecologico extends Alimento {
    private String lugarProcedencia;

    public Ecologico(int codigo, String marca, String descripcion, float precio, String lugarProcedencia) {
        super(codigo, marca, descripcion, precio);
        this.lugarProcedencia = lugarProcedencia;
    }

    public String getLugarProcedencia() {
        return lugarProcedencia;
    }
    public void setLugarProcedencia(String lugarProcedencia) {
        this.lugarProcedencia = lugarProcedencia;
    }

    @Override
    public String toString() {
        return "Ecologico{" + super.toString() + "lugarProcedencia=" + lugarProcedencia + '}';
    }
    
}
