package ie.tudublin;

public class Main
{

    public void gant()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Gantt());
    }//end gant
    
    public static void main(String[] arg)
    {
        Main main = new Main();
		main.gant();        
    }//end main
}//end Main