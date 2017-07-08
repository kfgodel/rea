package ar.com.kfgodel.rea.api.statements;

import ar.com.kfgodel.rea.impl.statements.RunnableStatementAdapter;

/**
 * This type represents the most basic concept in terms of executable behavior.<br>
 *   Programs are composed of statements, and different types of statements have different parameters and consecuences
 *   however all of them need a context to be executed on
 *
 * Created by tenpines on 06/10/15.
 */
@FunctionalInterface
public interface Statement {

  /**
   * Executes this statement generating a side-effect on the given context (or somewhere else)
   * @param context The context where this statement can share state with others
   */
  void executeOn(StatementContext context);

  static Statement fromRunnable(Runnable codigo){
    return RunnableStatementAdapter.create(codigo);
  }
}
