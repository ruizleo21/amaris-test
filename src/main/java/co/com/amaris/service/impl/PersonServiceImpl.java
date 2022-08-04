package co.com.amaris.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.amaris.dto.PersonDTO;
import co.com.amaris.entities.DocumentPK;
import co.com.amaris.entities.Person;
import co.com.amaris.exceptions.PersonExistException;
import co.com.amaris.exceptions.PersonNotFoundException;
import co.com.amaris.repository.PersonRepository;
import co.com.amaris.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ModelMapper personMapper;

	@Override
	public void savePerson(PersonDTO personDTO) {
		DocumentPK pk = DocumentPK.builder().documentType(personDTO.getDocumentType()).documentNumber(personDTO.getDocumentNumber()).build();
		Optional<Person> personAux = personRepository.findById(pk);
		if (personAux.isPresent())
			throw new PersonExistException("The person already exist in database", 400);
		Person person = personMapper.map(personDTO, Person.class);
		personRepository.save(person);
	}

	@Override
	public PersonDTO getPersonById(DocumentPK pk) {
		// TODO Auto-generated method stub
		Optional<Person> person = personRepository.findById(pk);
			if (!person.isPresent())
				throw new PersonNotFoundException("Person doesn't exist", 404);
		return personMapper.map(person.get(), PersonDTO.class);
	}

}
