package ar.com.kfgodel.rea.api.exceptions;

/**
 * Created by tenpines on 06/10/15.
 */
public class ReaException extends RuntimeException {

  public ReaException(String message) {
    super(message);
  }

  public ReaException(String message, Throwable cause) {
    super(message, cause);
  }

  public ReaException(Throwable cause) {
    super(cause);
  }
}
