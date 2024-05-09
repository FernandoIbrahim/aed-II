public class StackElement<T> {
    
    private final T data;
    private StackElement<T> next;

    public StackElement(T data){

        this.data = data;
        this.next = null;

    }

    public StackElement(){

        this.data = null;
        this.next = null;

    }

    public StackElement(T data, StackElement<T> next){

        this.data = data;
        this.next = next;
        
    }


    public T getData() {

        return data;
        
    }

    public StackElement<T> getNext() {

        return next;

    }


    public void setNext(StackElement<T> next) {

        this.next = next;

    }



}

