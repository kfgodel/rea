package ar.com.kfgodel.rea;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.dgarcia.javaspec.api.TestContext;
import ar.com.kfgodel.rea.api.ReaException;
import ar.com.kfgodel.rea.impl.ScopeImpl;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

/**
 * This tests verifies the behavior of a statement scope
 * Created by tenpines on 06/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class ScopeTest extends JavaSpec<TestContext> {
  @Override
  public void define() {

    describe("a scope", ()->{

      it("has named references to entities in the form of variables", ()->{
        ScopeImpl scope = ScopeImpl.create();

        scope.newVar("aName").set(1);

        assertThat(scope.getVar("aName").get()).isEqualTo(1);
      });

      describe("#newVar", ()->{
        it("fails if the variable already exists", ()->{
          ScopeImpl scope = ScopeImpl.create();

          scope.newVar("duplicated");

          try{
            scope.newVar("duplicated");
            failBecauseExceptionWasNotThrown(ReaException.class);
          } catch (ReaException e){
            assertThat(e).hasMessage("The variable 'duplicated' is already defined in the scope");
          }
        });
      });

      describe("#getVar", ()->{
        it("fails if the variable doesn't exist", () -> {
          ScopeImpl scope = ScopeImpl.create();

          try{
            scope.getVar("undefined");
            failBecauseExceptionWasNotThrown(ReaException.class);
          } catch (ReaException e){
            assertThat(e).hasMessage("There's no variable named 'undefined' in the scope");
          }
        });
      });

    });

  }
}
