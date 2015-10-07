package ar.com.kfgodel.rea;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.dgarcia.javaspec.api.TestContext;
import ar.com.kfgodel.rea.impl.VariableImpl;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test verifies the behavior for a variable
 * Created by tenpines on 06/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class VariableTest extends JavaSpec<TestContext> {
  @Override
  public void define() {
    describe("a variable", ()->{

      it("is created with a default value of null",()->{
        VariableImpl variable = VariableImpl.create();
        assertThat(variable.get()).isNull();
      });

      it("stores a value that can be accessed later", ()->{
        VariableImpl variable = VariableImpl.create();

        variable.set(6);

        assertThat(variable.get()).isEqualTo(6);
      });

    });
  }
}
