
public class Stack<E> {
   
    private StackElement<E> top;
    private StackElement<E> bottom;


    public Stack(){

        StackElement<E> sentinel = new StackElement<>();
        this.bottom = sentinel;
        this.top = sentinel;

    }

    public boolean empty(){

        return bottom == top;

    }

    public void push(E data){
        
        top = new StackElement<>(data, top);

    }

    public E pop(){
        E unstacked = this.peek();
        top = top.getNext();
        return unstacked;
    }

    public E peek(){
        if(empty())
            throw new IllegalStateException("Stack is empty");

        return top.getData();
    }

}
