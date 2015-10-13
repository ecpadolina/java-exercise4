import java.util.Random;
import java.util.ArrayList;
import java.util.Comparator;

public class Horse implements Comparator<Horse>{

    private int horseID;
    private int distanceTraveled = 0;
    private boolean lastPlace = false;
    private int distanceToTravel;
    private String assignedWarcry;

    public Horse(int horseID, int distanceToTravel, String assignedWarcry) {
        this.horseID = horseID;
        this.distanceToTravel = distanceToTravel;
        this.assignedWarcry = assignedWarcry;
    }
    
    public Horse(){
    }
    
    public int getHorseID(){
        return this.horseID;
    }
    
    public int getDistanceToTravel(){
        return this.distanceToTravel;
    }
    
    public int getDistanceTraveled(){
        return distanceTraveled;
    }
    
    public void addToDistanceTraveled(int distance){
        distanceToTravel -= distance;
        distanceTraveled += distance;
    }
    
    public void setHorseLastPlace(boolean bool){
        lastPlace = bool;
    }
    
    public boolean isHorseLastPlace(){
        return lastPlace;
    }
    
    public String getWarCry(){
        String warCry = "Horse #" + getHorseID() + " says " + assignedWarcry;
        return warCry;
    }
       
    public int travelRandomDistance(){
        int random = this.isHorseLastPlace() ? 20 : 10;
        Random rand = new Random();
        int distance = 0;
        while(distance == 0){
            distance = rand.nextInt(random) + 1;
        }
        return distance;
    }
    
    public int compare(Horse h1, Horse h2){
        return h1.getDistanceTraveled() - h2.getDistanceTraveled();
    }   
}
