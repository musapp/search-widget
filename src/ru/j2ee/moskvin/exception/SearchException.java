/**
 * 
 */
package ru.j2ee.moskvin.exception;

/**
 * @author Nikolay Moskvin <moskvin@j2ee.ru>
 * @date 02.12.2010
 *
 */
public class SearchException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7097523330982033312L;

	/**
	 * 
	 */
	public SearchException() {
		super();
	}

	/**
	 * @param detailMessage
	 * @param throwable
	 */
	public SearchException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	/**
	 * @param detailMessage
	 */
	public SearchException(String detailMessage) {
		super(detailMessage);
	}

	/**
	 * @param throwable
	 */
	public SearchException(Throwable throwable) {
		super(throwable);
	}

}
