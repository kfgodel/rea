package ar.com.kfgodel.rea.api.bindings;

/**
 * This type represents the set of values that a set of names are binded to in a given scope
 * Created by kfgodel on 05/07/17.
 */
public interface NameBinding {

  /**
   * Creates a new binding to the given name for the gven value.<br>
   *   If a previous binding exists for that name an exception is generated
   * @param givenName The name to use for accessin the value reference
   * @param value The value to assign to the binding
   * @return This instance for method chaining
   */
  NameBinding bindTo(String givenName, Object value);

  /**
   * Returns the value the given name is bound to or empty
   * @param name The name to which the value was previously bound
   * @return The value of the
   */
  Object getValueFor(String name);

  /**
   * Answers if this binding has a value bound to the given name
   * @param name The name to check
   * @return true if a value was previously bound to the name, false otherwise
   */
  boolean hasValueFor(String name);
}
