package ar.com.kfgodel.rea.impl.variables;

import ar.com.kfgodel.rea.api.statements.StatementContext;
import ar.com.kfgodel.rea.api.variables.LocalVariableDeclarationStatement;
import ar.com.kfgodel.rea.impl.VariableImpl;

import java.util.function.Supplier;

/**
 * Default implementation
 * Created by kfgodel on 08/07/17.
 */
public class LocalVariableDeclarationImpl implements LocalVariableDeclarationStatement {
  private String variableName;
  private Supplier expression;

  @Override
  public void executeOn(StatementContext context) {
    Object variableValue = expression.get();
    VariableImpl variable = VariableImpl.create(variableValue);
    context.binding().bindTo(variableName, variable);
  }

  public static LocalVariableDeclarationImpl create(String variableName, Supplier expression) {
    LocalVariableDeclarationImpl localVariableDeclaration = new LocalVariableDeclarationImpl();
    localVariableDeclaration.variableName = variableName;
    localVariableDeclaration.expression = expression;
    return localVariableDeclaration;
  }

}
