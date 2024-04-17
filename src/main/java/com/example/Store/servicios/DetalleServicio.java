package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionDetalle;
import com.example.Store.modelos.Detalle;
import com.example.Store.modelos.TipoPrenda;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.DetalleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleServicio {
    @Autowired
    ValidacionDetalle validacionDetalle;
    @Autowired
    DetalleRepositorio detalleRepositorio;

    public Detalle guardarDetalle(Detalle datosDetalle) throws Exception{
        try{
            if (!validacionDetalle.validarCostoTotal(datosDetalle.getCostoTotal())) {
                throw new Exception("Costo Total incorrecto");
            }
            if (!validacionDetalle.validarCantidadProductos(datosDetalle.getCantidadProductos())) {
                throw new Exception("Cantidad productos incorrecta");
            }
            return detalleRepositorio.save(datosDetalle);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Detalle buscarDetallePorId(Integer idDetalle) throws Exception{
        try{
            if (detalleRepositorio.findById(idDetalle).isPresent()){
                return detalleRepositorio.findById(idDetalle).get();
            }else{
                throw new Exception("Detalle no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
