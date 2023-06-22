package com.java.fundamentals.designpatterns.behavioral.template;

/**
 * In Template pattern, an abstract class exposes defined way(s)/template(s) to execute its methods.
 * Its subclasses can override the method implementation as per need but the invocation is to be in the same way as defined by an abstract class.
 * This pattern comes under behavior pattern category.
 */
public class Template {

    public static void main(String[] args) {
        Game cricket = new Cricket();
        cricket.play();

        Game football = new Football();
        football.play();
    }

}

abstract class Game {
    abstract void initiate();
    abstract void startPlay();
    abstract void endPlay();

    public void play() {
        initiate();
        startPlay();
        endPlay();
    }
}

class Cricket extends Game {
    @Override
    public void initiate() {
        System.out.println("Cricket Game initiated");
    }

    @Override
    public void startPlay() {
        System.out.println("Cricket Game started");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game ended");
    }
}

class Football extends Game {

    @Override
    public void initiate() {
        System.out.println("Football Game initiated");
    }

    @Override
    public void startPlay() {
        System.out.println("Football Game started");
    }

    @Override
    public void endPlay() {
        System.out.println("Football Game ended");
    }
}
