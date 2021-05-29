import java.util.ArrayList;

public class Passenger {
    private String first;
    private String last;
    private boolean tof;
    private ArrayList<String> Alerts = new ArrayList<String> () ;
    private ArrayList<Flight> BookedFlights = new ArrayList<Flight>();
    private ArrayList<Flight> StandbyFlights = new ArrayList<Flight>() ;
    
public Passenger(String first, String last){
  this.first=first;
  this.last=last;
            }

//----------------------GETTERS---------------------------------
public String getFirstName(){
    return first;
}
public String getLastName(){
    return last;
}
public ArrayList<String> getAlerts(){
    return Alerts;
}
public ArrayList<Flight> getBookedFlights(){

	return BookedFlights; 
}
public ArrayList<Flight> getStandbyFlights(){
    return StandbyFlights;
}
//-------------------Other Methods------------------------------

void addAlert(String s){
	if (s == null){
		throw new RuntimeException("Null");
	}
	Alerts.add(s);
}

public void clearAlerts(){
    Alerts.clear();
}
public void cancelFlight(Flight f)
{
    if (f == null){
    	throw new RuntimeException("Null");
    }
    BookedFlights.remove(f);
    StandbyFlights.remove(f);
    f.removePassenger(this);
    f.removeStandbyPassenger(this);
}
public void cancelAll(){
   while (BookedFlights.size()>0){
	   BookedFlights.remove(0); 
   }
   while (StandbyFlights.size()>0)
    StandbyFlights.remove(0);

    
    
}
public boolean bookFlight(Flight f) {
	  if (f == null){
	    	throw new RuntimeException("Invalid");
	    }
	  else if (BookedFlights.size()<f.getCapacity())
	  {
		  BookedFlights.add(f);
		  f.addPassenger(this);
		  tof=true;
	  }
	  else {
		  tof = false;
	  }
 return tof;
}
public boolean addStandbyFlight(Flight f) {
	  if (f == null){
	    	throw new RuntimeException("Invalid");
	    }
	 StandbyFlights.add(f);
	 f.addStandbyPassenger(this);
	 tof = true;
			 return tof;
	 
}


}
    