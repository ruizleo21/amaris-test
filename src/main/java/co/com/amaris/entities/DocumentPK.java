package co.com.amaris.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1551382194224101893L;

	private String documentType;

	private String documentNumber;

}
