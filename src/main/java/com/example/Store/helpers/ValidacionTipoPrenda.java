package com.example.Store.helpers;

import org.springframework.stereotype.Component;

@Component
public class ValidacionTipoPrenda {
    public boolean validarNombre(String nombre)throws Exception{
        if (nombre.length()==0){
            throw new Exception("el tipo de prenda no puede estar vacio");
        }
        if (nombre.length()>50){
            throw new Exception("el tipo de prenda no puede tener mas de 50 caracteres");
        }
        String regex="^[a-zA-Z ]+$";
        if (!ValidarPatron.evaluarPatron(regex,nombre)){
            throw new Exception("revisa el el tipo de prenda ingresado ya que solo puede tener letras y espacios");
        }
        return true;
    }
}
