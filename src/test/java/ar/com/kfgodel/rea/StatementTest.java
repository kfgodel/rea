package ar.com.kfgodel.rea;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.dgarcia.javaspec.api.variable.Variable;
import ar.com.kfgodel.rea.api.statements.Statement;
import ar.com.kfgodel.rea.impl.statements.StatementContextImpl;
import org.assertj.core.util.Lists;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This type verifies the behavior of a single statement
 * Created by kfgodel on 31/12/14.
 */
@RunWith(JavaSpecRunner.class)
public class StatementTest extends JavaSpec<ReaTestContext> {
  @Override
  public void define() {
    describe("a statement", () -> {
      context().statement(()->
        (stmContext) -> stmContext.binding().bindTo("name1",1)
      );

      describe("given a statement context", () -> {
        context().stmContext(StatementContextImpl::create);

        it("can be executed",()->{
          context().statement().executeOn(context().stmContext());

          assertThat(context().stmContext().binding().getValueFor("name1")).isEqualTo(1);
        });

        it("shares state with other statements through the context",()->{
          List<Statement> statements = Lists.newArrayList(
            context().statement(),
            (stmContext) -> stmContext.binding().bindTo("name2", 2),
            (stmContext) -> stmContext.binding().bindTo("result", (Integer)stmContext.binding().getValueFor("name1") + (Integer)stmContext.binding().getValueFor("name2"))
          );

          statements.forEach(stm -> stm.executeOn(context().stmContext()));

          assertThat(context().stmContext().binding().getValueFor("result")).isEqualTo(3);
        });

        it("can ignore the context to generate side effect",()->{
          Variable<String> variable = Variable.create();

          Statement statement = Statement.fromRunnable(() -> variable.set("valor"));
          statement.executeOn(context().stmContext());

          assertThat(variable.get()).isEqualTo("valor");
        });


      });
    });
  }
}