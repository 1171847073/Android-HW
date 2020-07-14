package com.bytedance.todolist.activity;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.todolist.R;
import com.bytedance.todolist.database.TodoListDao;
import com.bytedance.todolist.database.TodoListDatabase;
import com.bytedance.todolist.database.TodoListEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author wangrui.sh
 * @since Jul 11, 2020
 */
public class TodoListAdapter extends RecyclerView.Adapter<TodoListItemHolder> {
    private List<TodoListEntity> mDatas;

    public TodoListAdapter() {
        mDatas = new ArrayList<>();
    }
    @NonNull
    @Override
    public TodoListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TodoListItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final TodoListItemHolder holder, final int position) {
        holder.bind(mDatas.get(position));
        holder.mDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.mDone.isChecked()) {
                    holder.mContent.setTextColor(Color.parseColor("#FFCCCCCC"));
                    holder.mContent.setPaintFlags(holder.mContent.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    mDatas.get(position).setStatus(1);
                }
                else {
                    holder.mContent.setTextColor(Color.parseColor("#FF000000"));
                    holder.mContent.setPaintFlags(holder.mContent.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    mDatas.get(position).setStatus(0);
                }
            }
        });
        holder.mX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatas.remove(position);
                notifyItemRemoved(position);
                setData(mDatas);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @MainThread
    public void setData(List<TodoListEntity> list) {
        mDatas = list;
        notifyDataSetChanged();
    }

    public List<TodoListEntity> getData(){ return mDatas; }
}
