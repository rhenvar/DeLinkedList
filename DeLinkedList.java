import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Doubly Linked List
// TODO: Implement removing and iterator
public class DeLinkedList<T> implements Iterable<T> {
    private DeListNode<T> head;
    private DeListNode<T> tail;
    private int size;
    
    // TODO: implement usage to avoid concurrent modification with iterator
    private int mod;
    
    public DeLinkedList() {
	this.head = new DeListNode<>(null, null, null);
	this.tail = new DeListNode<>(head, null, null);
	this.head.next = tail;
	this.size = 0;
	this.mod = 0;
    }
    
    public void add(T value) {
	add(tail.prev, value);
    }
    
    public void add(int index, T value) {
	if (index < 0 || index >= size) {
	    throw new IllegalArgumentException();
	}
	if (index < size / 2) {
	    DeListNode<T> current = head;
	    int i = 0;
	    while (i < index) {
		current = current.next; 
		i++;
	    }
	    add(current, value);
	}
	else {
	    DeListNode<T> current = tail;
	    int i = size;
	    while (i > index) {
		current = current.prev;
		i--;
	    }
	    add(current, value);
	}
    }
    
    private void add(DeListNode<T> before, T value) {
	DeListNode<T> toAdd = new DeListNode<>(before, before.next, value);
	before.next.prev = toAdd;
	before.next = toAdd;
	this.size++;
    }
    
    public boolean contains(T t) {
	// maybe use iterator?
	return false;
    }
    
    public List<T> toArray() {
	List<T> toList = new ArrayList<>();
	DeListNode<T> current = head.next;
	while (current != null && current.field != null) {
	    toList.add(current.field);
	    current = current.next;
	}
	return toList;
    }
    
    @Override
    public String toString() {
	return toArray().toString();
    }
    
    @Override
    public Iterator<T> iterator() {
	// TODO Auto-generated method stub
	return null;
    }
    
    private class DeListNode<T> {
	public DeListNode<T> next;
	public DeListNode<T> prev;
	public T field;
	
	public DeListNode(DeListNode<T> prev, DeListNode<T> next, T field) {
	    this.prev = prev;
	    this.next = next;
	    this.field = field;
	}
    }
    
    private class DeLinkedListIterator<T> implements Iterable<T> {

	@Override
	public Iterator<T> iterator() {
	    // TODO Auto-generated method stub
	    return null;
	}
	
    }
}
