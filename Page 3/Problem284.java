import java.util.Iterator;
import java.util.List;

public class Problem284 {
    public static void main(String[] args) {
        // Example usage
        List<Integer> list = List.of(1, 2, 3);
        PeekingIterator peekingIterator = new PeekingIterator(list.iterator());

        while (peekingIterator.hasNext()) {
            System.out.println(peekingIterator.peek()); // Should print the next element without advancing
            System.out.println(peekingIterator.next()); // Should print the next element and advance
        }
    }
}

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private boolean hasPeeked;
    private Integer peekedElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasPeeked) {
            peekedElement = iterator.next();
            hasPeeked = true;
        }
        return peekedElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasPeeked) {
            return iterator.next();
        }
        Integer result = peekedElement;
        hasPeeked = false;
        peekedElement = null;
        return result;
    }

    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
    }
}