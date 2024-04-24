package com.example.Store.helpers;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
@Component
public class ValidacionPedido {

        public boolean validarFechaYHora(String fechayhora)throws Exception{
        String regex = "^\\d{2}/\\d{2}/\\d{4}$";
        if (!ValidarPatron.evaluarPatron(regex, fechayhora)){
            throw new Exception("Revisa la fecha y hora (dia/mes/año)");
        }

        return true;
    }

}

