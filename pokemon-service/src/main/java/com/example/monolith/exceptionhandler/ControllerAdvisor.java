package com.example.monolith.exceptionhandler;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "Message";

    @ExceptionHandler(FeignException.FeignClientException.class)
    public ResponseEntity<Map<String, String>> handlePokemonNotFoundException(
            PhotoNotFoundException photoNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }
    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePokemonNotFoundException(
            PokemonNotFoundException pokemonNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.POKEMON_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(PokemonAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handlePokemonAlreadyExistsException(
            PokemonAlreadyExistsException pokemonAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE,ExceptionResponse.POKEMON_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(TypeNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleTypeNotFoundException(
            TypeNotFoundException typeNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.TYPE_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }
}