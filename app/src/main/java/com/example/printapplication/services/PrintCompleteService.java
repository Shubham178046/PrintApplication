package com.example.printapplication.services;

public interface PrintCompleteService {
    public void onMessage(int status);
    public void respondAfterWifiSwitch();
}
