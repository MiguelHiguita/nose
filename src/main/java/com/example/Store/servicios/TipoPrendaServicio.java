package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionTipoPrenda;
import com.example.Store.modelos.TipoPrenda;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.TipoPrendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoPrendaServicio {
    @Autowired
    ValidacionTipoPrenda validacionTipoPrenda;
    @Autowired
    TipoPrendaRepositorio tipoPrendaRepositorio;

    public TipoPrenda guardarTipoPrenda(TipoPrenda datosTipoPrenda) throws Exception{
        try{
           if (!validacionTipoPrenda.validarNombre(datosTipoPrenda.getNombre())) {
               throw new Exception("Nombre incorrecto");
           }
           return tipoPrendaRepositorio.save(datosTipoPrenda);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public TipoPrenda buscarPrendaPorId(Integer idPrenda) throws Exception{
        try{
            if (tipoPrendaRepositorio.findById(idPrenda).isPresent()){
                return tipoPrendaRepositorio.findById(idPrenda).get();
            }else{
                throw new Exception("Prenda no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


}
