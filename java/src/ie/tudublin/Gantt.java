package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;

public class Gantt extends PApplet
{	
	ArrayList<Task> tasks = new ArrayList<Task>();

	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");

		//for loop inserts data from csv into the array list through Task.java
		for(TableRow row : table.rows())
		{
			Task t = new Task(row);
			tasks.add(t);
		}	
	}

	public void printTasks()
	{
		//prints all data that was inserted into the array list
		for (Task t : tasks) 
		{
			System.out.println(t);
		}
	}

	public void displayTasks()
	{
		for(int i = 0; i < tasks.size(); i++)
		{
			Task t = tasks.get(i);
		}
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	public void setup() 
	{
		loadTasks();
		printTasks();
		colorMode(HSB);
	}
	
	public void draw()
	{			
		background(0);
	}
}
