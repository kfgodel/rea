package ar.com.kfgodel.rea;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.dgarcia.javaspec.api.TestContext;
import org.junit.runner.RunWith;

/**
 * Created by kfgodel on 31/12/14.
 */
@RunWith(JavaSpecRunner.class)
public class StatementTest extends JavaSpec<TestContext> {
    @Override
    public void define() {

        describe("a statement", () -> {
            it("is executable as a runnable",()->{

            });

            it("can be composed of several statements to form a block statement",()->{

            });
        });

    }
}