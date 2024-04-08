package com.example.bootcamp.configuration.exeptiohandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.bootcamp.adapters.driven.jpa.mysql.exception.BootcampAlreadyExist;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.CapacityAlreadyExistException;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.CapacityIdNoExist;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.CapacityIsReapeated;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.FaildGet;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.FaildSave;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistException;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.TechnologyIdNoExist;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.TechnologyIsRepeated;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.VersionAlreadyExistException;
import com.example.bootcamp.configuration.Constants;

import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor  {

   private ResponseEntity<ExceptionResponse> handleException(String message) {
      return ResponseEntity.badRequest().body(new ExceptionResponse(message, HttpStatus.NOT_FOUND.toString(), LocalDateTime.now()));
  }

  @ExceptionHandler(TechnologyAlreadyExistException.class)
  public ResponseEntity<ExceptionResponse> handlerTechnologyAlreadyExistsException(){
      return handleException(Constants.TECHNOLOGY_ALREADY_EXISTS_EXCEPTION_MESSAGE);
  }

  @ExceptionHandler(NoDataFoundException.class)
  public ResponseEntity<ExceptionResponse> handlerNoDataFound(){
      return handleException(Constants.NO_DATA_FOUND_EXCEPTION_MESSAGE);
  }

  @ExceptionHandler(CapacityAlreadyExistException.class)
  public ResponseEntity<ExceptionResponse> CapacityAlredyExistException(){
      return handleException(Constants.CAPACTITY_ALREADY_EXISTS_EXCEPTION_MESSAGE);
  }
  @ExceptionHandler(TechnologyIdNoExist.class)
  public ResponseEntity<ExceptionResponse> TechnologyIdNoExist(){
      return handleException(Constants.TECHNOLOGY_ID_NO_EXISTS_EXCEPTION_MESSAGE);
  }

  @ExceptionHandler(TechnologyIsRepeated.class)
  public ResponseEntity<ExceptionResponse> TechnologyIsRepeated(){
      return handleException(Constants.TECHNOLOGY_IS_REPEATED);
  }


  @ExceptionHandler(BootcampAlreadyExist.class)
  public ResponseEntity<ExceptionResponse> BootcampAlreadyExist(){
      return handleException(Constants.BOOTCAMP_ALREADY_EXISTS_EXCEPTION_MESSAGE);
  }
  @ExceptionHandler(CapacityIdNoExist.class)
  public ResponseEntity<ExceptionResponse> CapacityIdNoExist(){
      return handleException(Constants.CAPACITY_ID_NO_EXISTS_EXCEPTION_MESSAGE);
  }

  @ExceptionHandler(CapacityIsReapeated.class)
  public ResponseEntity<ExceptionResponse> CapacityIsReapeated(){
      return handleException(Constants.CAPACITY_IS_REPEATED);
  }

  @ExceptionHandler(FaildSave.class)
  public ResponseEntity<ExceptionResponse> FaildSave(){
      return handleException(Constants.FAILD_SAVE);
  }
   
  @ExceptionHandler(FaildGet.class)
  public ResponseEntity<ExceptionResponse> FaildGet(){
      return handleException(Constants.FAILD_GET);
  }

  @ExceptionHandler(VersionAlreadyExistException.class)
  public ResponseEntity<ExceptionResponse> VersionAlreadyExistException(){
      return handleException(Constants.VERSION_ALREADY_EXISTS_EXCEPTION_MESSAGE);
  }

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<ExceptionResponse> handleValidationException(MethodArgumentNotValidException ex) {
       List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream()
               .map(error -> error.getField() + ": " + error.getDefaultMessage())
               .collect(Collectors.toList());

       ExceptionResponse response = new ExceptionResponse(
               "Validation Error",
               HttpStatus.BAD_REQUEST.toString(),
               LocalDateTime.now(),errorMessages
       );

       return ResponseEntity.badRequest().body(response);
   }
   

 
}
