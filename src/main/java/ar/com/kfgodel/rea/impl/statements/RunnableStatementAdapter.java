package ar.com.kfgodel.rea.impl.statements;

import ar.com.kfgodel.rea.api.statements.Statement;
import ar.com.kfgodel.rea.api.statements.StatementContext;

/**
 * This type is an adapter from runnable to statement
 * Created by kfgodel on 07/07/17.
 */
public class RunnableStatementAdapter implements Statement {

  private Runnable codigo;

  @Override
  public void executeOn(StatementContext context) {
    codigo.run();
  }

  public static RunnableStatementAdapter create(Runnable codigo) {
    RunnableStatementAdapter adapter = new RunnableStatementAdapter();
    adapter.codigo = codigo;
    return adapter;
  }

}
