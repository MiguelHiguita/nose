package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionMarca;
import com.example.Store.helpers.ValidacionPedido;
import com.example.Store.modelos.Marca;
import com.example.Store.modelos.Pedido;
import com.example.Store.modelos.TipoPrenda;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.MarcaRepositorio;
import com.example.Store.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaServicio {
    @Autowired
    ValidacionMarca validacionMarca;
    @Autowired
    MarcaRepositorio marcaRepositorio;

    public Marca guardarMarca(Marca datosMarca) throws Exception{
        try{
            if (!validacionMarca.validarNombreMarca(datosMarca.getNombreMarca())) {
                throw new Exception("Nombre incorrecto");
            }
            if (!validacionMarca.validarNit(datosMarca.getNit())) {
                throw new Exception("Nit incorrecto");
            }
            if (!validacionMarca.validarAno(datosMarca.getAnoCreacion())) {
                throw new Exception("Año incorrecto");
            }
            return marcaRepositorio.save(datosMarca);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Marca buscarMarcaPorId(Integer idMarca) throws Exception{
        try{
            if (marcaRepositorio.findById(idMarca).isPresent()){
                return marcaRepositorio.findById(idMarca).get();
            }else{
                throw new Exception("Marca no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
