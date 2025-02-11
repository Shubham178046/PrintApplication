package com.example.printapplication.observers;

import java.util.ArrayList;
import java.util.List;

public class ObservableImpl implements Observable {
    private List<Observer> mObservers;

    public ObservableImpl() {
        mObservers = new ArrayList<Observer>();
    }

    @Override
    public void attach(Observer observer) {
        if (observer != null) {
            mObservers.add(observer);
        }
    }

    @Override
    public void notifyObserver(boolean bool) {
        if (bool) {
            for (int i = mObservers.size()-1; i >= 0; i--) {
                mObservers.get(i).update();
            }
        }
    }

    @Override
    public void updateProgress(int percentage) {
        for (int i = mObservers.size()-1; i >= 0; i--) {
            mObservers.get(i).updateObserverProgress(percentage);
        }
    }


    @Override
    public void notify(Object param) {
        try {
            for (int i = mObservers.size()-1; i >= 0; i--) {
                mObservers.get(i).update();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void detach(Observer observer) {
        try {
            mObservers.remove(observer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}