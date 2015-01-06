package ar.com.kfgodel.rea;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.dgarcia.javaspec.api.TestContext;
import ar.com.dgarcia.javaspec.api.Variable;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This type verifies the behavior of the looping constructs
 *
 * Created by kfgodel on 06/01/15.
 */
@RunWith(JavaSpecRunner.class)
public class LoopingTest extends JavaSpec<TestContext> {
    @Override
    public void define() {
        describe("for", () -> {
            describe("as a function", () -> {

                it("can be expressed with its minimal form",()->{
                    As.functionFor(As::noOp, As::functionFalse, As::noOp, As::noOp);
                });

                it("can have an initialization code",()->{
                    Variable<Integer> result = new Variable<>();

                    As.functionFor(() -> result.set(0), As::functionFalse, As::noOp, As::noOp);

                    assertThat(result.get()).isEqualTo(0);
                });

                it("can have a condition code",()->{
                    Variable<Integer> result = new Variable<>();
                    result.set(2);

                    As.functionFor(As::noOp, ()-> result.get() < 2, As::noOp, As::noOp);

                    assertThat(result.get()).isEqualTo(2);
                });

                it("can have a body code",()->{
                    Variable<Integer> result = new Variable<>();
                    result.set(0);

                    As.functionFor(As::noOp, () -> result.get() < 2, As::noOp, () -> result.storeSumWith(1));

                    assertThat(result.get()).isEqualTo(2);
                });


                it("can have an incrementer code",()->{
                    Variable<Integer> result = new Variable<>();
                    result.set(0);

                    As.functionFor(As::noOp, ()-> result.get() < 2, ()-> result.storeSumWith(1), As::noOp);

                    assertThat(result.get()).isEqualTo(2);
                });



            });

        });

    }
}