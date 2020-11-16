package starter;
import java.util.ArrayList;
import javax.smartcardio.Card;

class Queue {
	int front, rear, size;
	int capacity;
	int array[];
	
	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		System.out.println (queue.dequeue() + " dequeued form queque");
		System.out.println (queue.front() + " from the front of queue");
		System.out.println (queue.rear() + " from the back of queue");
	}
	
	public Queue(int capacity) {
		this.capacity = capacity;
		front = this.size = 0;
		rear = capacity - 1;
		array = new int[this.capacity];
	}
	
	boolean isFull (Queue queue) {
		return (queue.size == queue.capacity);
	}
	
	boolean isEmpty (Queue queue) {
		return (queue.size == 0);
	}
	
	void enqueue (int item)  {
		if (isFull(this))
			return;
		this.rear = (this.rear + 1) % this.capacity;
		this.array[this.rear] = item;
		this.size = this.size + 1;
	}
	
	int dequeue() {
		if (isEmpty(this)) 
			return Integer.MIN_VALUE;
		int item = this.array[this.front];
		this.front = (this.front + 1) % this.capacity;
		this.size = this.size - 1;
		return item;
	}
	
	int front () {
		if (isEmpty(this))
			return Integer.MIN_VALUE;
		
		return this.array[this.front];
	}
	
	int rear () {
		if (isEmpty(this))
			return Integer.MIN_VALUE;
		
		return this.array[this.rear];
	}
	
 }








/*Deck {

	ArrayList<Card> pile;
	ArrayList<Card> cards;

	public Deck(ArrayList<Card> c) {
		cards = c;
	}

	public Deck() {
		cards = new ArrayList<Card>(108);
	}

	public void addCard(Card c) {
		cards.add(c);
	}

}*/