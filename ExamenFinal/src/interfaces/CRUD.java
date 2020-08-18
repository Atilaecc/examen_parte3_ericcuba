/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Producto;
import modelo.Proveedor;
/**
 *
 * @author sandr
 */
public interface CRUD {
    public List listarproducto();
    public Producto buscarproducto(int idproducto);
    public boolean agregarproducto(Producto producto);
    public boolean editarproducto(Producto producto);
    public boolean eliminarproducto(Producto producto);    
    
    public List listarproveedor();
    public Proveedor buscarproveedor(int idproveedor);
    public boolean agregarproveedor(Proveedor proveedor);
    public boolean editarproveedor(Proveedor proveedor);
    public boolean eliminarproveedor(Proveedor proveedor);
}
