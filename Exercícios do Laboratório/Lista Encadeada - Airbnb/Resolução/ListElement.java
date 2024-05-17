
public class ListElement<E>{

    private E element;
    private ListElement<E> nextElement;

    ListElement(){
        this.element = null;
        this.nextElement = null;
    }

    ListElement(E element){
        this.element = element;
        this.nextElement = null;
    }

    ListElement(E element, ListElement<E> nextElement){
        this.element = element;
        this.nextElement = nextElement;
    }

    public E getElement() {
        return element;
    }


    public ListElement<E> getNextElement() {
        return nextElement;
    }

    public void setNextElement(ListElement<E> nextElement) {
        this.nextElement = nextElement;
    }
    
}


