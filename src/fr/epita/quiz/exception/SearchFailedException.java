package fr.epita.quiz.exception;

/**
 * 
 * @author Swati Khandare
 * SearchFailedException
 */
public class SearchFailedException extends DataAccessException {

	private static final long serialVersionUID = -3941189717606529626L;

	public SearchFailedException(Object badInput) {
		super(badInput);
	}

	public SearchFailedException(Object badInput, Exception initialCause) {
		super(badInput,initialCause);
	}

}
