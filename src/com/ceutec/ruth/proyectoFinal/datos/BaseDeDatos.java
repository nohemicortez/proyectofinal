/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceutec.ruth.proyectoFinal.datos;

import com.ceutec.ruth.proyectoFinal.modelos.Producto;
import java.util.ArrayList;

public class BaseDeDatos {
    public BaseDeDatos() {
        
    }
    
    public ArrayList<Producto> obtenerBaseDeDatos() {
        ArrayList<Producto> resultado = new ArrayList<Producto>();
        Producto producto;
        
        producto = new Producto(0, "Cafe", "Nestle", "2020", "2021", "Granos", false, false, 150, 80.00, 1500);
        resultado.add(producto);
        
        producto = new Producto(1, "Leche en polvo", "Nido", "2020", "2022", "Lacteos", false, false, 550, 350.00, 1000);
        resultado.add(producto);
        
        producto = new Producto(2, "Azucar", "Morena", "2021", "2023", "Granos", false, false, 180, 50.00, 2000);
        resultado.add(producto);
        
        producto = new Producto(3, "Manteca", "Clover", "2019", "2021", "Granos", false, false, 200, 70.00, 1200);
        resultado.add(producto);
        
        producto = new Producto(4, "Arroz", "Manhatan", "2020", "2022", "Granos", false, false, 450, 12.00, 900);
        resultado.add(producto);
        
        producto = new Producto(5, "Salsa de tomate", "Naturas", "2020", "2022", "Granos", false, false, 120, 150.00, 850);
        resultado.add(producto);
        
        producto = new Producto(6, "Espaquetis", "Bruni", "2020", "2021", "Granos", false, false, 200, 10.00, 500);
        resultado.add(producto);
        
        producto = new Producto(7, "Frijoles", "Suli", "2020", "2023", "Granos", false, false, 800, 150.00, 2000);
        resultado.add(producto);
        
        producto = new Producto(8, "Mantequilla", "Nestle", "2020", "2021", "Lacteos", false, false, 450, 100.00, 600);
        resultado.add(producto);
        
        producto = new Producto(9, "Harina", "La Rosa", "2020", "2023", "Granos", false, false, 453, 85.00, 700);
        resultado.add(producto);
        
        producto = new Producto(10, "Papas Fritas", "Golden Fry", "2020", "2021", "Granos", false, false, 453, 75.00, 400);
        resultado.add(producto);
        
        producto = new Producto(11, "Pan Molde", "Bimbo", "2020", "2021", "Pan", false, false, 560, 55.00, 900);
        resultado.add(producto);
        
        producto = new Producto(12, "Queso", "Sula", "2020", "2021", "Lacteos", false, false, 110, 450.00, 850);
        resultado.add(producto);
        
        producto = new Producto(13, "Corn Flakes", "Kellogg's", "2020", "2023", "Granos", false, false, 530, 150.00, 2100);
        resultado.add(producto);
        
        producto = new Producto(14, "Avena", "Quaker", "2020", "2022", "Granos", false, false, 360, 35.00, 600);
        resultado.add(producto);
        
        return resultado;
    }
}