package com.techiteasy.TechItEasy.exceptions;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(){
        super("Error");
    }
    public RecordNotFoundException(String message){
        super(message);
    }
}
