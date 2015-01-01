package ar.com.kfgodel.rea;

import java.util.function.Supplier;

/**
 * This type represents the if statement as an entity that can change over time.<br>
 *     This type allows the composition and combination of dynamic behavior (or IF statements that change over time)
 *
 * Created by kfgodel on 01/01/15.
 */
public class If implements Runnable {


    private Supplier<Boolean> condition;
    private Runnable trueConsequent;
    private Runnable falseConsequent;


    /**
     * The basic form of an if statement that evaluates the given condition and has no consequent
     * @param condition The condition to evaluate
     * @return The created basic if
     */
    public static If create(Supplier<Boolean> condition) {
        return create(condition, As::noOp, As::noOp);
    }

    /**
     * Creates a basic if statement with a true consequent
     *
     * @param condition The condition to evaluate
     * @param trueConsequent The consequent to execute given a true value
     * @return The created if statement
     */
    public static If create(Supplier<Boolean> condition, Runnable trueConsequent) {
        return create(condition,trueConsequent, As::noOp);
    }

    /**
     * Creates a basic if statement with an false consequent
     * @param condition The condition to evaluate
     * @param falseConsequent The consequent to execute given a false value
     * @return The created if statement
     */
    public static If createInverted(Supplier<Boolean> condition, Runnable falseConsequent) {
        return create(condition,As::noOp, falseConsequent);
    }


    /**
     * Creates the complete form of the if statement with a true an a false consequent
     * @param condition The condition to evaluate
     * @param trueConsequent The consequent in case of a true value
     * @param falseConsequent The consequent in case of a false value
     * @return The created statement
     */
    public static If create(Supplier<Boolean> condition, Runnable trueConsequent, Runnable falseConsequent) {
        If anIf = new If();
        anIf.condition = condition;
        anIf.trueConsequent = trueConsequent;
        anIf.falseConsequent = falseConsequent;
        return anIf;
    }

    @Override
    public void run() {
        As.functionIf(this.condition, this.trueConsequent,this.falseConsequent);
    }

    public Supplier<Boolean> getCondition() {
        return condition;
    }

    public void setCondition(Supplier<Boolean> condition) {
        this.condition = condition;
    }

    public Runnable getTrueConsequent() {
        return trueConsequent;
    }

    public void setTrueConsequent(Runnable trueConsequent) {
        this.trueConsequent = trueConsequent;
    }

    public Runnable getFalseConsequent() {
        return falseConsequent;
    }

    public void setFalseConsequent(Runnable falseConsequent) {
        this.falseConsequent = falseConsequent;
    }

    /**
     * Inverts the consequents so the true consequent is executed on false conditions and the false consequent is executed with true conditions
     */
    public void invertConsequents() {
        Runnable tmp = this.trueConsequent;
        this.trueConsequent = this.falseConsequent;
        this.falseConsequent = tmp;
    }

    /**
     * Changes the condition so it's replaced by a negated form of the previous condition
     */
    public void negateCondition() {
        Supplier<Boolean> previousCondition = this.condition;
        this.condition = () ->  !previousCondition.get();
    }
}
