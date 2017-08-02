package com.example.jduong321.fitnessapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacky on 6/16/2017.
 */

public class Program {
    private String name;
    private List<Exercise> programExercises = new ArrayList<>();

    public Program(String _name)
    {
        name = _name;
    }

    public void addExercise(int _reps, int _sets, String _name)
    {
        Exercise e = new Exercise(_reps, _sets, _name);
        programExercises.add(e);
    }

    public void removeExercise(Exercise e)
    {
        if(e !=null)
            programExercises.remove(e);
    }
}
