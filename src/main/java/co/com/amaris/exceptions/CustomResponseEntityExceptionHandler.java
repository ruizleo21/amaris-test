package co.com.amaris.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.amaris.dto.GeneralResponseDTO;


@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	Logger logger = LoggerFactory.getLogger(CustomResponseEntityExceptionHandler.class);
	
	@ExceptionHandler(BadRequestDocumentTypeException.class)
	public ResponseEntity<GeneralResponseDTO> handleBadRequestDocumentTypeException(BadRequestDocumentTypeException ex){
		GeneralResponseDTO response = new GeneralResponseDTO(ex.getCode(), ex.getMessage());
		HttpStatus status = HttpStatus.valueOf(ex.getCode());
		return new ResponseEntity<GeneralResponseDTO>(response, status);
	}
	
	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<GeneralResponseDTO> handlePersonNotFoundException(PersonNotFoundException ex){
		GeneralResponseDTO response = new GeneralResponseDTO(ex.getCode(), ex.getMessage());
		HttpStatus status = HttpStatus.valueOf(ex.getCode());
		return new ResponseEntity<GeneralResponseDTO>(response, status);
	}
	
	@ExceptionHandler(PersonExistException.class)
	public ResponseEntity<GeneralResponseDTO> handlePersonExistException(PersonExistException ex){
		GeneralResponseDTO response = new GeneralResponseDTO(ex.getCode(), ex.getMessage());
		HttpStatus status = HttpStatus.valueOf(ex.getCode());
		return new ResponseEntity<GeneralResponseDTO>(response, status);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<GeneralResponseDTO> handleGeneralException(Exception ex){
		GeneralResponseDTO response = new GeneralResponseDTO(500, ex.getMessage());
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		return new ResponseEntity<GeneralResponseDTO>(response, status);
	}

}
