package ar.com.kfgodel.rea;

import java.util.function.Supplier;

/**
 * This type represents the functional extended boolean values (true and false with functional vitamins)
 *
 * Created by kfgodel on 31/12/14.
 */
public enum Foolean implements Supplier<Boolean> {
    TRUE{
        @Override
        public Boolean get() {
            return Boolean.TRUE;
        }
    },
    FALSE{
        @Override
        public Boolean get() {
            return Boolean.FALSE;
        }
    };
}
