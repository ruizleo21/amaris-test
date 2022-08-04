package co.com.amaris.service;

import co.com.amaris.dto.PersonDTO;
import co.com.amaris.entities.DocumentPK;
import co.com.amaris.exceptions.BadRequestDocumentTypeException;

public interface PersonService {
	
	void savePerson(PersonDTO person);
	
	PersonDTO getPersonById(DocumentPK pk);
	
	default void validateDocumentType(String documentType) {
		if (!documentType.equals("C") && !documentType.equals("P") ) {
			throw new BadRequestDocumentTypeException("Document type invalid", 400);
		}
	}
	

}
