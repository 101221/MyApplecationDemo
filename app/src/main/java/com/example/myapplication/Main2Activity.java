package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {

    private Send2Activity sendActivity;
    private IntentFilter intentFilter;
    private static final String TAG = "Send2Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intentFilter = new IntentFilter();
        sendActivity = new Send2Activity();

    }
    public static class Send2Activity extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: "+intent.getAction()+"222");
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(sendActivity);
    }
}
