package com.newer.reflect.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by json on 2017/3/18.
 */
public class Other extends Observable {
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }
}
