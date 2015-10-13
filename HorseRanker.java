import java.util.Comparator;
import java.util.Arrays;

public class HorseRanker{

    private Horse[] horses = null;
    
    public HorseRanker(Horse[] horses){
        this.horses = horses;
    }
    
    public void determineHorseAtLastPlace(){
        if(horses.length >1){
            Arrays.sort(horses, new Horse());
            if(horses[0].getDistanceTraveled() < horses[1].getDistanceTraveled())
                horses[0].setHorseLastPlace(true);
            else
                horses[0].setHorseLastPlace(false);
            for(int i = 1; i < horses.length; i++){
                horses[i].setHorseLastPlace(false);
            }
        }
    }
}
