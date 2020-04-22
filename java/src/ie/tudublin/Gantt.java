package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;

public class Gantt extends PApplet
{	
	ArrayList<Task> tasks = new ArrayList<Task>();

	float taskDesc;
	float chartBorder;

	float w;
	float h;

	public void settings()
	{
		size(800, 600);

		taskDesc = width * 0.02f;
		chartBorder = width * 0.5f;
	}//end settings

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");

		//for loop inserts data from csv into the array list through Task.java
		for(TableRow row : table.rows())
		{
			Task t = new Task(row);
			tasks.add(t);
		}	
	}//end loadTasks

	public void printTasks()
	{
		//prints all data that was inserted into the array list
		for (Task t : tasks) 
		{
			System.out.println(t);
		}
	}//end printTasks

	public void displayTasks()
	{
		int vertGap = 30;
		//loops through array list to display each task
		for(Task t:tasks)
		{
			text(t.getTask(), taskDesc, vertGap);

			vertGap += 30;
		}
	}//end displayTasks
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}//end mousePressed

	public void mouseDragged()
	{
		println("Mouse dragged");
	}//end mouseDragged

	public void setup() 
	{
		loadTasks();
		printTasks();
		colorMode(HSB);
	}//end setup
	
	public void draw()
	{			
		background(0);
		displayTasks();
	}//end draw
}//end Gantt
