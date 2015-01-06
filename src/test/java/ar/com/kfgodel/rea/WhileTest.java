package ar.com.kfgodel.rea;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.dgarcia.javaspec.api.Variable;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This type validates the behavior of while reification
 *
 * Created by kfgodel on 06/01/15.
 */
@RunWith(JavaSpecRunner.class)
public class WhileTest extends JavaSpec<ReaTestContext> {
    @Override
    public void define() {

        describe("while", () -> {

            describe("as a function", () -> {
                it("can be expressed with its minimal form",()->{
                    As.functionWhile(As::functionFalse,As::noOp);
                });

                it("can have a condition code",()->{
                    Variable<Integer> result = new Variable<>();
                    result.set(2);

                    As.functionWhile(() -> result.get() < 2, As::noOp);

                    assertThat(result.get()).isEqualTo(2);
                });

                it("can have a body code",()->{
                    Variable<Integer> result = new Variable<>();
                    result.set(0);

                    As.functionWhile(() -> result.get() < 2, As.loopBody(() -> result.storeSumWith(1)));

                    assertThat(result.get()).isEqualTo(2);
                });

                it("can be stopped with a break like exception",()->{
                    Variable<Integer> result = new Variable<>();
                    result.set(0);

                    As.functionWhile(() -> result.get() < 2,
                            () -> {
                                result.set(4);
                                return Flow.BREAK;
                            });

                    assertThat(result.get()).isEqualTo(4);

                });

            });

            describe("as an object", () -> {

                context().index(()-> Variable.of(0));

                it("can be executed as a runnable",()->{
                    While aWhile = While.create(
                            () -> context().index().get() < 10,
                            As.loopBody(() -> context().index().storeSumWith(1))
                    );

                    aWhile.run();

                    assertThat(context().index().get()).isEqualTo(10);
                });

                describe("with state", () -> {

                    context().aWhile(() -> While.create(
                                    () -> context().index().get() < 2,
                                    As.loopBody(() -> context().index().storeSumWith(1))
                            )
                    );

                    it("can change the condition",()->{
                        context().aWhile().setCondition(() -> context().index().get() < 8);

                        context().aWhile().run();

                        assertThat(context().index().get()).isEqualTo(8);
                    });

                    it("can change the body",()->{
                        context().aWhile().setBody(As.loopBody(()-> context().index().set(4)));

                        context().aWhile().run();

                        assertThat(context().index().get()).isEqualTo(4);
                    });
                });

            });


        });

    }
}