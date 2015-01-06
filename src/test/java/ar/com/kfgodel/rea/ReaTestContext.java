package ar.com.kfgodel.rea;

import ar.com.dgarcia.javaspec.api.TestContext;
import ar.com.dgarcia.javaspec.api.Variable;

import java.util.function.Supplier;

/**
 * Created by kfgodel on 06/01/15.
 */
public interface ReaTestContext extends TestContext {

    void aFor(Supplier<For> definition);
    For aFor();

    void aWhile(Supplier<While> definition);
    While aWhile();

    Variable<Integer> index();
    void index(Supplier<Variable<Integer>> definition);

    <T> Variable<T> variable();
    <T> void variable(Supplier<Variable<T>> definition);

}
