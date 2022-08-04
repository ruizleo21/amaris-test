package co.com.amaris.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

import co.com.amaris.dto.GeneralResponseDTO;
import co.com.amaris.dto.PersonDTO;
import co.com.amaris.entities.DocumentPK;
import co.com.amaris.service.PersonService;

@RestController
@CrossOrigin("*")
public class PersonController {
	Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	ObjectWriter objectWriter;
	
	@ResponseBody
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GeneralResponseDTO> addPerson(@RequestBody  PersonDTO request ) throws JsonProcessingException{
		logger.info("[addPerson] Entry add person with request = " + objectWriter.writeValueAsString(request));
		personService.validateDocumentType(request.getDocumentType());
		ResponseEntity<GeneralResponseDTO> response = null;
		GeneralResponseDTO generalResponse = new GeneralResponseDTO(200, "The person has been added to the database");
		personService.savePerson(request);
		response = new ResponseEntity<GeneralResponseDTO>(generalResponse, HttpStatus.OK);
		logger.info("[addPerson] The person has been added to the database");
		return response;
		
	}
	
	@ResponseBody
	@GetMapping(value = "/{documentType}/{documentNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDTO> getPersonById(@PathVariable("documentType") String documentType, @PathVariable("documentNumber") String documentNumber) {
		logger.info("[getPersonById] Entry add person with documentType {}, and documentNumber{} ", documentType, documentNumber);
		personService.validateDocumentType(documentType);
		ResponseEntity<PersonDTO> response = null;
		DocumentPK pk = DocumentPK.builder().documentType(documentType).documentNumber(documentNumber).build();
		PersonDTO personDTO = personService.getPersonById(pk);
		response = new ResponseEntity<PersonDTO>(personDTO, HttpStatus.OK);
		logger.info("[getPersonById] The person has been returned");
		return response;
	}

}
