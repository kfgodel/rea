package ar.com.kfgodel.rea;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.rea.api.exceptions.CannotFindSymbolException;
import ar.com.kfgodel.rea.impl.bindings.NameBindingsImpl;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This type verifies the behavior of a name binding
 * Created by kfgodel on 05/07/17.
 */
@RunWith(JavaSpecRunner.class)
public class NameBindingTest extends JavaSpec<ReaTestContext> {
  @Override
  public void define() {
    describe("a name binding", () -> {
      context().nameBinding(NameBindingsImpl::create);

      it("returns the value given for a bound name",()->{
        context().nameBinding().bindTo("aName", 2);
        assertThat(context().nameBinding().getValueFor("aName")).isEqualTo(2);
      });

      itThrows(CannotFindSymbolException.class, "if an unbound name is accessed", ()->{
        context().nameBinding().getValueFor("aName");
      }, e->{
        assertThat(e).hasMessage("The name[aName] is unbound");
      });

      it("allows binding null to a name",()->{
        context().nameBinding().bindTo("aName", null);
        assertThat(context().nameBinding().getValueFor("aName")).isNull();
      });

    });

  }
}