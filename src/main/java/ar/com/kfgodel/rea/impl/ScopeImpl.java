package ar.com.kfgodel.rea.impl;

import ar.com.kfgodel.rea.api.exceptions.ReaException;
import ar.com.kfgodel.rea.api.StatementScope;
import ar.com.kfgodel.rea.api.Variable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tenpines on 06/10/15.
 */
public class ScopeImpl implements StatementScope {

  private Map<String, Variable> bindings;

  public static ScopeImpl create(){
    ScopeImpl scope = new ScopeImpl();
    scope.bindings = new HashMap<>();
    return scope;
  }

  @Override
  public <T> Variable<T> newVar(String variableName) {
    if(bindings.containsKey(variableName)){
      throw new ReaException("The variable '" + variableName + "' is already defined in the scope");
    }
    VariableImpl createdVariable = VariableImpl.create();
    bindings.put(variableName, createdVariable);
    return createdVariable;
  }

  @Override
  public <T> Variable<T> getVar(String variableName) {
    if(!bindings.containsKey(variableName)){
      throw new ReaException("There's no variable named '" + variableName + "' in the scope");
    }
    return bindings.get(variableName);
  }
}
