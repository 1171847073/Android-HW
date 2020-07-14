package com.bytedance.todolist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bytedance.todolist.R;

public class TodoListConfirm extends AppCompatActivity {

    private EditText content;
    private Button btn;
    private String result = "请输入内容...";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_confirm_layout);

        content = (EditText)findViewById(R.id.Text);
        btn = (Button)findViewById(R.id.Confirm);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                result = content.getText().toString();
                data.putExtra("data",result);
                setResult(2,data);
                finish();
            }
        });
    }
}
