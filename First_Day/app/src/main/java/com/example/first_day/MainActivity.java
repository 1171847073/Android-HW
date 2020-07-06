package com.example.first_day;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_01 = findViewById(R.id.btn_01);
        final TextView title = findViewById(R.id.title);

        btn_01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                title.setText("Welcome to my APP!");
                Log.i("MainActivity", "onClick: Welcome to my APP!");
            }
        });

        RadioGroup radgroup = (RadioGroup) findViewById(R.id.radioGroup);
        radgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                final RadioButton radbtn = (RadioButton) findViewById(checkedId);
                Toast.makeText(getApplicationContext(), "按钮组值发生改变,你选了" + radbtn.getText(), Toast.LENGTH_LONG).show();
                Button btn_gender = findViewById(R.id.btnpost);
                final TextView gender = findViewById(R.id.text_gender);
                btn_gender.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        gender.setText("你的性别是" + radbtn.getText());
                        Log.i("MainActivity", "onClick: commit the gender of the user");
                    }
                });
            }
        });

    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if(compoundButton.getId() == R.id.btn_open)
        {
            if(compoundButton.isChecked()) Toast.makeText(this,"打开声音",Toast.LENGTH_SHORT).show();
            else Toast.makeText(this,"打开声音",Toast.LENGTH_SHORT).show();
        }
    }
}
