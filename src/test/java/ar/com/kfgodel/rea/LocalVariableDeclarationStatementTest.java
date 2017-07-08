package ar.com.kfgodel.rea;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.rea.api.Variable;
import ar.com.kfgodel.rea.impl.statements.StatementContextImpl;
import ar.com.kfgodel.rea.impl.variables.LocalVariableDeclarationImpl;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test verifies the behavior of a local varaible declaration
 * Created by kfgodel on 08/07/17.
 */
@RunWith(JavaSpecRunner.class)
public class LocalVariableDeclarationStatementTest extends JavaSpec<ReaTestContext> {
  @Override
  public void define() {
    describe("a local variable declaration", () -> {
      context().localDeclaration(()-> LocalVariableDeclarationImpl.create("name1", (stmContext)-> "value1"));

      it("binds the given name to a variable with the given initial value when executed",()->{
        StatementContextImpl context = StatementContextImpl.create();

        context().localDeclaration().executeOn(context);

        Variable<String> createdVariable = context.binding().getValueFor("name1");
        assertThat(createdVariable.get()).isEqualTo("value1");
      });
    });

  }
}