package ar.com.kfgodel.rea;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.rea.impl.statements.BlockImpl;
import ar.com.kfgodel.rea.impl.statements.StatementContextImpl;
import ar.com.kfgodel.rea.impl.variables.LocalVariableDeclarationImpl;
import ar.com.kfgodel.rea.impl.variables.ReturnStatementImpl;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This type verifies the behavior of a block
 * Created by kfgodel on 07/07/17.
 */
@RunWith(JavaSpecRunner.class)
public class BlockTest extends JavaSpec<ReaTestContext> {
  @Override
  public void define() {
    describe("a block statement", () -> {
      context().block(BlockImpl::create);

      it("starts with no statements", () -> {
        assertThat(context().block().statements().count()).isEqualTo(0);
      });

      describe("given a statement context", () -> {
        context().stmContext(StatementContextImpl::create);

        it("has no side effect when executed and empty", () -> {
          context().block().executeOn(context().stmContext());
          assertThat(context().stmContext().binding().hasValueFor("name1")).isFalse();
        });

        describe("when a statement is added", () -> {
          context().statement(() ->
            (stmContext) -> stmContext.binding().bindTo("name1", "value1")
          );
          beforeEach(() -> {
            context().block().add(context().statement());
          });

          it("executes the added statements when executed", () -> {
            context().block().executeOn(context().stmContext());
            assertThat(context().stmContext().binding().<String>getValueFor("name1")).isEqualTo("value1");
          });

          it("stops execution if a return statement is executed",()->{
            context().block()
              .add(ReturnStatementImpl.create((stmContext)-> 1))
              .add(LocalVariableDeclarationImpl.create("name2", (stmContext)-> "value2"));

            context().block().executeOn(context().stmContext());
            assertThat(context().stmContext().binding().hasValueFor("name2")).isFalse();
          });
        });

      });

    });
  }
}