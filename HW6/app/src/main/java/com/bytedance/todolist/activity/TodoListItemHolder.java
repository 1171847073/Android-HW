package com.bytedance.todolist.activity;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.todolist.R;
import com.bytedance.todolist.database.TodoListEntity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangrui.sh
 * @since Jul 11, 2020
 */
public class TodoListItemHolder extends RecyclerView.ViewHolder {
    TextView mContent;
    TextView mTimestamp;
    TextView mX;
    CheckBox mDone;

    public TodoListItemHolder(@NonNull View itemView) {
        super(itemView);
        mContent = itemView.findViewById(R.id.tv_content);
        mTimestamp = itemView.findViewById(R.id.tv_timestamp);
        mX = itemView.findViewById(R.id.tv_X);
        mDone = itemView.findViewById(R.id.tv_checkbox);
    }

    public void bind(TodoListEntity entity) {
        mContent.setText(entity.getContent());
        mTimestamp.setText(formatDate(entity.getTime()));
        if(entity.getStatus() == 1){
            mContent.setPaintFlags(mContent.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            mContent.setTextColor(Color.parseColor("#FFCCCCCC"));
            mDone.setChecked(true);
        }
        else{
            mContent.setPaintFlags(mContent.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            mContent.setTextColor(Color.parseColor("#FF000000"));
            mDone.setChecked(false);
        }
    }

    private String formatDate(Date date) {
        DateFormat format = SimpleDateFormat.getDateInstance();
        return format.format(date);
    }
}
