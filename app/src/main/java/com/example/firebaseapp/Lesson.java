package com.example.firebaseapp;

import java.util.Calendar;
import java.util.Date;

public class Lesson extends LessonID
{
    private String lesson_name;

    public Lesson()
    {
    }
     /* Verificare
    public Lesson(Date date)
    {
        lesson_name = date.toString();
    }  */

    public Lesson(String lesson_name)
    {
        this.lesson_name = lesson_name;
    }

    public String getLesson_name() {


        return lesson_name;
    }
}
