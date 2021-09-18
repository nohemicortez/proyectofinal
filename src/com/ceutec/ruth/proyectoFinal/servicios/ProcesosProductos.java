package com.ceutec.ruth.proyectoFinal.servicios;

import com.ceutec.ruth.proyectoFinal.modelos.Producto;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcesosProductos {
    // Creación de varios objetos Scanner para los diferentes tipos de entradas por parte del usuario.
    Scanner ingresoString = new Scanner(System.in);
    Scanner ingresoInt = new Scanner(System.in);
    Scanner ingresoDouble = new Scanner(System.in);
    Scanner ingresoBoolean = new Scanner(System.in);
        
    // Títulos de columnas.
    String[] titulosColumnas = {"Codigo", "Nombre", "Marca", "Fecha de elaboracion", "Fecha de caducidad",
        "Seccion", "Promocion", "Temporada", "Porcion", "Precio", "Cantidad en inventario"};
    
    public ProcesosProductos() {
    
    }
    
    // Creación de un producto nuevo (tipo de dato Producto).
    public Producto crearProducto() {
        Producto resultado = new Producto();
        
        // Ingreso de datos por parte del usuario.
        // Se almacenarán en un objeto de tipo Producto.
        System.out.println("Codigo del producto: ");
        resultado.codigo = ingresoString.nextLine();
        System.out.println("Ingrese el nombre del producto: ");
        resultado.nombre = ingresoString.nextLine();
        System.out.println("Ingrese la marca del producto: ");
        resultado.marca = ingresoString.nextLine();
        System.out.println("Ingrese la fecha de elaboracion del producto: ");
        resultado.fechaElaboracion = ingresoString.nextLine();
        System.out.println("Ingrese la fecha de caducidad del producto: ");
        resultado.fechaCaducidad = ingresoString.nextLine();
        System.out.println("Ingrese la seccion del producto: ");
        resultado.seccion = ingresoString.nextLine();
        
        boolean validacion = false;
        String validar = "";
        char letra = 'n';
        
        do {
            System.out.println("¿Esta el producto en promocion? (S o s para sí; N o n para no): ");
            validar = ingresoString.nextLine();
            letra = validar.charAt(0);

            switch(letra){
                case 'S':
                    validacion = true;
                    resultado.promocion = true;
                    break;
                case 's':
                    validacion = true;
                    resultado.promocion = true;
                    break;  
                case 'N':
                    validacion = true;
                    resultado.promocion = false;
                    break;
                case 'n':
                    validacion = true;
                    resultado.promocion = false;
                    break;
                default:
                    validacion = false;
                    System.out.println("Opción inválida");
            }
        } while(!validacion);
      
        do {
            System.out.println("¿Es un producto de temporada? (S o s para sí; N o n para no): ");
            validar = ingresoString.nextLine();
            letra = validar.charAt(0);

            switch(letra){
                case 'S':
                    validacion = true;
                    resultado.temporada = true;
                    break;
                case 's':
                    validacion = true;
                    resultado.temporada = true;
                    break;  
                case 'N':
                    validacion = true;
                    resultado.temporada = false;
                    break;
                case 'n':
                    validacion = true;
                    resultado.temporada = false;
                    break;
                default:
                    validacion = false;
                    System.out.println("Opción inválida.");
            }
        } while(!validacion);
        
        do {
            try {
                System.out.println("Ingrese el precio del producto: ");
                validar = ingresoString.nextLine();

                int conversion = Integer.valueOf(validar);

                if (conversion > 0) {
                    validacion = true;
                    resultado.precio = conversion;
                } else {
                    validacion = false;
                    System.out.println("El numero no puede ser igual o menor que cero.");
                }
            } catch(Exception error) {
                validacion = false;
                System.out.println("Ha introducido un dato no numérico.");
            }
        } while(!validacion);
        
        do {
            try {
                System.out.println("Ingrese la cantidad de productos que hay en inventario: ");
                validar = ingresoString.nextLine();

                int conversion = Integer.valueOf(validar);

                if (conversion > 0) {
                    validacion = true;
                    resultado.cantidadInventario = conversion;
                } else {
                    validacion = false;
                    System.out.println("El numero no puede ser igual o menor que cero.");
                }
            } catch(Exception error) {
                validacion = false;
                System.out.println("Ha introducido un dato no numérico.");
            }
        } while(!validacion);
        
        return resultado;
    }

    // Edición y eliminación de un producto (tipo de dato Producto).
    // Se retornará el índice de la lista mediante comparación por código de producto.
    // El reemplazo o eliminación se hará en la lista en la clase principal del sistema (prodcutos cargados en memoria);
    public int editarYEliminarProducto(ArrayList<Producto> productos, String codigo) {
        int resultado = 0;
        
        // Comparación de código y obtención del índice.
        for (int i = 0; i < productos.size(); i++) {
            if (codigo.compareTo(productos.get(i).codigo) == 0) {
                resultado = i;
                break;
            }
        }
        
        return resultado;
    }

    // Listar todos los productos en la base de datos en formato de tabla.
    public void mostrarProductos(ArrayList<Producto> productos) {
        // Acceder a los títulos accediendo a los elementos del arreglo de títulos.
        System.out.printf("%5s %10s %25s %15s %20s %20s %10s %10s %10s %10s %10s %20s%n", "#",
                    titulosColumnas[0],titulosColumnas[1], titulosColumnas[2], titulosColumnas[3], titulosColumnas[4], titulosColumnas[5],
                    titulosColumnas[6], titulosColumnas[7], titulosColumnas[8],titulosColumnas[9], titulosColumnas[10]);
        dividir(178);
        
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            
            // Mostrar el producto accediendo a los atributos del objeto tipo Producto;
            System.out.printf("%5s %10s %25s %15s %20s %20s %10s %10s %10s %10s %10s %20s%n", (i + 1),
                    producto.codigo, producto.nombre, producto.marca, producto.fechaElaboracion, producto.fechaCaducidad,
                    producto.seccion, producto.promocion, producto.temporada, producto.porcion, producto.precio, producto.cantidadInventario);
        }
    }

    // Mostrar un producto único en formato de tabla.
    public void mostrarProducto(Producto producto) {
        // Acceder a los títulos accediendo a los elementos del arreglo de títulos.
        System.out.printf("%5s %10s %25s %15s %20s %20s %10s %10s %10s %10s %10s %20s%n", "#",
                    titulosColumnas[0],titulosColumnas[1], titulosColumnas[2], titulosColumnas[3], titulosColumnas[4], titulosColumnas[5],
                    titulosColumnas[6], titulosColumnas[7], titulosColumnas[8],titulosColumnas[9], titulosColumnas[10]);
        dividir(178);
        
        // Mostrar el producto accediendo a los atributos del objeto tipo Producto;
        System.out.printf("%5s %10s %25s %15s %20s %20s %10s %10s %10s %10s %10s %20s%n", 1,
                    producto.codigo, producto.nombre, producto.marca, producto.fechaElaboracion, producto.fechaCaducidad,
                    producto.seccion, producto.promocion, producto.temporada, producto.porcion, producto.precio, producto.cantidadInventario);
    }
    
    public boolean existeElProducto(ArrayList<Producto> productos, String codigo) {
        boolean resultado = false;
        
        for (int i = 0; i < productos.size(); i++) {
            if (codigo.compareTo(productos.get(i).codigo) == 0) {
                resultado = true;
                break;
            } else {
                resultado = false;
            }
        }
        
        return resultado;
    }
    
    // Buscar un producto.
    // Se retornará el producto (elemento) de la lista mediante comparación por código de producto.
    public Producto buscarProducto(ArrayList<Producto> productos, String codigo) {
        Producto resultado = new Producto();
        
        for (int i = 0; i < productos.size(); i++) {
            // Comparación de código y obtención del producto.
            if (codigo.compareTo(productos.get(i).codigo) == 0) {
                resultado = productos.get(i);
                break;
            }
        }
        
        return resultado;
    }

    // Ordenamiento de burbuja mediante código de producto.
    public ArrayList<Producto> ordearProductos(ArrayList<Producto> productos) {
        ArrayList<Producto> resultado = productos;
        
        for (int i = 0; i < resultado.size(); i++) {
            for (int j = 0; j < resultado.size() - 1; j++) {
                Producto respaldo = new Producto();
                
                // Comparación de códigos del elemento actual (i) con el siguiente (i + 1).
                if (resultado.get(j).codigo.compareTo(resultado.get(j + 1).codigo) > 0 ) {
                    respaldo = resultado.get(j + 1);
                    resultado.set(j + 1, resultado.get(j));
                    resultado.set(j, respaldo);
                }
            }
        }
        
        return resultado;
    }
    
    // Generar una línea del caracter =, n cantidad de veces.
    public static void dividir(int tamanio) {
        String resultado = "";
        
        for (int i = 0; i < tamanio; i++) {
            resultado += "=";
        }
        
        System.out.println(resultado);
    }

    public void cerrarClase() {
        // Cerrar objetos escanner para librarlos de memoria.
        ingresoString.close();
        ingresoInt.close();
        ingresoDouble.close();
        ingresoBoolean.close();
    }
}
