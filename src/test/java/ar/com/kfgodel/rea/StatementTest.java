package ar.com.kfgodel.rea;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.dgarcia.javaspec.api.contexts.TestContext;
import ar.com.dgarcia.javaspec.api.variable.Variable;
import ar.com.kfgodel.rea.api.Statement;
import ar.com.kfgodel.rea.impl.ScopeImpl;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This type verifies the behavior of a single statement
 * Created by kfgodel on 31/12/14.
 */
@RunWith(JavaSpecRunner.class)
public class StatementTest extends JavaSpec<TestContext> {
  @Override
  public void define() {

    describe("a statement", () -> {

      it("is an executable behavior", () -> {
        Variable<Boolean> executed = Variable.of(false);

        Statement statement = (a) -> executed.set(true);
        statement.executeOn(null);

        assertThat(executed.get()).isTrue();
      });

      it("access entities by name through the given scope", () -> {
        ScopeImpl givenScope = ScopeImpl.create();

        Statement statement = (scope) -> scope.newVar("aVariable").set(2);
        statement.executeOn(givenScope);

        assertThat(givenScope.getVar("aVariable").get()).isEqualTo(2);
      });

      it("can be composed of several statements to form a block statement", () -> {

      });
    });

  }
}