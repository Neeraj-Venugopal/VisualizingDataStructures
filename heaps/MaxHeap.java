package heaps;

import java.util.LinkedHashSet;
import java.util.Set;

public class MaxHeap {
	
	private int[] heap;
	private int size;
	private int maxSize;
	private static final int front = 1;
	private static int total;
	
	public MaxHeap(int maxSize){
		this.maxSize = maxSize;
		this.size = 0;		
		this.heap = new int[this.maxSize+1];
		//heap[0] is always considered to be a max integer value for convenience
		this.heap[0] = Integer.MAX_VALUE;
	}
	
	public int parentPos(int pos){		
		return pos/2;
	}
	
	public int leftChildPos(int pos){
		return 2 * pos;
	}
	
	public int rightChildPos(int pos){
		return 2 * pos + 1;
	}
	
	public void swap(int pos1, int pos2){
		int temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp; 
	}
	
	public void insert(int node){
		heap[++size] = node;
		int current = size;
		/* The following condition will check if the insertIntoHeaped element is less or greater to
		 * to the max heap/1st element in the array.
		 * If the insertIntoHeaped element is large then we swap it and update the size to parent's position element.
		 */
		while(heap[parentPos(current)] < heap[current]){
			swap(parentPos(current), current);
			current = parentPos(current);
		}		
	}
	
public void printHeap()
    {
        for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print(" Parent Node : " + heap[i]);
            
            System.out.print(" Left Child : " + heap[2*i]);
            if(2 * i  + 1 <= size)
            	 System.out.print(" Right Child : " + heap[2*i + 1]);   
            else{
            	System.out.print(" Right Child : null");
            }
            System.out.println("");
        }
    }
	
	  private boolean isLeaf(int pos)
	    {
	        if (pos >=  (size / 2)  &&  pos <= size)
	        {
	            return true;
	        }
	        return false;
	    }
	  
    private void maxHeapify(int pos)
    {
    if (!isLeaf(pos) && size > 1)
        { 
            if ( heap[pos] < heap[leftChildPos(pos)]  || heap[pos] < heap[rightChildPos(pos)])
            {
                if (heap[leftChildPos(pos)] > heap[rightChildPos(pos)])
                {
                    swap(pos, leftChildPos(pos));
                    maxHeapify(leftChildPos(pos));
                }else
                {
                    swap(pos, rightChildPos(pos));
                    maxHeapify(rightChildPos(pos));
                }
            }
        }
    }
    public void maxHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--)
        {
            maxHeapify(pos);
        }
    }
	
    public int removeMaxNode(){
    	int max = heap[front];
    	heap[front] = heap[size]; // Assign the last node to the front after removing it 
    	size--; // Decrement the size of the array as we have removed an element
    	maxHeapify(front); // Now heapify the whole array to build the heap again after removal    	
    	return max;    	
    }
    
    public  void sort(int arr[]){ 
    	total = arr.length - 1;
    	for(int i= total/2; i>=0; i--){
    		sortHeapify(arr,i);
    	}   	
    	
    	for(int i= total; i>0; i--){
    		swapForSort(arr, 0, i);
    		total--;
    		sortHeapify(arr, 0);
    	}
    	
    	
    }
    
    public void sortHeapify(int arr[], int pos){
    	int leftPos = leftChildPos(pos);
    	int rightPos = rightChildPos(pos);
    	int greaterPos = pos;
    	if(leftPos <= total && arr[leftPos] > arr[greaterPos])
    		greaterPos = leftPos;
    	if(rightPos <= total && arr[rightPos] > arr[greaterPos])
    		greaterPos = rightPos;
    	if(greaterPos != pos){
    		swapForSort(arr, pos, greaterPos);
    		sortHeapify(arr, greaterPos);
    	}
    }
    
    public void swapForSort(int arr[],int pos1, int pos2){
    	int temp = arr[pos1];
    	arr[pos1] = arr[pos2];
    	arr[pos2] = temp;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  MaxHeap maxHeap = new MaxHeap(9);
		  /*maxHeap.insert(1);
		  maxHeap.insert(2);
		  maxHeap.insert(3);*/

	        maxHeap.insert(512);
	        maxHeap.insert(7);
	        maxHeap.insert(2);
	        maxHeap.insert(100);
	        maxHeap.insert(1);
	        maxHeap.insert(999);
	        maxHeap.insert(40);
	        maxHeap.insert(41);
	        maxHeap.insert(3);
	        
	        System.out.println("Elements after insert: ");
	        maxHeap.printHeap();
	        
	        System.out.println("");
	        
	        System.out.println("Elements after heapify: ");
	        maxHeap.maxHeap();	 
	        maxHeap.printHeap();
	        
	        System.out.println("");
	        System.out.println("Heap after removal: ");
	        int maxNode  = maxHeap.removeMaxNode();
	        //maxHeap.removeMaxNode();
	        maxHeap.printHeap();	        
	        System.out.println("The max Node removed is: " + maxNode);
	        
	       //Given an array, do heap sort on it:
	        
	        int arr[] = {3,2,1,5,4};
	        maxHeap.sort(arr);
	        System.out.println("The sorted array is: ");
	       for(int i=0; i<arr.length; i++){
	    	   System.out.print(arr[i] + " ");
	       }
	}

}
