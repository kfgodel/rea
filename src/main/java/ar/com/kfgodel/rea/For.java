package ar.com.kfgodel.rea;

import java.util.function.Supplier;

/**
 * This type represents a dynamic for construct
 * Created by kfgodel on 06/01/15.
 */
public class For implements Runnable {

    private Runnable initialization;
    private Supplier<Boolean> condition;
    private Runnable incrementer;
    private Supplier<Flow> body;

    @Override
    public void run() {
        As.functionFor(this.initialization, this.condition, this.incrementer, this.body);
    }

    /**
     * Creates a complete for construct with all its parts
     * @param initialization The initialization code
     * @param condition The condition code
     * @param incrementer The loop incrementer
     * @param body The for body code
     * @return The created For instance
     */
    public static For create(Runnable initialization, Supplier<Boolean> condition,  Runnable incrementer, Supplier<Flow> body) {
        For aFor = new For();
        aFor.body = body;
        aFor.condition = condition;
        aFor.incrementer = incrementer;
        aFor.initialization = initialization;
        return aFor;
    }

    public Runnable getInitialization() {
        return initialization;
    }

    public void setInitialization(Runnable initialization) {
        this.initialization = initialization;
    }

    public Supplier<Boolean> getCondition() {
        return condition;
    }

    public void setCondition(Supplier<Boolean> condition) {
        this.condition = condition;
    }

    public Runnable getIncrementer() {
        return incrementer;
    }

    public void setIncrementer(Runnable incrementer) {
        this.incrementer = incrementer;
    }

    public Supplier<Flow> getBody() {
        return body;
    }

    public void setBody(Supplier<Flow> body) {
        this.body = body;
    }
}
