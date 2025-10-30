package com.example.p1.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface studentDAO {
    @Insert
    void insertStudent(student student);

    @Query("SELECT * FROM students")
    List<student> getAllStudents();
}
