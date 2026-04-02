import java.util.EmptyStackException;


public class StackOperations<T> implements StackInterface<T> {

    // The array that holds the stack entries.
    private Object[] data;
    // Tracks the index of the top entry.
    private int top;
    // The current max size of the array.
    private int capacity;

    // Creates an empty stack with a given capacity.
    public StackOperations(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
        top = -1;   
    }

    // Adds a new entry to the top of the stack. Also it resizes if full.
    @Override
    public void push(T newEntry) {
        if (top == capacity - 1) {
            resize();
        }
        data[++top] = newEntry;
    }

    // Removes and returns the top entry of the stack.
    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T entry = (T) data[top];
        data[top] = null;
        top--;
        return entry;
    }

    // Returns the top entry without removing it.
    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) data[top];
    }

    // Returns true if the stack is empty false otherwise.
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    // Removes all entries from the stack.
    @Override
    public void clear() {
        for (int i = 0; i <= top; i++) {
            data[i] = null;
        }
        top = -1;
    }

    // Doubles the size of the array when it is full.
    private void resize() {
        capacity = capacity * 2;
        Object[] newData = new Object [capacity];
        for (int i = 0; i <= top; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}