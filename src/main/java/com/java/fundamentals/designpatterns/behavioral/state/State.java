package com.java.fundamentals.designpatterns.behavioral.state;

/**
 * In State pattern a class behavior changes based on its state. This type of design pattern comes under behavior pattern.
 * In State pattern, we create objects which represent various states and a context object whose behavior varies as its state object changes.
 */
public class State {

    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState());

    }

}

class Context {
    private IState state;

    public Context() {
        this.state = null;

    }

    public IState getState() {
        return state;
    }

    public void setState(IState state) {
        this.state = state;
    }
}
interface IState {
    void doAction(Context context);
}

class StartState implements IState {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Start State";
    }
}

class StopState implements IState {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Stop State";
    }
}
