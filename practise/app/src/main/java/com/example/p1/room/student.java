package com.example.p1.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "students")
public class student {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String studentId;

    public student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }
}
