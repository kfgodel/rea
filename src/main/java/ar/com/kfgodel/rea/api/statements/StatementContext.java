package ar.com.kfgodel.rea.api.statements;

import ar.com.kfgodel.rea.api.bindings.NameBinding;

/**
 * This type represents the execution context for a statement where name bindings are available
 *
 * Created by tenpines on 06/10/15.
 */
public interface StatementContext {

  /**
   * @return The current name bindings available on the scope of the statement
   */
  NameBinding binding();

}
