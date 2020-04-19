public class MyVector<E> extends MyAbstractList<E> {

    E[] List;
    E[] List2;
    private int capacity = 10;
    private int incrementCapacity = 5;

    @SuppressWarnings("unchecked")
    public MyVector() {
        size = 0;
        List = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public MyVector(int capacity) {
        size = 0;
        this.capacity = capacity;
        List = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public MyVector(int capacity, int increment) {
        size = 0;
        this.capacity = capacity;
        this.incrementCapacity = increment;
        List = (E[]) new Object[capacity];
    }

    public int getIncrement(){
        return incrementCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        String output = "[";
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                output += List[i] + "]";
            } else {
                output += List[i] + ", ";
            }
        }
        return output;
    }

    @Override
    public E get(int index) {

        return List[index];

    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean add(int index, E data) throws IndexOutOfBoundsException {

        if (size == capacity) {
            List2 = (E[]) new Object[capacity];
            for (int i = 0; i < capacity; i++) {
                List2[i] = List[i];
            }
            List = (E[]) new Object[capacity + incrementCapacity];
            for (int i = 0; i < capacity; i++) {
                List[i] = List2[i];
            }

        }
        List2 = (E[]) new Object[size + 1];
        try {

            for (int i = 0; i < index; i++) {
                List2[i] = List[i];
            }
            for (int i = index + 1; i < size + 1; i++) {
                List2[i] = List[i - 1];
            }
            List2[index] = data;

            List = (E[]) new Object[List2.length];
            for (int i = 0; i < List2.length; i++) {
                List[i] = List2[i];
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.print("index < 0 || index > size()");
        }
        size++;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {

        int x = getCapacity();
        List = (E[]) new Object[x];
        size = 0;

    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {

        List2 = (E[]) new Object[size - 1];
        for (int i = 0; i < index; i++) {
            List2[i] = List[i];
        }
        for (int i = index; i < size - 1; i++) {
            List2[i] = List[i + 1];
        }
        List = (E[]) new Object[List2.length];
        for (int i = 0; i < List2.length; i++) {
            List[i] = List2[i];
        }
        size--;
        return List[index];

    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean add(E data) {
        if (size == capacity) {
            List2 = (E[]) new Object[capacity];
            for (int i = 0; i < capacity; i++) {
                List2[i] = List[i];
            }
            List = (E[]) new Object[capacity + incrementCapacity];
            for (int i = 0; i < capacity; i++) {
                List[i] = List2[i];
            }

        }
        List[size] = data;
        size++;

        return true;

    }

    @Override
    @SuppressWarnings("unchecked")
    public void trimToSize() {


        if (size < getCapacity()) {


            for (int i = 0; i < List.length; i++) {
                List[i] = List[i];
            }
            List = (E[]) new Object[size];
            for (int i = 0; i < size; i++) {
                List[i] = List[i];
            }

        }

    }
}
