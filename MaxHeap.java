public class MaxHeap {

    //heap insert
        //Heap insert puts a new element in the last spot of the array and call increae key on that index
    //increase key - look at pg 185

    protected int heapSize;
    protected Process A[];

    public MaxHeap() {
        heapSize = 0;
        A = new Process[10];
    }

    public boolean heapIsEmpty(){
        if(heapSize == 0){
            return true;
        }
        return false;
    }

    public void MaxHeapify(int index){
        int left = index + 1;
        int right = index + 2;

        int largest = -1;

        if(left < heapSize && A[left].compareTo(A[index]) == -1) {
            largest = left;
        }
        else {
            largest = index;
        }
        if (right < heapSize && A[right].compareTo(A[largest]) == -1) {
            largest = right;
        }

        if(largest != index) {
            swap(largest, index);
            MaxHeapify(largest);
        }


    }

    private void swap(int posOne, int posTwo) {
        Process placeholder = A[posOne];
        A[posOne] = A[posTwo];
        A[posTwo] = placeholder;
    }

    //return max, let it 0 call hepify return last one.

    public Process extractMax() throws HeapException
    {
        if(heapSize < 1){
            throw new HeapException(("You cant extract from an empty heap"));
        }
        else {
            Process max = A[0];
            A[0] = A[heapSize - 1];
            heapSize--;
            MaxHeapify(0);
            return max;
        }
    }

    public void increaseKey(int index, int priority) throws HeapException
    {
        if(priority < A[index].getPriority()) {
            throw new HeapException(("Key can only go up"));
        }
        else {
            A[index].setPriority(priority);

            while(index > 0 && A[Math.floorDiv((index -1), 2)].compareTo(A[index]) == 1) {
                swap(index, Math.floorDiv((index -1), 2));
                index = Math.floorDiv((index -1), 2);
            }
        }
    }

    public void insertProcess(Process p){
        if(heapSize >= A.length){ //Need to expand the array
            expandArray(A);
        }
        int pPri = p.getPriority();
        A[heapSize] = p;
        A[heapSize].setPriority(Integer.MIN_VALUE);
        heapSize++;
        try {
            increaseKey(heapSize - 1, pPri);
        } catch (HeapException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void expandArray(Process[] oldArray){
        Process[] newArray = new Process[oldArray.length * 2];
        for(int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        A = newArray;
    }

}


