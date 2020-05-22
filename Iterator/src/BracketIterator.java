import java.util.Iterator;

public class BracketIterator<T> implements Iterator<T>{

	private T[] data;
	private int tail;
	private int head;
	private boolean step;
	
	public BracketIterator(T[] data){
		this.data = data;
		tail = data.length - 1;
		head = 0;
		step = true;
	}
	
	@Override
	public boolean hasNext() {
		if ((head + 1) < (tail - head)) return true;
		return false;
	}

	@Override
	public T next() {
		if (step) return next(++head);
		return next(--tail);
	}

	private T next(int param) {
		step = !step;
		return data[param];
	}

}