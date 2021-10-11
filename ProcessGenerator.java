import java.util.Random;
public class ProcessGenerator implements ProcessGeneratorInterface{

    private Random random;
    private double prob;

    public ProcessGenerator(double probability, long seed){
        random = new Random(seed);
        prob = probability;
    }

    public ProcessGenerator(double probability){
        random = new Random();
        prob = probability;
    }

    @Override
    public Process getNewProcess(int currentTime, int maxProcessTime, int maxPriority) {
        int pri = random.nextInt(maxPriority) + 1;
        int time = random.nextInt(maxProcessTime) + 1;
        Process newJob = new Process(currentTime, pri, time);
        return newJob;
    }

    @Override
    public boolean query() {
        if(random.nextDouble() < prob){
            return true;
        }
        return false;
    }
}
