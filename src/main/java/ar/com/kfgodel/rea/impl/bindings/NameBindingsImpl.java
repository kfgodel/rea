package ar.com.kfgodel.rea.impl.bindings;

import ar.com.kfgodel.rea.api.bindings.NameBinding;
import ar.com.kfgodel.rea.api.exceptions.CannotFindSymbolException;

import java.util.HashMap;
import java.util.Map;

/**
 * This type implements the bindings using an internal map
 * Created by kfgodel on 05/07/17.
 */
public class NameBindingsImpl implements NameBinding{

  private Map<String, Object> definitions;

  public static NameBindingsImpl create() {
    NameBindingsImpl bindings = new NameBindingsImpl();
    bindings.definitions = new HashMap<>();
    return bindings;
  }

  @Override
  public NameBinding bindTo(String givenName, Object value) {
    definitions.put(givenName, value);
    return this;
  }

  @Override
  public Object getValueFor(String name) {
    if(!definitions.containsKey(name)){
      throw new CannotFindSymbolException("The name["+name+"] is unbound");
    }
    Object value = definitions.get(name);
    return value;
  }
}
