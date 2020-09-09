package com.example.printapplication.ui.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.printapplication.Constants;
import com.example.printapplication.R;
import com.example.printapplication.services.PrintFragmentCommunicator;
import com.example.printapplication.ui.fragments.PrintFragment;

public class PrintFragmentActivity extends FragmentActivity {

    public PrintFragmentCommunicator mPrintFragmentCommunicator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_fragment);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, new PrintFragment())
                .commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constants.REQUEST_CODE_PRINTER && resultCode == Constants.RESULT_CODE_PRINTER) {
            if(mPrintFragmentCommunicator!=null){
                mPrintFragmentCommunicator.respondOnPrinterSelect();
            }
        } else if (requestCode == Constants.REQUEST_CODE_WIFI && resultCode == Constants.RESULT_CODE_PRINTER) {
            if(mPrintFragmentCommunicator!=null){
                mPrintFragmentCommunicator.respondOnPrintComplete();
            }
        } else if (requestCode == Constants.REQUEST_CODE_PRINTER && resultCode == Constants.RESULT_CODE_PRINTER_CONNECT_FAILED) {
            if(mPrintFragmentCommunicator!=null){
                mPrintFragmentCommunicator.respondOnPrinterSelectCancelled();
            }
        }
    }
}