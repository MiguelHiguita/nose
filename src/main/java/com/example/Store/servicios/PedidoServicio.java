package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionPedido;
import com.example.Store.modelos.Pedido;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServicio {
    @Autowired
    ValidacionPedido validacionPedido;
    @Autowired
    PedidoRepositorio pedidoRepositorio;

    public Pedido guardarPedido(Pedido datosPedido) throws Exception{
        try{
            if (!validacionPedido.validarFechaYHora(datosPedido.getFechaYHora().toLocalDate())) {
                throw new Exception("Fecha/Hora incorrectas");
            }
            return pedidoRepositorio.save(datosPedido);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Pedido buscarPedidoPorId(Integer idPedido) throws Exception{
        try{
            if (pedidoRepositorio.findById(idPedido).isPresent()){
                return pedidoRepositorio.findById(idPedido).get();
            }else{
                throw new Exception("Pedido no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}


