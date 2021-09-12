/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceutec.ruth.proyectoFinal.modelos;

public class Producto {
    public int codigo = 0;
    public String nombre = "";
    public String marca = "";
    public String fechaElaboracion = "";
    public String fechaCaducidad = "";
    public String seccion = "";
    public boolean promocion = false;
    public boolean temporada = false;
    public int porcion = 0;
    public double precio = 0.00;
    public int cantidadInventario = 0;
    
    public Producto() {
    
    }
    
    public Producto(
        int newCodigo,
        String newNombre,
        String newMarca,
        String newFechaElaboracion,
        String newFechaCaducidad,
        String newSeccion,
        boolean newPromocion,
        boolean newTemporada,
        int newPorcion,
        double newPrecio,
        int newCantidadInventario
    ) {
        codigo = newCodigo;
        nombre = newNombre;
        marca = newMarca;
        fechaElaboracion = newFechaElaboracion;
        fechaCaducidad = newFechaCaducidad;
        seccion = newSeccion;
        promocion = newPromocion;
        temporada = newTemporada;
        porcion = newPorcion;
        precio = newPrecio;
        cantidadInventario = newCantidadInventario;
    }        
}
