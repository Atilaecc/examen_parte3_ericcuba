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
import modelo.Proveedor;
import modeloDAO.ProveedorDAO;
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
    
    public static void AgregarProveedor(){
        String nombre;
        
        String ruc;
        String direccion;          
        String estado;
        System.out.println("Agregar Nuevo Proveedor");
      
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("ruc: ");
        ruc= Leer.cadena();
        System.out.print("direccion: ");
        direccion= Leer.cadena();        
        System.out.print("Estado: ");
        estado = Leer.cadena();
        Proveedor proveedor = new Proveedor( nombre, ruc,direccion , estado);
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorDAO.agregarproveedor(proveedor);
        
    }
    public static void EliminarProducto(){
        ListarProducto();
        System.out.print("Ingrese el ID del producto a Eliminar: ");
        int id = Leer.entero();
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.eliminarproducto(id);
    }
    public static void EliminarProveedor(){
        ListarProveedor();
        System.out.print("Ingrese el ID del proveedor a Eliminar: ");
        int id = Leer.entero();
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorDAO.eliminarproveedor(id);
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
    
    public static void EditarProveedor(){
        ListarProveedor();
        System.out.print("Ingrese el ID del proveedor a Editar: ");
        int id = Leer.entero();
        
        String nombre;
        String ruc;
        String direccion;        
        String estado;
        System.out.println("Editar Proveedor");
        
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("ruc: ");
        ruc= Leer.cadena();
        System.out.print("direccion: ");
        direccion= Leer.cadena();        
        System.out.print("Estado: ");
        estado = Leer.cadena();
        Proveedor proveedor = new Proveedor( nombre, ruc,direccion , estado);
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorDAO.editarproveedor(proveedor);
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
        
        public static void ListarProveedor(){
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        List<Proveedor> proveedores = proveedorDAO.listarproveedor();
        System.out.println("ID\t\tnombre\t\truc\t\tdireccion\t\tEstado");
        for(Proveedor proveedor : proveedores) {
            System.out.println( proveedor.getIdproveedor() + "\t" + 
                               
                                darFormato(proveedor.getNombre()) + "\t\t" + 
                                proveedor.getRuc() + "\t\t" +
                                proveedor.getDireccion() + "\t\t" +
                                proveedor.getEstado());            
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
        System.out.println("5. Agregar Proveedor");
        System.out.println("6. Eliminar Proveedor");
        System.out.println("7. Editar Proveedor");
        System.out.println("8. Listar Proveedor");
        System.out.println("9. Salir");
        System.out.print("Elegir las opciones [1-9]: ");
        
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
                    AgregarProveedor();
                    break;
                case 6:
                    EliminarProveedor();
                    break;
                case 7:
                    EditarProveedor();
                    break;
                case 8:
                    ListarProveedor();
                    break;
                case 9:
                    salir();
                    break;
                default:
                    error(1);
            }            
        } while (opcion!=9);
    }
    public static void main(String[] args) {
        inicio();
    }
        
    }
    
    
    

