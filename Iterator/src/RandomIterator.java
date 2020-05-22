import java.util.Iterator;

public class RandomIterator<T> implements Iterator<Integer> {
    private Integer[] array;


    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        int a = (int) (Math.random() * array.length);
        return array[a];
    }
}
