import java.util.NoSuchElementException;

public class Queue<E> {
    
    private QueueElement<E> front;
    private QueueElement<E> rear;

    public Queue(){

        QueueElement<E> sentinel = new QueueElement<>();
        front = rear = sentinel;

    }

    public boolean isEmpty(){

        return front == rear;

    }


    public void enqueue(E data){

        QueueElement<E> newQueueElement = new QueueElement<>(data);

        rear.setNext(newQueueElement);
        rear = newQueueElement;

    }

    public E peek(){

        if(isEmpty()){

            throw new NoSuchElementException("Empty Queu");

        }
        
        return front.getNext().getElement();

    }


    public E dequeue() {

        if(isEmpty()){

            throw new NoSuchElementException("Empty Queu");

        }
        
        E element = null;
        QueueElement<E> first = new QueueElement<>();

        element = peek();
        first = front.getNext();
        front.setNext(first.getNext());
        
        first.setNext(null);

        if(first == rear){

            rear = front;

        }

        return element;

    }
    

}
