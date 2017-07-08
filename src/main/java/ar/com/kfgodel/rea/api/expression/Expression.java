package ar.com.kfgodel.rea.api.expression;

import ar.com.kfgodel.rea.api.statements.Statement;
import ar.com.kfgodel.rea.api.statements.StatementContext;

/**
 * This type represents a value yielding  behavior that can also be used as statement
 * Created by kfgodel on 08/07/17.
 */
public interface Expression<R> extends Statement {

  @Override
  default void executeOn(StatementContext context){
    evaluateOn(context);
  }

  /**
   * Evaluates this expression on the given context and returns a value
   * @param context The context to evaluate
   * @return the generated value
   */
  R evaluateOn(StatementContext context);
}
