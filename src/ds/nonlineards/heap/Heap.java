package ds.nonlineards.heap;


//Heap tree will be travelled, level by level, it is level  order traversal
//the level start from left to right
//once after completing the level, it will go to another level
//parent node alway greater than left and right child node.

//To create this heap tree, we should use, array structure.
// and this one is time efficient and memory efficient.
//It also can be implement via Node with left and right sub tree.
// but it is not time and space efficient. inserting, O(log n) and search O(n)
// where as, when we implement via array, it is O(log n) and search O(log n)
// to find the child of the parent has some formula
// that is
// leftChild = (parent * 2) + 1
// rightChild = (parent * 2) + 2

// to find the parent
// parent = (childIndex - 1 ) / 2


//              20
//       15           17
//    3      4      6     8

public class Heap {
    int[] array;
    int count;
    int size;

    Heap(int capacity) {
        array = new int[capacity];
        size = capacity;
    }

    public void insert(int value) {
        if (isFull()) {
            resize();
        }
        array[count++] = value;

        bubbleUp();
    }

    int parent(int index){
        return (index - 1) / 2;
    }
    void swap(int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    void bubbleUp() {
        var index = count - 1;
        while (index>0 && array[index] > array[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    void resize() {
        int[] newArray = new int[size * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    boolean isFull() {
        return array.length == size;
    }


    public int remove() {
        //Removing Heap always remove the root node of the heap tree and replace the last node to root
        //
        if (count == 0)
            throw new IllegalStateException();

        int root = array[0];

        array[0] = array[--count];//assiging last node to the root
        heapifyDown(0);//bubble Down in Progress, always starts with root node

        return root;
    }

    private void heapifyDown(int index) {

        while (getLeftChildIndex(index) < count) { // checking, left child index always less than count

            int leftChildIndex = getLeftChildIndex(index); //getting left child index
            int rightChildIndex = getRightChildIndex(index); //getting right child index

            int largerChildIndex;

            // if right child index is greater than count,but there is no Right child,
            // this means setting the larger child index to left child
            //
            //in else case, compare the value of left and right child and get their index
            //and set this index to largerChildIndex
            if (rightChildIndex >= count)
                largerChildIndex = leftChildIndex;
            else
                largerChildIndex = (array[leftChildIndex] > array[rightChildIndex])
                        ? leftChildIndex
                        : rightChildIndex;

            // when value of array[index] is greater than or equal to array[largerChildIndex],
            // no more swapping required, we just break the loop, because, the all the root
            // values are greater than their child nodes
            if (array[index] >= array[largerChildIndex])
                break;


            //swapping down the lower value, and swapping up the higher value to the parent node.
            swap(index, largerChildIndex);
            //Then setting up the largerChildIndex to index for further swap
            index = largerChildIndex;
        }
    }
    int getLeftChildIndex(int index){
        return (index * 2) +1;
    }
    int getRightChildIndex(int index){
        return (index * 2) + 2;
    }


}
