package ar.com.kfgodel.rea;

import java.util.function.Supplier;

/**
 * This type represents a loop entity that has a dynamic loop body
 *
 * Created by kfgodel on 06/01/15.
 */
public interface DynamicLoop {

    Supplier<Flow> getBody();

    void setBody(Supplier<Flow> body);

    default void setAsBody(Runnable runnable){
        this.setBody(As.loopBody(runnable));
    };

}
