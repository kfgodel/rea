package ar.com.kfgodel.rea.api;

/**
 * This type represents the execution context for a statement where name bindings are resolved
 *
 * Created by tenpines on 06/10/15.
 */
public interface StatementScope {

  /**
   * Creates a new variable in this scope with the given name.<br>
   *   An error is generated if the variable already exists with that name
   * @param variableName The name to identify the variable
   * @param <T> The type of the expected variable
   * @return The created variable
   */
  <T> Variable<T> newVar(String variableName);

  /**
   * Gets the variable identified by name from this scope.<br>
   *   An error is generated if the variable doesn't exist
   * @param variableName The name that identifies the variable
   * @param <T> The type of the expected variable
   * @return The referenced variable
   */
  <T> Variable<T> getVar(String variableName);
}
