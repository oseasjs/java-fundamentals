package com.java.fundamentals.designpatterns.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Memento pattern is used to restore state of an object to a previous state.
 * Memento pattern falls under behavioral pattern category.
 */
public class Memento {
    public static void main(String[] args) {

        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("State 1"); // State NOT stored
        originator.setState("State 2"); // State stored
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State 3"); // State stored
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State 4"); // State NOT stored
        originator.setState("State 5"); // State stored
        careTaker.add(originator.saveStateToMemento());

        System.out.println("State on index 0: " + careTaker.get(0).getState());
        System.out.println("State on index 1: " + careTaker.get(1).getState());
        System.out.println("State on index 2: " + careTaker.get(2).getState());

    }
}

class MementoState {
    private String state;
    public MementoState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public MementoState saveStateToMemento() {
        return new MementoState(state);
    }
    public void setStateFromMemento(MementoState mementoState) {
        state = mementoState.getState();
    }
}

class CareTaker {
    private List<MementoState> mementoList = new ArrayList<>();

    public void add(MementoState mementoState) {
        mementoList.add(mementoState);
    }
    public MementoState get(int index) {
        return mementoList.get(index);
    }
}