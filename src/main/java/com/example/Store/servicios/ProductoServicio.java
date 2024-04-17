package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionProducto;
import com.example.Store.modelos.Producto;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {
    @Autowired
    ValidacionProducto validacionProducto;
    @Autowired
    ProductoRepositorio productoRepositorio;

    public Producto guardarProducto(Producto datosProducto) throws Exception{
        try{
            if (!validacionProducto.validarNombre(datosProducto.getNombreProducto())) {
                throw new Exception("Nombre incorrecto");
            }
            if (!validacionProducto.validarReferencia(datosProducto.getReferencia())) {
                throw new Exception("Referencia incorrecta");
            }
            if (!validacionProducto.validarTalla(datosProducto.getTalla())) {
                throw new Exception("talla incorrecta");
            }
            if (!validacionProducto.validarCantidadBodega(datosProducto.getCantidadBodega())) {
                throw new Exception("Cantidad bodega incorrecta");
            }
            if (!validacionProducto.validPrecioUnitario(datosProducto.getPrecioUnitario())) {
                throw new Exception("precio unitario incorrecto");
            }
            if (!validacionProducto.validarDescripcion(datosProducto.getDescripcion())) {
                throw new Exception("descripcion incorrecta");
            }
            if (!validacionProducto.validarFotografia(datosProducto.getFotografia())) {
                throw new Exception("fotografia incorrecta");
            }
            return productoRepositorio.save(datosProducto);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Producto buscarProductoPorId(Integer idProducto) throws Exception{
        try{
            if (productoRepositorio.findById(idProducto).isPresent()){
                return productoRepositorio.findById(idProducto).get();
            }else{
                throw new Exception("Producto no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
