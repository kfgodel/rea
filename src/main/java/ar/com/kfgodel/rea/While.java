package ar.com.kfgodel.rea;

import java.util.function.Supplier;

/**
 * This type represents a dynamic WHILE construct
 * Created by kfgodel on 06/01/15.
 */
public class While implements Runnable, DynamicLoop {

    private Supplier<Boolean> condition;
    private Supplier<Flow> body;

    @Override
    public void run() {
        As.functionWhile(this.condition,this.body);
    }

    public static While create(Supplier<Boolean> condition, Supplier<Flow>body) {
        While aWhile = new While();
        aWhile.body = body;
        aWhile.condition = condition;
        return aWhile;
    }

    public Supplier<Boolean> getCondition() {
        return condition;
    }

    public void setCondition(Supplier<Boolean> condition) {
        this.condition = condition;
    }

    public Supplier<Flow> getBody() {
        return body;
    }

    public void setBody(Supplier<Flow> body) {
        this.body = body;
    }
}
