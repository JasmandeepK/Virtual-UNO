package starter;
import java.util.ArrayList;
import javax.smartcardio.Card;

public class Queue {
	int front, rear, size;
	int capacity;
	UnoCard[] array;
	
	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.enqueue(new UnoCard(1,4));
		queue.enqueue(new UnoCard (2,6));
		queue.enqueue(new UnoCard (3,8));
		queue.enqueue(new UnoCard (4,10));
		
		System.out.println (queue.dequeue().getColorType().getColor()+" "+queue.dequeue().getCardValue().getValue() + " dequeued form queque");
		System.out.println (queue.front().getColorType().getColor()+" "+queue.front().getCardValue().getValue() + " from the front of queue");
		System.out.println (queue.rear().getColorType().getColor()+" "+queue.rear().getCardValue().getValue() + " from the back of queue");
	}
	
	public Queue(int capacity) {
		this.capacity = capacity;
		front = this.size = 0;
		rear = capacity - 1;
		array = new UnoCard[this.capacity];
	}
	
	public boolean isFull (Queue queue) {
		return (queue.size == queue.capacity);
	}
	
	public boolean isEmpty (Queue queue) {
		return (queue.size == 0);
	}
	
	public void enqueue (UnoCard item)  {
		if (isFull(this))
			return;
		this.rear = (this.rear + 1) % this.capacity;
		this.array[this.rear] = item;
		this.size = this.size + 1;
	}
	
	public UnoCard dequeue() {
		if (isEmpty(this)) 
			return null;
		UnoCard item;
		item = this.array[this.front];
		this.front = (this.front + 1) % this.capacity;
		this.size = this.size - 1;
		return item;
	}
	
	public UnoCard front () {
		if (isEmpty(this))
			return null;
		
		return this.array[this.front];
	}
	
	public UnoCard rear () {
		if (isEmpty(this))
			return null;
		
		return this.array[this.rear];
	}
	
 }
