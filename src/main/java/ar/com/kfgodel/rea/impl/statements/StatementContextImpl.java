package ar.com.kfgodel.rea.impl.statements;

import ar.com.kfgodel.rea.api.bindings.NameBinding;
import ar.com.kfgodel.rea.api.statements.StatementContext;
import ar.com.kfgodel.rea.impl.bindings.NameBindingsImpl;

/**
 * Context default implementation
 * Created by tenpines on 06/10/15.
 */
public class StatementContextImpl implements StatementContext {

  private NameBinding binding;

  public static StatementContextImpl create(){
    StatementContextImpl context = new StatementContextImpl();
    context.binding = NameBindingsImpl.create();
    return context;
  }

  @Override
  public NameBinding binding() {
    return binding;
  }
}
