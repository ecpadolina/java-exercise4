import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

public class HorseRace extends Thread{
    private Horse horse = null;
    private HorseRanker ranker = null;
    private HorseRaceBarriers barriers = null;
    private CyclicBarrier cb = null;
    private int randomDistance = 0;
    private int horseID = 0;
    
    public HorseRace(Horse horse, HorseRaceBarriers barriers, HorseRanker ranker, CyclicBarrier cb){
        this.horse = horse;
        this.ranker = ranker;
        this.barriers = barriers;
        this.cb = cb;
    }

    public void run(){
        
        try{
        raceToGate();
        barriers.getGateBarrier().await();
        raceToFinishLine();
        barriers.getFinishLineBarrier().await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
    
    public void raceToGate() throws InterruptedException{
        randomDistance = horse.travelRandomDistance();
        horseID = horse.getHorseID();
        System.out.println(System.currentTimeMillis() +  " Horse #" + horseID + " takes " +
            randomDistance + " units to reach the gate from the barn.");
        //Thread.sleep(1000);
        for(int i = 0; i < randomDistance; i++){
            if(i < randomDistance){
                System.out.println(System.currentTimeMillis() + "Horse #" + horseID + " has travelled " + (i+1) + " unit(s)");
                        System.out.flush();
        //        Thread.sleep(1000);
            }
        }    
        System.out.println("Horse #" + horseID + " is now waiting at gate");
    }
    
    public void raceToFinishLine() throws InterruptedException{
        int distanceToTravel = 0;
        while(horse.getDistanceToTravel() > 0){
            randomDistance = horse.travelRandomDistance();    
            horse.addToDistanceTraveled(randomDistance);
            distanceToTravel = horse.getDistanceToTravel() < 0 ? 0 : horse.getDistanceToTravel();
            
            if(randomDistance > 10){
                System.out.println(System.currentTimeMillis() + " Horse #" + horseID + " jumps " + randomDistance + " units with boost! Units left: " + distanceToTravel);
                        System.out.flush();
                }
            
            else{
                System.out.println(System.currentTimeMillis() + " Horse #" + horseID + " jumps " + randomDistance + " units! Units left: " + distanceToTravel);
                        System.out.flush();
                }
            if(distanceToTravel <= 0) {
                System.out.println(System.currentTimeMillis() + horse.getWarCry());
                        System.out.flush();
                    }
            //Thread.sleep(1000);
            //ranker.setHorseAtLastPlace();
            
        }
    }
}
