/**
 * 
 */
package co.com.amaris.exceptions;

/**
 * @author leonardoruiz
 *
 */
public class PersonExistException extends BusinessException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3953126865934091126L;

	public PersonExistException(String message, Integer code) {
		super(message, code);
	}

}
