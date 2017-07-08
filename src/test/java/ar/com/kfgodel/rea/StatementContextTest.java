package ar.com.kfgodel.rea;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.rea.impl.statements.StatementContextImpl;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This tests verifies the behavior of a statement context
 * Created by tenpines on 06/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class StatementContextTest extends JavaSpec<ReaTestContext> {
  @Override
  public void define() {

    describe("a statement context", ()->{
      context().stmContext(StatementContextImpl::create);

      it("offers access to the name bindings", ()->{
        assertThat(context().stmContext().binding()).isNotNull();
      });

    });

  }
}
