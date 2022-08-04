package co.com.amaris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.amaris.entities.DocumentPK;
import co.com.amaris.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, DocumentPK> {

}
