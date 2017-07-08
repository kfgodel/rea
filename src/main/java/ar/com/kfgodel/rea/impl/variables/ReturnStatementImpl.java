package ar.com.kfgodel.rea.impl.variables;

import ar.com.kfgodel.rea.api.expression.Expression;
import ar.com.kfgodel.rea.api.statements.StatementContext;
import ar.com.kfgodel.rea.api.variables.ReturnStatement;

/**
 * Default implementation
 * Created by kfgodel on 08/07/17.
 */
public class ReturnStatementImpl implements ReturnStatement {
  public static final String RETURN_PSEUDO_VARIABLE = "return";

  private Expression expression;

  @Override
  public void executeOn(StatementContext context) {
    Object returnedValue = expression.evaluateOn(context);
    context.binding().bindTo(RETURN_PSEUDO_VARIABLE, returnedValue);
  }

  public static ReturnStatementImpl create(Expression expression) {
    ReturnStatementImpl returnStatement = new ReturnStatementImpl();
    returnStatement.expression = expression;
    return returnStatement;
  }

}
