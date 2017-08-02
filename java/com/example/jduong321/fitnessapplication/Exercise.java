package com.example.jduong321.fitnessapplication;

/**
 * Created by Jacky on 6/16/2017.
 */

public class Exercise {
    private int reps;
    private int sets;
    private String name;

    public Exercise()
    {

    }

    public Exercise(int _reps, int _sets, String _name)
    {
        reps = _reps;
        sets = _sets;
        name = _name;
    }

    public int getReps()
    {
        return reps;
    }

    public int getSets()
    {
        return sets;
    }

    public String getName()
    {
        return name;
    }

    public void setReps(int p)
    {
        reps = p;
    }

    public void setSets(int s)
    {
        sets = s;
    }

    public void setName(String s)
    {
        name = s;
    }



}
