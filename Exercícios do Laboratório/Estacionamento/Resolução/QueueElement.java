public class QueueElement<T> {
    
    private final T element;
    private QueueElement<T> next;

    public QueueElement(T element){
        this(element, null);
    }

    public QueueElement(){
        this(null, null);
    }


    public QueueElement(T element, QueueElement<T> next){

        this.element = element;
        setNext(next);

    }


    public T getElement() {
        return element;
    }

    public QueueElement<T> getNext() {
        return next;
    }

    public void setNext(QueueElement<T> next) {
        this.next = next;
    }

}
