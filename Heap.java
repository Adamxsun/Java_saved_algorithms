/* lab3 assignmen
 * Adam Sun
 */
package heap;

/**
 *
 * @author adams
 */
public class Heap { 
    int[] Heap; 
    int size; 
    int capacity; 
    
    public Heap(int capacity) 
    { 
        this.capacity = capacity; 
        this.size = 0; 
        Heap = new int[this.capacity + 1]; 
        Heap[0] = Integer.MAX_VALUE; 
    }//constructor
    private boolean isEmpty()
      { return size == 0; }
    private boolean isFull()
      { return size == capacity; }
    private void makeEmpty()
    {Heap = null;}
    public int heapMax() 
    { 
        int i = Heap[1]; 
        Heap[1] = Heap[size--]; 
        maxHeapify(1); 
        return i; 
    }//heapMax
    private int parent(int i) 
    { return i / 2; } 
    private int leftChild(int i) 
    { return (2 * i);  } 
    private int rightChild(int i) 
    {return (2 * i) + 1;} 
    private void maxHeapify(int i) 
    { 
        if (i >= (size / 2) && i <= size)
            return; 
  
        if (Heap[i] < Heap[leftChild(i)] ||  
            Heap[i] < Heap[rightChild(i)]) { 
  
            if (Heap[leftChild(i)] > Heap[rightChild(i)]) { 
                swap(i, leftChild(i)); 
                maxHeapify(leftChild(i)); } 
            else { 
                swap(i, rightChild(i)); 
                maxHeapify(rightChild(i)); 
            }//else 
        }//if
    }//maxheapify
    private void buildMaxHeap(int A[])
    {
        int start = (A.length / 2) - 1; 
        for (int i = start; i >= 0; i--) { 
            maxHeapify(i); }
    }//buldMaxheap
    public int extractMax() 
    { 
        int max = heapMax();
        deleteNode(heapMax());
        return max;  
    }//extractMax
    public void deleteNode(int i) 
    {Heap[i] = Heap[i+1]; } 
    public void insertNode(int key) 
    { 
        Heap[++size] = key; 
  
        // Traverse up and fix violated property 
        int currentSize = size; 
        while (Heap[currentSize] > Heap[parent(currentSize)]) { 
            swap(currentSize, parent(currentSize)); 
            currentSize = parent(currentSize);  } 
    }//insertNode 
    public void increaseNodeKey(int key,int i){
    key = key + i;
    }//increaseNodeKey
    public void printHeap() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.println(" PARENT : " + Heap[i] + " LEFT CHILD : " + 
                      Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]); 
            System.out.println(); 
        } 
         System.out.println("The max val is " + heapMax()); 
    }//printHeap
    private void swap(int i, int i2) 
    { 
        int number; 
        number = Heap[i]; 
        Heap[i] = Heap[i2]; 
        Heap[i2] = number; 
    } //swap
    public static void main(String  [] arg) 
    { 
        Heap maxHeap = new Heap(18); 
        maxHeap.insertNode(62); 
        maxHeap.insertNode(44); 
        maxHeap.insertNode(17); 
        maxHeap.insertNode(20); 
        maxHeap.insertNode(19); 
        maxHeap.insertNode(55); 
        maxHeap.insertNode(122); 
        maxHeap.insertNode(19); 
        maxHeap.printHeap(); 
    }//main 
} //heap