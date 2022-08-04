package co.com.amaris.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "Person")
@IdClass(value = DocumentPK.class)
@Data
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5089068381389905908L;
	
	@Column
	@Id
	private String documentType;
	
	@Id
	@Column
	private String documentNumber;
	
	@Column
	private String firtsName;
	
	@Column
	private String secondName;
	
	@Column
	private String lastName;
	
	@Column
	private String secondLastName;
	
	@Column
	private String cellphone;
	
	@Column
	private String address;
	
}
