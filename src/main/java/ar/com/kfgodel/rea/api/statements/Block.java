package ar.com.kfgodel.rea.api.statements;

import ar.com.kfgodel.nary.api.Nary;

/**
 * This type represents a block of statements (a composite of behavior units)
 *
 * Created by kfgodel on 07/07/17.
 */
public interface Block extends Statement {

  /**
   * @return the statements this block is composed from
   */
  Nary<Statement> statements();

  /**
   * Adds the given statement to be executed as part of this block at the end of the previously added
   * @param nextStatement The next statement to execute
   * @return This instance for method chaining
   */
  Block add(Statement nextStatement);
}
