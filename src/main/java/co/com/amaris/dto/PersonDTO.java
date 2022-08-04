package co.com.amaris.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 271801162024029641L;
	
	
	private String documentType;
	
	private String documentNumber;
	
	private String firtsName;
	
	private String secondName;
	
	private String lastName;
	
	private String secondLastName;
	
	private String cellphone;
	
	private String address;

}
