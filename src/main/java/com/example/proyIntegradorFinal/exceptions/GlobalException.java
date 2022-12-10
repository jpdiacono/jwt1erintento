package com.example.proyIntegradorFinal.exceptions;

import net.bytebuddy.asm.Advice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.File;

@ControllerAdvice
public class GlobalException {

    private static final Logger logger = LogManager.getLogger(GlobalException.class);
    private final static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> error(ResourceNotFoundException msg){
        logger.error(msg.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg.getMessage());
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> error2(BadRequestException msg){
        logger.error(msg.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg.getMessage());
    }


}

