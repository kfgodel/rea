package ar.com.kfgodel.rea.impl.variables;

import ar.com.kfgodel.rea.api.statements.StatementContext;
import ar.com.kfgodel.rea.api.variables.ReturnStatement;

import java.util.function.Supplier;

/**
 * Default implementation
 * Created by kfgodel on 08/07/17.
 */
public class ReturnStatementImpl implements ReturnStatement {
  public static final String RETURN_PSEUDO_VARIABLE = "return";

  private Supplier expression;

  @Override
  public void executeOn(StatementContext context) {
    Object returnedValue = expression.get();
    context.binding().bindTo(RETURN_PSEUDO_VARIABLE, returnedValue);
  }

  public static ReturnStatementImpl create(Supplier expression) {
    ReturnStatementImpl returnStatement = new ReturnStatementImpl();
    returnStatement.expression = expression;
    return returnStatement;
  }

}
