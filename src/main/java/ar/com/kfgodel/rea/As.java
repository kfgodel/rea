package ar.com.kfgodel.rea;

import java.util.function.Supplier;

/**
 * This type captures the basic keywords as functions
 * Created by kfgodel on 31/12/14.
 */
public class As {

    /**
     * Functional version of the IF keyword that takes two consequents
     * @param condition The condition to evaluate adn decide the executable consequent
     * @param trueConsequent The consequent of a true condition
     * @param falseConsequent The consequent of a false condition
     */
    public static void functionIf(Supplier<Boolean> condition, Runnable trueConsequent, Runnable falseConsequent) {
        if(condition.get()){
            trueConsequent.run();
        }else{
            falseConsequent.run();
        }
    }

    /**
     * This method represents the no operation reification. A method that has no effect but can be used
     * as argument in other constructs
     */
    public static void noOp() {
        // We do nothing!
    }

    /**
     * This method represent the functional version of the true keyword
     * @return The value true
     */
    public static boolean functionTrue() {
        return true;
    }


    /**
     * This method represent the functional version of the false keyword
     * @return The value false
     */
    public static boolean functionFalse(){
        return false;
    }
}
