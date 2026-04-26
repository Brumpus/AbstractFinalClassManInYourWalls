import java.util.*;

/**
 * Single-linked node implementation of IndexedUnsortedList.
 * An Iterator with working remove() method is implemented, but
 * ListIterator is unsupported.
 * 
 * @author
 * 
 * @param <E> type to store
 */
public class IUSingleLinkedList<E> implements IndexedUnsortedList<E> {
	private LinearNode<E> front, rear;
	private int count;
	private int modCount;

	/** Creates an empty list */
	public IUSingleLinkedList() {
		front = rear = null;
		count = 0;
		modCount = 0;
	}

	@Override
	public void addToFront(E element) {
		// TODO
		LinearNode<E> newNode = new LinearNode<>();
		newNode.setElement(element);
		newNode.setNext(front);
		front = newNode;

		count++;
		modCount++;
	}

	@Override
	public void addToRear(E element) {
		// TODO
		LinearNode<E> newNode = new LinearNode<>();
		newNode.setElement(element);
		rear.setNext(newNode);
		rear = newNode;

		count++;
		modCount++;
	}

	@Override
	public void add(E element) {
		// TODO
		this.addToRear(element);
	}

	@Override
	public void addAfter(E element, E target) {
		// TODO
		LinearNode<E> currentNode = front;

		while (currentNode != null) {
			if (currentNode.getElement() == target) {
				LinearNode<E> newNode = new LinearNode<>();
				newNode.setElement(element);

				// Link new node in between target and target's next node
				newNode.setNext(currentNode.getNext());
				currentNode.setNext(newNode);

				// If target was the rear node, set the new node being added after it to rear
				if (currentNode == rear)
					rear = newNode;

				count++;
				modCount++;
			}
		}

		throw new NoSuchElementException();
	}

	@Override
	public void add(int index, E element) {
		// TODO
		if (index < 0 || index > count - 1) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			this.addToFront(element);
			return;
		}

		int currentIndex = 1;
		LinearNode<E> previousNode = front;
		LinearNode<E> currentNode = front.getNext();
		LinearNode<E> newNode = new LinearNode<>();
		newNode.setElement(element);

		while (currentIndex != index) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
			currentIndex++;
		}

		// If element is being set to the last index, designate it the new rear
		previousNode.setNext(newNode);
		if (currentNode == null) {
			rear = newNode;
		} else {
			newNode.setNext(currentNode);
		}

		count++;
		modCount++;
	}

	@Override
	public E removeFirst() {
		// TODO
		return null;
	}

	@Override
	public E removeLast() {
		// TODO
		return null;
	}

	@Override
	public E remove(E element) {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		LinearNode<E> current = front, previous = null;
		while (current != null && !current.getElement().equals(element)) {
			previous = current;
			current = current.getNext();
		}
		// Matching element not found
		if (current == null) {
			throw new NoSuchElementException();
		}
		return removeElement(previous, current);
	}

	@Override
	public E remove(int index) {
		// TODO
		return null;
	}

	@Override
	public void set(int index, E element) {
		// TODO

	}

	@Override
	public E get(int index) {
		// TODO
		return null;
	}

	@Override
	public int indexOf(E element) {
		// TODO
		return 0;
	}

	@Override
	public E first() {
		// TODO
		if (isEmpty())
			throw new NoSuchElementException();

		return front.getElement();
	}

	@Override
	public E last() {
		// TODO
		if (isEmpty())
			throw new NoSuchElementException();

		return rear.getElement();
	}

	@Override
	public boolean contains(E target) {
		// TODO
		if (isEmpty())
			return false;
		LinearNode<E> currentNode = front;
		while (currentNode != null) {
			if (currentNode.getElement() == target) {
				return true;
			}
			currentNode = currentNode.getNext();
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO
		return count == 0;
	}

	@Override
	public int size() {
		// TODO
		return count;
	}

	@Override
	public String toString() {
		// TODO
		return "";
	}

	private E removeElement(LinearNode<E> previous, LinearNode<E> current) {
		// Grab element
		E result = current.getElement();
		// If not the first element in the list
		if (previous != null) {
			previous.setNext(current.getNext());
		} else { // If the first element in the list
			front = current.getNext();
		}
		// If the last element in the list
		if (current.getNext() == null) {
			rear = previous;
		}
		count--;
		modCount++;

		return result;
	}

	@Override
	public Iterator<E> iterator() {
		return new SLLIterator();
	}

	/** Iterator for IUSingleLinkedList */
	private class SLLIterator implements Iterator<E> {
		private LinearNode<E> previous;
		private LinearNode<E> current;
		private LinearNode<E> next;
		private int iterModCount;

		/** Creates a new iterator for the list */
		public SLLIterator() {
			previous = null;
			current = null;
			next = front;
			iterModCount = modCount;
		}

		@Override
		public boolean hasNext() {
			// TODO
			return false;
		}

		@Override
		public E next() {
			// TODO
			return null;
		}

		@Override
		public void remove() {
			// TODO
		}
	}

	// IGNORE THE FOLLOWING CODE
	// DON'T DELETE ME, HOWEVER!!!
	@Override
	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator(int startingIndex) {
		throw new UnsupportedOperationException();
	}
}
