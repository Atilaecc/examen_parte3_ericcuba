/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import java.util.List;
import modelo.Producto;
import modeloDAO.ProductoDAO;
import utils.Leer;
/**
 *
 * @author sandr
 */
public class Index {
    public static void AgregarProducto(){
        String nombre;
        String codigo;
        double precio;
        int stock;          
        String estado;
        System.out.println("Agregar Nuevo Producto");
        System.out.print("Codigo: ");
        codigo = Leer.cadena();
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("precio: ");
        precio= Leer.entero();
        System.out.print("DNI: ");
        stock= Leer.entero();        
        System.out.print("Estado: ");
        estado = Leer.cadena();
        Producto producto = new Producto(codigo, nombre, precio,stock , estado);
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.agregarproducto(producto);
        
    }
    
    public static void EliminarProducto(){
        ListarProducto();
        System.out.print("Ingrese el ID del producto a Eliminar: ");
        int id = Leer.entero();
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.eliminarproducto(id);
    }
    
    public static void EditarProducto(){
        ListarProducto();
        System.out.print("Ingrese el ID del producto a Editar: ");
        int id = Leer.entero();
        String codigo;
        String nombre;
        double precio;
        int stock;        
        String estado;
        System.out.println("Editar Producto");
        System.out.print("Codigo: ");
        codigo = Leer.cadena();
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("precio: ");
        precio= Leer.entero();
        System.out.print("DNI: ");
        stock= Leer.entero();        
        System.out.print("Estado: ");
        estado = Leer.cadena();
        Producto producto = new Producto(codigo, nombre, precio,stock , estado);
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.editarproducto(producto);
    }
    public static void ListarProducto(){
        ProductoDAO productoDAO = new ProductoDAO();
        List<Producto> productos = productoDAO.listarproducto();
        System.out.println("ID\tCodigo\t\tnombre\t\tprecio\t\tstock\t\tEstado");
        for(Producto producto : productos) {
            System.out.println( producto.getIdproducto() + "\t" + 
                                producto.getCodigo() + "\t\t" +
                                darFormato(producto.getNombre()) + "\t\t" + 
                                producto.getPrecio() + "\t\t" +
                                producto.getStock() + "\t\t" +
                                producto.getEstado());            
        }
    }
        
        
      public static String darFormato(String cadena){
        if (cadena.length()>=28) {
            cadena = cadena.substring(0,29) + "..";
        }else if (cadena.length()>=23) {
            // 
        }else if (cadena.length()>=17) {
            cadena = cadena + "\t";
        }else if (cadena.length()>=10) {
            cadena = cadena + "\t\t";
        }
        return cadena;
    }
      
      public static void salir(){
        System.out.println("Gracias por su visita");
    }
      public static void error(int tipo){
        switch(tipo){
            case 1:
                System.out.println("Opción fuera de rango");
                break;
            case 2:
                System.out.println(".....");
                break;
        }
        
    }
      
      public static void menu(){
        System.out.println("Menu Principal");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Eliminar Producto");
        System.out.println("3. Editar Producto");
        System.out.println("4. Listar Producto");
        System.out.println("5. Salir");
        System.out.print("Elegir las opciones [1-5]: ");
        
    }
      
       public static void inicio(){
        int opcion;
        do {            
            menu();
            opcion = Leer.entero();
            switch(opcion){
                case 1:
                    AgregarProducto();
                    break;
                case 2:
                    EliminarProducto();
                    break;
                case 3:
                    EditarProducto();
                    break;
                case 4:
                    ListarProducto();
                    break;
                case 5:
                    salir();
                    break;
                default:
                    error(1);
            }            
        } while (opcion!=5);
    }
    public static void main(String[] args) {
        inicio();
    }
        
    }
    
    
    

