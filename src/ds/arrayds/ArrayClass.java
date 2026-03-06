package ds.arrayds;

public class ArrayClass {
    int size;
    int[] arrayNumber;

    public ArrayClass(int size) {
        arrayNumber = new int[size];
        this.size = 0;
    }

    public void insert(int number) {
        if (size == arrayNumber.length) {
            resize();
        }
        arrayNumber[size] = number;
        size++;
    }

    void resize() {
        int[] newarray = new int[arrayNumber.length * 2];
        for (int i = 0; i < arrayNumber.length; i++) {
            newarray[i] = arrayNumber[i];
        }
        arrayNumber = newarray;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(arrayNumber[i]);
        }
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();

        for (int i = index; i < size - 1; i++) {
            arrayNumber[i] = arrayNumber[i + 1];
        }
        size--;
    }

    public int indexOf(int item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (arrayNumber[i] == item) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int max() {
        if(size==0){
            throw new IllegalArgumentException();
        }
        int maxNo = arrayNumber[0];

        for (int i = 0; i < size; i++) {
            if (maxNo < arrayNumber[i]) {
                maxNo = arrayNumber[i];
            }
        }
        return maxNo;
    }


    public int getItem(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        return arrayNumber[index];
    }

    public ArrayClass intersect(ArrayClass anotherArray) {
        int maxNo = 0;
        ArrayClass cls = new ArrayClass(3);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < anotherArray.size; j++)
                if (arrayNumber[i] == anotherArray.getItem(j)) {
                    cls.insert(arrayNumber[i]);
                }
        }
        return cls;
    }

    public ArrayClass reverse() {
        ArrayClass newClass = new ArrayClass(3);
        for (int i = size - 1; i >= 0; i--) {
            newClass.insert(arrayNumber[i]);
        }
        return newClass;
    }



    // [10,20,30,40,50,60,70,80,90]
    public void insertAt(int item, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException();

        if (size == arrayNumber.length)
            resize();

        for (int i = size - 1; i >= index; i--) {
            arrayNumber[i + 1] = arrayNumber[i];
        }

        arrayNumber[index] = item;
        size++;
    }
}
