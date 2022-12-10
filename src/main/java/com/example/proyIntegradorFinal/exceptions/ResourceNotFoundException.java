package com.example.proyIntegradorFinal.exceptions;


public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(){
        super("Recurso no encontrado");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
