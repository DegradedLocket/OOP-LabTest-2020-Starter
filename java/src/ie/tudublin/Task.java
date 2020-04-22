package ie.tudublin;

import processing.data.TableRow;

public class Task
{
    
    private String task;
    private int start;
    private int end;

    public Task(String task, int start, int end)
    {
        this.task = task;
        this.start = start;
        this.end = end;
    }//end Task

    public Task(TableRow tr)
    {
        this(tr.getString("Task"), tr.getInt("Start"),tr.getInt("End"));
    }//end Task

    public String getTask()
    {
        return task;
    }//end getTask

    public void setTask(String task)
    {
        this.task = task;
    }//end setTask

    public int getStart()
    {
        return start;
    }//end getStart

    public void setStart(int start)
    {
        this.start = start;
    }//end setStart

    public int getEnd()
    {
        return end;
    }//end getEnd

    public void setEnd(int end)
    {
        this.end = end;
    }//end setEnd

    @Override
    public String toString()
    {
        return "Task [end=" + end + ", start=" + start + ", task=" + task + "]";
    }//end toString
}//end Task