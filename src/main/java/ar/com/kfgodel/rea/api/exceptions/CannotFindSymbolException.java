package ar.com.kfgodel.rea.api.exceptions;

/**
 * This type represents the error of trying to access an undefined value through its name
 * Created by kfgodel on 05/07/17.
 */
public class CannotFindSymbolException extends ReaException {

  public CannotFindSymbolException(String message) {
    super(message);
  }

  public CannotFindSymbolException(String message, Throwable cause) {
    super(message, cause);
  }

  public CannotFindSymbolException(Throwable cause) {
    super(cause);
  }
}
