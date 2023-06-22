package com.java.fundamentals.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified,
 * its dependent objects are to be notified automatically. Observer pattern falls under behavioral pattern category.
 */
public class Observer {
    public static void main(String[] args) {

        // First Example
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexObserver(subject);

        System.out.println("First state: 15");
        subject.setState(15);

        System.out.println("Second state: 10");
        subject.setState(10);

        System.out.println("###");

        // Second Example

        Agency agency = new Agency();
        agency.addChannel(new FoxNewChannel());
        agency.addChannel(new NSBCNews());

        agency.setNews("New n.1");
        agency.setNews("New n.2");

    }
}

class Agency {

    private List<IChannel> channels = new ArrayList<>();
    private String news;

    public void setNews(String news) {
        this.news = news;
        notifyChannels();
    }

    void addChannel(IChannel channel) {
        channels.add(channel);
    }

    void notifyChannels() {
        channels.forEach(c -> c.update(this.news));
    }
}

interface IChannel {
    void update(String news);
}

class FoxNewChannel implements IChannel {

    @Override
    public void update(String news) {
        System.out.println("News updated on Fox News Channel: " + news);
    }
}

class NSBCNews implements IChannel {
    @Override
    public void update(String news) {
        System.out.println("News updated on NSBC Channel: " + news);
    }
}

class Subject {
    private List<IObserver> observers = new ArrayList<>();
    private int state;

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public int getState() {
        return state;
    }

    public void attach(IObserver observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        observers.forEach(o -> o.update());
    }
}

abstract class IObserver {
    protected Subject subject;
    abstract void update();
}

class BinaryObserver extends IObserver {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary Observer updated: " + Integer.toBinaryString(this.subject.getState()));
    }
}

class OctalObserver extends IObserver {
    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal Observer updated: " + Integer.toOctalString(this.subject.getState()));
    }
}

class HexObserver extends IObserver {
    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex Observer update: " + Integer.toHexString(this.subject.getState()));
    }
}
