import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


public class HorseRaceMain{

    private static ArrayList<String> listOfWarcry = new ArrayList<String>(Arrays.asList("It's HAMMERTIME!","Selemene Commands","Fight for Honor!","Yippee Ki-Yay","FUSRODAH!","Warriors of the night, assemble!","Blood for blood!","In yo faceee!","You cant see me!","Hell Yeah!","Apperture Science is life.","The cake is a lie!","VICTORY","I win!","PWNED","GET REKT","MLG BOYS","Wait, what?","FTW!","WOOT!"));
    
    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Horses: ");
        int nHorses = sc.nextInt();
        System.out.print("Total Race Distance: ");
        int distance = sc.nextInt();

        Horse[] horses = new Horse[nHorses];
        HorseRanker ranker = new HorseRanker(horses);
        HorseRaceBarriers barriers = new HorseRaceBarriers(nHorses);
        ExecutorService executor = Executors.newFixedThreadPool(nHorses);
        CyclicBarrier cb = new CyclicBarrier(nHorses);
        
        for(int i = 0; i < nHorses; i++){
             Random rand = new Random();
             String warcry = "A";
             //String warcry = listOfWarcry.remove(rand.nextInt(listOfWarcry.size()));
             horses[i] = new Horse(i+1, distance, warcry);
             HorseRace hr = new HorseRace(horses[i], barriers, ranker, cb);
             hr.start();
             //executor.execute((new HorseRace(horses[i], barriers, ranker, cb)));
        }
        //executor.shutdown();
    }
}
