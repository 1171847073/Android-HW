package com.bytedance.todolist.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

/**
 * @author wangrui.sh
 * @since Jul 11, 2020
 */
@Entity(tableName = "todo1")
public class TodoListEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long mId;

    @ColumnInfo(name = "content")
    private String mContent;

    @ColumnInfo(name = "time")
    private Date mTime;

    @ColumnInfo(name = "status")
    private int mStatus;

    public TodoListEntity(String mContent, Date mTime) {
        this.mContent = mContent;
        this.mTime = mTime;
        this.mStatus = 0;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public Date getTime() {
        return mTime;
    }

    public void setTime(Date mTime) {
        this.mTime = mTime;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long mId) {
        this.mId = mId;
    }

    public int getStatus() {return mStatus; }

    public void setStatus(int mStatus) {this.mStatus = mStatus; }
}
