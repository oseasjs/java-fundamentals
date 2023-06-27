package com.java.fundamentals.designpatterns.behavioral.interpreter;

/**
 * Interpreter pattern provides a way to evaluate language grammar or expression.
 * This type of pattern comes under behavioral pattern.
 * This pattern involves implementing an expression interface which tells to interpret a particular context.
 * This pattern is used in SQL parsing, symbol processing engine etc.
 */
public class Interpreter {
    public static void main(String[] args) {
        Expression maleNameExpression = new OrExpression(
                new TerminalExpression("John"),
                new TerminalExpression("Peter")
        );
        Expression maryMarriedExpression = new AndExpression(
                new TerminalExpression("Mary"),
                new TerminalExpression("married")
        );

        String text1 = "John is male?";
        String text2 = "Paul is married with Mary!";

        System.out.println("Text 1: " + text1);
        System.out.println("Text 2: " + text2);

        System.out.println("Text 1 has maleName? " + maleNameExpression.interpret(text1));
        System.out.println("Text 2 has maleName? " + maleNameExpression.interpret(text2));

        System.out.println("Text 1 has reference to Mary married ? " + maryMarriedExpression.interpret(text1));
        System.out.println("Text 2 has reference to Mary married? " + maryMarriedExpression.interpret(text2));

    }
}

interface Expression {
    boolean interpret(String context);
}

class TerminalExpression implements Expression {
    private String data;
    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.toLowerCase().contains(data.toLowerCase());
    }
}

class OrExpression implements Expression {
    private Expression expression1;
    private Expression expression2;
    public OrExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) || expression2.interpret(context);
    }
}

class AndExpression implements Expression {
    private Expression expression1;
    private Expression expression2;

    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) && expression2.interpret(context);
    }
}