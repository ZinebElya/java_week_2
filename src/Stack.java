/*TODO: Write a datastructure that is a stack. It stacks elements of a certain generic type.
    That means that the first one in the stack will be the last one out.
 */
import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    private ArrayList<T> items;

    public Stack() {
        items = new ArrayList<T>();
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.remove(items.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.get(items.size() - 1);
    }
}

/*
In this implementation, T is the generic type parameter that represents the type of the elements that the stack can store.
The Stack class has an ArrayList field items that stores the elements in the stack.
The isEmpty() method checks if the stack is empty,
the push() method adds an item to the top of the stack,
the pop() method removes and returns the item at the top of the stack,
and the peek() method returns the item at the top of the stack without removing it.
 */