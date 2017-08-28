/**
 * getter setter method
 * @author Moe
 *
 */
public class Order implements Comparable<Order> {
    String text; 
    int time; 
    String zero = "0";
    int intHour = 0;
    
    
    public int convertTime(String morning, String hour, String min){
	if(morning=="AM"){
	    if(min.length()==1){
		min = zero+min;
		return Integer.parseInt(hour+min);
	    }
	    else{
		return Integer.parseInt(hour+min);
	    }
	}
	else{
	    if(min.length()==1){
		min = zero+min;
		intHour = 12 + Integer.parseInt(hour);
		hour = Integer.toString(intHour);
		return Integer.parseInt(hour+min);
	    }
	    else{
		intHour = 12 + Integer.parseInt(hour);
		hour = Integer.toString(intHour);
		return Integer.parseInt(hour+min);
	    }
	}
	
    }

    public void setTime(int time){
	this.time = time;
    }
    public void setText(String text){
	this.text = text;
    }

    public int getTime(){
	return time;
    }

    public String getText(){
	return text;
    }

    /**
     * comparing the time of the two slides
     */
    public int compareTo(Order order){
	return time-order.getTime();
    }
    
}
