package ar.com.kfgodel.rea.api;

/**
 * This type represents the most basic concept in terms of executable behavior.<br>
 *   Programs are composed of statements, and different types of statements have different parameters and consecuences
 *   however all of them need a scope to be executed on
 *
 * Created by tenpines on 06/10/15.
 */
@FunctionalInterface
public interface Statement {

  /**
   * Executes this statement generating the consequences of this statement on the given scope
   * @param currentScope The scope to use on the execution
   */
  void executeOn(StatementScope currentScope);
}
