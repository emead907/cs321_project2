public class MyPriorityQueue extends MaxHeap implements PriorityQueueInterface{

    public MyPriorityQueue() {
        super();
    }

    @Override
    public void enqueue(Process p) {
        insertProcess(p);
    }

    @Override
    public Process dequeue() {
        try {
            return extractMax();
        } catch (HeapException e) {
            e.printStackTrace();
            System.exit(-1);
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return heapIsEmpty();
    }


    @Override
    public void update(Process next, int timeToIncrementPriority, int maxPriority) {
        next.resetWaitingTime();

        for (int i = 0; i < heapSize; i ++) {
            A[i].incrementWaitingTime();
            if (A[i].getWaitingTime() >= timeToIncrementPriority) {
                A[i].resetWaitingTime();
                if (A[i].getPriority() < maxPriority) {
                    A[i].setPriority(A[i].getPriority() + 1);
                    try {
                        increaseKey(i, A[i].getPriority());
                    } catch (HeapException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                }
            }

        }
    }
}
