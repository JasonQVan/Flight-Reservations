import java.util.ArrayList;

//-------------------Fields-------------------------------------
public class Flight {
	private String src; 
	private String dest;
	private int takeoffTime;
	private int landingTime;
	private int capacity;
	private boolean tof;
	private boolean m=true;
	private ArrayList<Passenger> bookedPassengers = new ArrayList<Passenger>() ;
	private ArrayList<Passenger> standbyPassengers = new ArrayList<Passenger>() ;
	
//------------------Constructor----------------------------------
	
	public Flight(String src, String dest, int takeoffTime, int landingTime, int capacity) {
		this.src = src;
		this.dest=dest;
		this.takeoffTime =takeoffTime;
		this.landingTime =landingTime;
		this.capacity=capacity;
	
	}
//----------------------GETTERS---------------------------------	
	public String getSourceAirport() {
		return src;
	}
	public String getDestinationAirport() {
		return dest;
	}
	public int getLandingTime() {
		return landingTime;
	}
	public int getCapacity() {
		return capacity;
	}
	public int getTakeoffTime() {
	
		return takeoffTime;
	}
	public ArrayList<Passenger> getBookedPassengers() {
	return bookedPassengers;
	}
	public ArrayList<Passenger> getStandbyPassengers(){
		return standbyPassengers;
	}
//----------------------Other Methods---------------------------------
	public boolean addPassenger(Passenger p) {
		if (p == null)
		{
			throw new RuntimeException("Invalid");
		}
		if (bookedPassengers.size() < capacity){
			tof = true;
			bookedPassengers.add(p);	
		}
		else {
			tof = false;		
		}
		return tof;
	}
public boolean addStandbyPassenger(Passenger p){
	if (p == null){
		throw new RuntimeException("Invalid");			
		}
	standbyPassengers.add(p);
	tof = true;
	return tof;
	}
public void removePassenger(Passenger p){
 if (p == null) {
	 throw new RuntimeException("Invalid");
 }
 bookedPassengers.remove(p);
	
}
public void removeStandbyPassenger(Passenger p){
if (p==null){
	throw new RuntimeException("Invalid");
}
standbyPassengers.remove(p);	
}
public void cancel(){
	standbyPassengers.remove(this);
	bookedPassengers.remove(this);
	
}
public int promotePassengers(){
	int counter=0;
	if (bookedPassengers.size() >= capacity || standbyPassengers.size() != 0)
	{
		counter =0;
	}
	
	else if (bookedPassengers.size() == 0 && standbyPassengers.size()>0){
	counter = standbyPassengers.size() -bookedPassengers.size();
		
	}
	else if (bookedPassengers.size() < capacity  ){
			bookedPassengers.addAll(standbyPassengers);
		 counter = bookedPassengers.size() - standbyPassengers.size();
}
	else {
		counter =0;
	}
	return counter;
}
}

