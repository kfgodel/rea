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
    public static Flow noOp() {
        // We do nothing!
        return Flow.CONTINUE;
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

    /**
     * Functional version of FOR keyword that has all the parts as arguments
     * @param initialization The code to execute at the beginning
     * @param condition The condition to evaluate before each loop
     * @param incrementer The code to execute after each loop
     * @param body The code to execute in each loop (return BREAK to break the loop)
     */
    public static void functionFor(Runnable initialization, Supplier<Boolean> condition, Runnable incrementer, Supplier<Flow> body) {
        for(initialization.run();condition.get();incrementer.run()){
            Flow flow = body.get();
            if(Flow.BREAK.equals(flow)){
                break;
            }
        }
    }

    /**
     * Wraps a runnable code into a supplier so it usable as a loop body. A runnable code isn't able to break the loop
     * @param code The code to wrap
     * @return The supplier form of the runnable as always returning Flow.CONTINUE;
     */
    public static Supplier<Flow> loopBody(Runnable code) {
        return ()-> { code.run(); return Flow.CONTINUE;};
    }


    /**
     * Functional version of WHILE keyword that has all the parts as arguments
     * @param condition The condition to evaluate before the body execution
     * @param body The code to execute in the body of the loop
     */
    public static void functionWhile(Supplier<Boolean> condition, Supplier<Flow> body) {
        while(condition.get()){
            Flow flow = body.get();
            if(Flow.BREAK.equals(flow)){
                break;
            }
        }
    }
}
