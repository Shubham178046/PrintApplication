package com.example.printapplication;

import com.example.printapplication.observers.Observable;
import com.example.printapplication.observers.ObservableImpl;

public class ObservableSingleton {

    private static Observable mObservable;
    public static void initInstance() {
        if(mObservable==null){
            mObservable = new ObservableImpl();
        }
    }

    public static Observable getInstance(){
        return mObservable;
    }
}