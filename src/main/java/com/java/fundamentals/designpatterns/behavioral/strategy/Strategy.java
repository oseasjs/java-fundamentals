package com.java.fundamentals.designpatterns.behavioral.strategy;

/**
 * In Strategy pattern, a class behavior or its algorithm can be changed at run time. This type of design pattern comes under behavior pattern.
 * In Strategy pattern, we create objects which represent various strategies and a context object whose behavior varies as per its strategy object.
 * The strategy object changes the executing algorithm of the context object.
 */
public class Strategy {
    public static void main(String[] args) {

        Context context = new Context(new OperationAdd());
        int addResult = context.executeStrategy(12, 14);
        System.out.println("12 + 14 = " + addResult);

        context = new Context(new OperationSubtract());
        int subtractResult = context.executeStrategy(17, 11);
        System.out.println("17 - 11 = " + subtractResult);

        context = new Context(new OperationMultiply());
        int multipluResult = context.executeStrategy(12, 12);
        System.out.println("12 * 12 = " + multipluResult);

    }
}

interface IStrategy {
    int doOperation(int num1, int num2);
}

class OperationAdd implements IStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSubtract implements IStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationMultiply implements IStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

class Context {

    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }

}