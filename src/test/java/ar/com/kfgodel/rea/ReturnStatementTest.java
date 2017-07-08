package ar.com.kfgodel.rea;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.rea.impl.statements.BlockImpl;
import ar.com.kfgodel.rea.impl.statements.StatementContextImpl;
import ar.com.kfgodel.rea.impl.variables.ReturnStatementImpl;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This type verifies the behavior of the return statement
 * Created by kfgodel on 08/07/17.
 */
@RunWith(JavaSpecRunner.class)
public class ReturnStatementTest extends JavaSpec<ReaTestContext> {
  @Override
  public void define() {
    describe("a return statement", () -> {
      context().returnStm(()-> ReturnStatementImpl.create(()-> 2));

      it("assigns a value to the special variable 'return'",()->{
        StatementContextImpl context = StatementContextImpl.create();

        context().returnStm().executeOn(context);

        assertThat(context.binding().<Integer>getValueFor("return")).isEqualTo(2);
      });
      
      it("can be used on a block to define the returned value",()->{
        StatementContextImpl context = StatementContextImpl.create();
        BlockImpl bloque = BlockImpl.create(context().returnStm());

        bloque.executeOn(context);

        assertThat(context.binding().<Integer>getValueFor("return")).isEqualTo(2);
      });   
    });


  }
}