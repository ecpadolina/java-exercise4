import java.util.concurrent.CyclicBarrier;

public class HorseRaceBarriers{

    private CyclicBarrier gateBarrier;
    private CyclicBarrier finishLineBarrier;
    
    public HorseRaceBarriers(int numOfHorses){
        gateBarrier = new CyclicBarrier(numOfHorses, gateBarrierRunnable);
        finishLineBarrier = new  CyclicBarrier(numOfHorses, finishLineBarrierRunnable);
    }
    
    private static Runnable gateBarrierRunnable = new Runnable(){
        public void run(){
            System.out.println("All horses at gate! Start countdown!");
            System.out.print("Race starting in...");
            try {
                for(int i = 5; i != 0; i--){
                    System.out.print(i);
                    Thread.sleep(1000);
                }
                System.out.println();
            } catch (InterruptedException e) { 
                System.out.println("Thread Interrupted");
            }
        }  
    };
    
    private static Runnable finishLineBarrierRunnable = new Runnable(){
        public void run(){
            System.out.println("All horses are now finished!");
        }
    };
    
    public CyclicBarrier getGateBarrier(){
        return gateBarrier;
    }
    
    public CyclicBarrier getFinishLineBarrier(){
        return finishLineBarrier;
    }
}
