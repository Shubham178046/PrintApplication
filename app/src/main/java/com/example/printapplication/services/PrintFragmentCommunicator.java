package com.example.printapplication.services;

public interface PrintFragmentCommunicator {
    public void respondOnPrintComplete();
    public void respondOnPrinterSelect();
    public void respondOnPrinterSelectCancelled();
}
