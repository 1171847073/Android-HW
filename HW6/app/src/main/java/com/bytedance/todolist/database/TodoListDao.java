package com.bytedance.todolist.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * @author wangrui.sh
 * @since Jul 11, 2020
 */
@Dao
public interface TodoListDao {
    @Query("SELECT * FROM todo1")
    List<TodoListEntity> loadAll();

    @Insert
    long addTodo(TodoListEntity entity);

    @Query("DELETE FROM todo1")
    void deleteAll();

    @Delete
    void deleteTodo(TodoListEntity entity);
}
