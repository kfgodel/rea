package ar.com.kfgodel.rea;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.dgarcia.javaspec.api.variable.Variable;
import org.junit.runner.RunWith;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * This type verifies the behavior of the looping constructs
 *
 * Created by kfgodel on 06/01/15.
 */
@RunWith(JavaSpecRunner.class)
public class ForTest extends JavaSpec<ReaTestContext> {
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

                    As.functionFor(As::noOp, () -> result.get() < 2, As::noOp, As.loopBody(() -> result.storeSumWith(1)));

                    assertThat(result.get()).isEqualTo(2);
                });


                it("can have an incrementer code", () -> {
                    Variable<Integer> result = new Variable<>();
                    result.set(0);

                    As.functionFor(As::noOp, () -> result.get() < 2, () -> result.storeSumWith(1), As::noOp);

                    assertThat(result.get()).isEqualTo(2);
                });

                it("can be stopped with a break like exception",()->{
                    Variable<Integer> result = new Variable<>();
                    result.set(0);

                    As.functionFor(As::noOp, () -> result.get() < 2, As::noOp,
                            ()-> {
                                result.set(4);
                                return Flow.BREAK;
                            });

                    assertThat(result.get()).isEqualTo(4);

                });


            });

            describe("as an object", () -> {

                context().index(Variable::create);

                it("can be executed as a runnable",()->{
                    For aFor = For.create(
                            () -> context().index().set(0),
                            () -> context().index().get() < 10,
                            () -> context().index().storeSumWith(1),
                            As::noOp);

                    aFor.run();

                    assertThat(context().index().get()).isEqualTo(10);
                });

                describe("with state", () -> {

                    context().aFor(()-> For.create(
                                ()-> context().index().set(0),
                                ()->  context().index().get() < 1 ,
                                ()-> context().index().storeSumWith(1),
                                As::noOp)
                    );

                    it("can change the initialization code", () -> {
                        context().aFor().setInitialization(()-> context().index().set(2));

                        context().aFor().run();

                        assertThat(context().index().get()).isEqualTo(2);
                    });

                    it("can change the condition",()->{
                        context().aFor().setCondition(() -> context().index().get() < 8);

                        context().aFor().run();

                        assertThat(context().index().get()).isEqualTo(8);
                    });

                    it("can change the incrementer",()->{
                        context().aFor().setIncrementer(() -> context().index().storeSumWith(3));

                        context().aFor().run();

                        assertThat(context().index().get()).isEqualTo(3);
                    });

                    it("can change the body",()->{
                        Supplier<Flow> mockedBody = mock(Supplier.class);
                        context().aFor().setBody(mockedBody);

                        context().aFor().run();

                        verify(mockedBody,times(1)).get();
                    });
                });

            });


        });

    }
}