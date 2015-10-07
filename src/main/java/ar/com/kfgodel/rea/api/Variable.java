package ar.com.kfgodel.rea.api;

/**
 * This type represents a language variable that can hold and change references to entities
 *
 * Created by tenpines on 06/10/15.
 */
public interface Variable<T> {

  /**
   * Sets a new value to this variable
   * @param newValue The value to set
   */
  void set(T newValue);

  /**
   * @return The current value of this variable
   */
  T get();
}
