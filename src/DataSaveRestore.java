import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.PriorityQueue;


public final class DataSaveRestore {

    static Order[] array = new Order[50];
    static int numOrder = 0;
    static Order[] newArray; 
    static Order minOrder;
    static String currentLine;
    static String time;
    static String order;

    public static void saveOrder(Order order){
	try{
	    FileWriter fileWriter= new FileWriter("SaveDataExample.txt",true);
	    BufferedWriter writer= new BufferedWriter(fileWriter);
	    writer.write(Integer.toString(order.getTime()));
	    writer.write(",");
	    writer.write(order.getText());
	    writer.write("\n");
	    writer.close();
	}
	catch(IOException e){
	    e.printStackTrace();
	}

    }


    public static void readFromFile1(String fileName){
	BufferedReader inputStream = null;
	String line;
	try {

	    inputStream = new BufferedReader(new FileReader(fileName));
	    while((line= inputStream.readLine())!=null){
		time = line.substring(0, line.indexOf(","));
		order= line.substring(line.indexOf("[")+1, line.indexOf("]"));
		Order studentOrder = new Order();
		studentOrder.setText(order);
		studentOrder.setTime(Integer.parseInt(time));
		array[numOrder] = studentOrder;
		numOrder++;
	    }
	    newArray = new Order[numOrder];
	    //copying the array from the array to newArray
	    System.arraycopy(array, 0, newArray, 0, numOrder);
	    PriorityQueueBH pbh = new PriorityQueueBH(newArray);
	    
	    String finalTimeOrder= "";
	    String finalOrder = "";
	    while(pbh.heap.heapSize!=0){
		minOrder = (Order) pbh.minimum();
		System.out.println(minOrder.time);
		finalTimeOrder = finalTimeOrder + "\n" +  convertString(Integer.toString(minOrder.time));
		finalOrder = finalOrder + "\n" + minOrder.getText();
		pbh.extractMinimum();
		
	    }
	    BlanchardGUI.setTimeText("PICK UP TIME \n " + finalTimeOrder);
	    BlanchardGUI.setOrderText("ORDER \n" + finalOrder);

	    if(inputStream !=null){
		inputStream.close();
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
    public static String convertString(String time){
	
	if(time.length()==3){
	    return time.substring(0, 1) + ":" + time.substring(1, 3);
	}
	
	else{
	    return time.substring(0, 2) + ":" + time.substring(2,4);
	}
    }


}
