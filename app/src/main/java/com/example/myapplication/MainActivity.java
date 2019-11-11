package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private IntentFilter intentFilter;
    private Main2Activity.Send2Activity sendActivity;
    private String sname="android.gongyuan.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter();
        intentFilter.addAction(sname);
        sendActivity = new Main2Activity.Send2Activity();
        registerReceiver(sendActivity,intentFilter);
        text = findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sname);
                sendBroadcast(intent);
            }
        });
        Toast.makeText(this,"dwa",Toast.LENGTH_LONG);
        Toast.makeText(this,"dwa",Toast.LENGTH_LONG);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(sendActivity);
    }
}
