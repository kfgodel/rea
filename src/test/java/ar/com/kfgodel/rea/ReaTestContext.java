package ar.com.kfgodel.rea;

import ar.com.dgarcia.javaspec.api.contexts.TestContext;
import ar.com.dgarcia.javaspec.api.variable.Variable;
import ar.com.kfgodel.rea.api.bindings.NameBinding;
import ar.com.kfgodel.rea.api.statements.Statement;
import ar.com.kfgodel.rea.api.statements.StatementContext;

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

    NameBinding nameBinding();
    void nameBinding(Supplier<NameBinding> definition);

    StatementContext stmContext();
    void stmContext(Supplier<StatementContext> definition);

    Statement statement();
    void statement(Supplier<Statement> definition);


}
