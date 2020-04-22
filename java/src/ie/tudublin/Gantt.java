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
		size(1200, 1200);

		taskDesc = width * 0.02f;
		chartBorder = width * 0.1f;

		w = width * 0.3f;
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
		h = 20;
		int taskNum = 0;

		//loops through array list to display each task
		for(Task t:tasks)
		{
			text(t.getTask(), taskDesc, vertGap);
			
			//rect(t.getStart() + chartBorder , vertGap, (t.getEnd() - t.getStart()) , h);
			float itemWidth = t.getEnd() - t.getStart();
			float itemX = map(t.getStart(), 1, 31, chartBorder, width - 15);
			float itemY = map(itemWidth, 1, 30, chartBorder, width - 15);
			
			fill(map(taskNum, 0, tasks.size(), 0, 255), 255, 255);

			rect(itemX, vertGap - 15, itemY, h, 4);
			
			vertGap += 30;
			taskNum++;
			/* System.out.println(itemWidth);
			System.out.println(itemX);
			System.out.println(itemY); */
		}

		//for loop to display the numbers above the Gantt chart
		for (int i = 1; i < 31; i++)
		{
			float ganttMap = map(i, 1, 30, chartBorder, width - 15);

			text(i, ganttMap, 10);
			//System.out.println(ganttMap);	
		}
	}//end displayTasks
	
	public void mousePressed()
	{
		println("Mouse pressed");	
		for(int i = 0; i < tasks.size(); i++)
		{
			float changeYVal = map(i, 0, tasks.size(), chartBorder, height - chartBorder);
			if(mouseX > chartBorder && mouseX < width && mouseY > changeYVal && mouseY < changeYVal)
			{
				
			}
		}
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
