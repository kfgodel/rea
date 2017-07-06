package ar.com.kfgodel.rea;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.dgarcia.javaspec.api.contexts.TestContext;
import ar.com.dgarcia.javaspec.api.variable.Variable;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This type verifies the implementation of conditional constructs
 * Created by kfgodel on 31/12/14.
 */
@RunWith(JavaSpecRunner.class)
public class IfTest extends JavaSpec<TestContext> {
    @Override
    public void define() {
        describe("if", () -> {

            describe("as a function", () -> {

                it("can be expressed with its minimal form", () -> {

                    As.functionIf(As::functionTrue, As::noOp, As::noOp);

                });

                it("can have one true consequent", () -> {
                    Variable<Boolean> result = new Variable<Boolean>();

                    As.functionIf(As::functionTrue, () -> result.set(true), As::noOp);

                    assertThat(result.get()).isTrue();
                });

                it("can have one false consequent", () -> {
                    Variable<Boolean> result = new Variable<Boolean>();

                    As.functionIf(As::functionFalse, As::noOp, () -> result.set(false));

                    assertThat(result.get()).isFalse();
                });

                it("can be used in other function to capture one of its possible forms as reusable code",()->{
                    Variable<Boolean> result = new Variable<Boolean>();

                    composed(result);

                    assertThat(result.get()).isTrue();
                });

            });

            describe("as an object", () -> {

                it("can express the basic form",()->{
                    If.create(As::functionTrue);
                });

                it("can have a true consequent",()->{

                    Variable<Boolean> result = new Variable<Boolean>();

                    If anIf = If.create(As::functionTrue, () -> result.set(true));
                    anIf.run();

                    assertThat(result.get()).isTrue();

                });

                it("can have a false consequent",()->{
                    Variable<Boolean> result = new Variable<Boolean>();

                    If anIf = If.createInverted(As::functionFalse, () -> result.set(false));
                    anIf.run();

                    assertThat(result.get()).isFalse();
                });
                
                it("can be executed as a runnable",()->{
                    Variable<Boolean> result = new Variable<Boolean>();

                    If anIf = If.create(As::functionTrue, () -> result.set(true),  () -> result.set(false));
                    anIf.run();

                    assertThat(result.get()).isTrue();

                });

                describe("with state", () -> {


                    it("can change the condition",()->{
                        Variable<Boolean> result = new Variable<Boolean>();
                        If anIf = If.create(As::functionTrue, () -> result.set(true),  () -> result.set(false));

                        anIf.setCondition(As::functionFalse);
                        anIf.run();

                        assertThat(result.get()).isFalse();
                    });

                    it("can change the true consequent",()->{
                        Variable<Boolean> result = new Variable<Boolean>();
                        If anIf = If.create(As::functionTrue, () -> result.set(true),  () -> result.set(false));

                        anIf.setTrueConsequent(() -> result.set(false));
                        anIf.run();

                        assertThat(result.get()).isFalse();
                    });
                    
                    it("can change the false consequent",()->{
                        Variable<Boolean> result = new Variable<Boolean>();
                        If anIf = If.create(As::functionFalse, () -> result.set(true),  () -> result.set(false));

                        anIf.setFalseConsequent(() -> result.set(true));
                        anIf.run();

                        assertThat(result.get()).isTrue();
                    });   
                    
                    it("can invert the consequents",()->{
                        Variable<Boolean> result = new Variable<Boolean>();
                        If anIf = If.create(As::functionTrue, () -> result.set(true),  () -> result.set(false));

                        anIf.invertConsequents();
                        anIf.run();

                        assertThat(result.get()).isFalse();
                    }); 
                    
                    it("can negate the condition",()->{
                        Variable<Boolean> result = new Variable<Boolean>();
                        If anIf = If.create(As::functionTrue, () -> result.set(true),  () -> result.set(false));

                        anIf.negateCondition();
                        anIf.run();

                        assertThat(result.get()).isFalse();
                    });   

                });


            });

        });

    }

    private void composed(Variable<Boolean> result) {
        As.functionIf(As::functionTrue, () -> result.set(true), As::noOp);
    }
}
