public class Process implements ProcessInterface, Comparable {

        private int priLevel;
        private int arrivalTime;
        private int waitTime;
        private int timeRem;
        private int reqProcTime;

        public Process(int currentTime, int ranPri, int reqProcessingTime){
            priLevel = ranPri;
            reqProcTime = reqProcessingTime;
            waitTime = 0;
            timeRem = reqProcessingTime;
            arrivalTime = currentTime;
        }
    @Override
    public int getPriority() {
        return this.priLevel;
    }

    @Override
    public void setPriority(int priority) {
        this.priLevel = priority;
    }

    @Override
    public int getTimeRemaining() {
        return this.timeRem;
    }

    @Override
    public void decrementTimeRemaining() {
        this.timeRem--;
    }

    @Override
    public boolean finished() {
        if(this.timeRem <= 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public int getArrivalTime() {
        return this.arrivalTime;
    }

    @Override
    public int getWaitingTime() {
        return this.waitTime;
    }

    @Override
    public void incrementWaitingTime() {
        this.waitTime++;
    }

    @Override
    public void resetWaitingTime() {
        this.waitTime = 0;
    }


    @Override
    public int compareTo(Object o) {
            //if o is higher priority return 1 else return -1
        Process i = (Process)o;
        if(i.priLevel > this.priLevel) {
            return 1;
        }
        else if(i.priLevel == this.priLevel) {
            //check arrival time
            if(i.arrivalTime < this.arrivalTime) {
                return 1;
            }
            else {
                return -1;
            }
        }
        else {
            //o has a smaller priLevel then the comparing Process
            return -1;
        }

    }
}