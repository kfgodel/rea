package ar.com.kfgodel.rea.impl;

import ar.com.kfgodel.rea.api.Variable;

/**
 * Created by tenpines on 06/10/15.
 */
public class VariableImpl<T> implements Variable<T> {

  private T value;


  @Override
  public void set(T newValue) {
    this.value = newValue;
  }

  @Override
  public T get() {
    return value;
  }

  public static VariableImpl create(){
      VariableImpl variable = new VariableImpl();
      return variable;
  }

}
