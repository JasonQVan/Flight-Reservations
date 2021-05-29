
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;


public class DataManager {

	public static void exportData(String filename, ArrayList<Passenger>passengers, ArrayList<Flight>flights)
	{ 
	
		File files = new File("filename.txt");
			try {
			
				FileReader file = new FileReader("filename.txt");
				BufferedReader bufferreads = new BufferedReader(new FileReader(files));
				String nextline;
				ArrayList<Flight> fs = new ArrayList<Flight>();
				ArrayList<Passenger> ps = new ArrayList<Passenger>();
				
					nextline = bufferreads.readLine();
					nextline=nextline.replaceAll("[^0-9]","" );
					String[] line = nextline.split(",");
					String source=line[0];
					String dest = line[1];
					int toff=Integer.parseInt(line[2]);
					int lan=Integer.parseInt(line[3]);
					nextline = bufferreads.readLine();		
					nextline = nextline.replaceAll("[^0-9]","");
					int capac = Integer.parseInt(nextline);
					fs.add(new Flight(source,dest,toff,lan,capac));
					
					
					
					//--------------------------
					nextline = bufferreads.readLine();
					nextline=nextline.replaceAll("[^0-9]","");
					int digit=Integer.parseInt(nextline);
					for (int i =0; i < digit; i++){
						nextline=bufferreads.readLine();
						String [] pass = nextline.split(" , ");
						String first =pass[0];
						String last = pass[1];
						Passenger pas = new Passenger(first,last);
						ps.add(pas);
					//------------------
						
						nextline = bufferreads.readLine();
						nextline=nextline.replaceAll("[^0-9]","");
						int numA=Integer.parseInt(nextline);
						for (int j = 0; j< numA; j++){
							pas.addAlert(nextline = bufferreads.readLine());
						}
						nextline = bufferreads.readLine();
						nextline=nextline.replaceAll("[^0-9]","");
						int numbooked = Integer.parseInt(nextline);
						for (int l = 0; l<numbooked;l++){
							String [] passdigit=nextline.split(" , "); 
							String src = passdigit[0];
							String des = passdigit[1];
						int[] flighttimes ={0,0,0};
							for (int m = 2; m<=4; m++){
							flighttimes[m] = Integer.parseInt(passdigit[m]);
						}
							int takeoff = flighttimes[2];
							int land = flighttimes[3];
							int capc = flighttimes[4];
							Flight fli = new Flight(src,des,takeoff,land,capc);
							fs.add(fli);	
						}
						nextline = bufferreads.readLine();
						nextline=nextline.replaceAll("[^0-9]","");
						int numstandbyflight = Integer.parseInt(nextline);
						for (int q = 0; q < numstandbyflight;q++){
							nextline = bufferreads.readLine();
							String [] codesets = nextline.split(", ");
							String srcs = codesets[0];
							String destnation = codesets[1];
							for(Flight f:fs){
								if(f.getSourceAirport().equals(srcs)&& f.getDestinationAirport().equals(destnation)&& f.getTakeoffTime()==Integer.parseInt(codesets[2])&&f.getLandingTime()==Integer.parseInt(codesets[3])){
									pas.addStandbyFlight(f);
									break;}
						
						}
							
					bufferreads.close();
						
					
					}}} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
			}
				
	
			
	
	public static ImportData importData(String filename) throws IOException{

	
		File files = new File("filename.txt");
		FileReader filed = null;
			try {
			
				filed = new FileReader(files) ;
								
					
						
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
			
	BufferedReader bufferreads = new BufferedReader(filed);
	String nextline;
	ArrayList<Flight> fs = new ArrayList<Flight>();
	ArrayList<Passenger> ps = new ArrayList<Passenger>();
	
		nextline = bufferreads.readLine();
		nextline=nextline.replaceAll("[^0-9]","" );
		String[] line = nextline.split(",");
		String source=line[0];
		String dest = line[1];
		int toff=Integer.parseInt(line[2]);
		int lan=Integer.parseInt(line[3]);
		nextline = bufferreads.readLine();		
		nextline = nextline.replaceAll("[^0-9]","");
		int capac = Integer.parseInt(nextline);
		fs.add(new Flight(source,dest,toff,lan,capac));
		
		
		
		//--------------------------
		nextline = bufferreads.readLine();
		nextline=nextline.replaceAll("[^0-9]","");
		int digit=Integer.parseInt(nextline);
		for (int i =0; i < digit; i++){
			nextline=bufferreads.readLine();
			String [] pass = nextline.split(" , ");
			String first =pass[0];
			String last = pass[1];
			Passenger pas = new Passenger(first,last);
			ps.add(pas);
		//------------------
			
			nextline = bufferreads.readLine();
			nextline=nextline.replaceAll("[^0-9]","");
			int numA=Integer.parseInt(nextline);
			for (int j = 0; j< numA; j++){
				pas.addAlert(nextline = bufferreads.readLine());
			}
			nextline = bufferreads.readLine();
			nextline=nextline.replaceAll("[^0-9]","");
			int numbooked = Integer.parseInt(nextline);
			for (int l = 0; l<numbooked;l++){
				String [] passdigit=nextline.split(" , "); 
				String src = passdigit[0];
				String des = passdigit[1];
			int[] flighttimes ={0,0,0};
				for (int m = 2; m<=4; m++){
				flighttimes[m] = Integer.parseInt(passdigit[m]);
			}
				int takeoff = flighttimes[2];
				int land = flighttimes[3];
				int capc = flighttimes[4];
				Flight fli = new Flight(src,des,takeoff,land,capc);
				fs.add(fli);	
			}
			nextline = bufferreads.readLine();
			nextline=nextline.replaceAll("[^0-9]","");
			int numstandbyflight = Integer.parseInt(nextline);
			for (int q = 0; q < numstandbyflight;q++){
				nextline = bufferreads.readLine();
				String [] codesets = nextline.split(", ");
				String srcs = codesets[0];
				String destnation = codesets[1];
				for(Flight f:fs){
					if(f.getSourceAirport().equals(srcs)&& f.getDestinationAirport().equals(destnation)&& f.getTakeoffTime()==Integer.parseInt(codesets[2])&&f.getLandingTime()==Integer.parseInt(codesets[3])){
						pas.addStandbyFlight(f);
						break;}
				}
			}
		}
	bufferreads.close();
	return new ImportData(ps,fs);
	}}