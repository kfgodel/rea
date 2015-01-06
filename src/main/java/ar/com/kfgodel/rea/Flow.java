package ar.com.kfgodel.rea;

import java.util.function.Supplier;

/**
 * This type represents the
 * Created by kfgodel on 06/01/15.
 */
public enum Flow implements Supplier<Flow> {
    /**
     * Continues the normal flow of the loop
     */
    CONTINUE,
    /**
     * Stops the looping flow
     */
    BREAK;

    @Override
    public Flow get() {
        return this;
    }
}
