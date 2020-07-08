package com.example.hw2;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_show);
        Log.i(TAG, "ItemActivity onCreate");
        Bundle bundle = this.getIntent().getExtras();
        int position = bundle.getInt("number");
        initView(position);
    }
    private void initView(int n) {
        TextView mmessage = findViewById(R.id.message);
        mmessage.setText("你点击了第"+n+"个item");
    }

}
