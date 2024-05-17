

import java.util.HashMap;
import java.util.Map;


class List<E> {

    private ListElement<E> head;
    private ListElement<E> tail;

    private int size;

    public List(){

        ListElement<E> sentinel = new ListElement<>();
       
        this.head = this.tail = sentinel;
        this.size = 0;

    }

    public boolean isEmpty(){

        return this.head == this.tail;

    }

    public void add(E newElement, int position){

        ListElement<E> previousElement, newListElement, nextElement;

        if((position < 0) || (position > this.size)){

            throw new IndexOutOfBoundsException("It was not possible to inset the element on the list: informed position invalid");

        }



        previousElement = findPreviousElement(position);
        nextElement = previousElement.getNextElement();

        newListElement = new ListElement<E>(newElement, nextElement);
        
        previousElement.setNextElement(newListElement);

        if(position == this.size){

            this.tail = newListElement;

        }

        this.size++;

    }


    public void add(E newElement){

        ListElement<E> newListElement;


        newListElement = new ListElement<E>(newElement);
        
        this.tail.setNextElement(newListElement);
        this.tail = newListElement;

        this.size++;

    }


    public E remove(int position){
        
        ListElement<E> previousElement, removedElement;

        if(position < 0 || position >= this.size || isEmpty()  ){

            throw new IndexOutOfBoundsException("It was not possible to remove the element on the list: informed position invalid");

        }


        previousElement = findPreviousElement(position);
        removedElement = previousElement.getNextElement();
        previousElement.setNextElement(removedElement.getNextElement());

        if( removedElement == this.tail){
            this.tail = previousElement;
        }

        removedElement.setNextElement(null);

        this.size--;

        return removedElement.getElement();
    }


    public ListElement<E> findPreviousElement(int postion){

        ListElement<E> previousElement;

        previousElement = this.head;

        for(int i = 0 ; i < postion; i++ ){

            previousElement = previousElement.getNextElement();

        }

        return previousElement;
    }


    public void addBegin(E element){
        add(element, 0);
    }


    public E removeTail(){
        return remove(this.size - 1);
    }

    public String print(){

        ListElement<E> cell = head.getNextElement();
        String result = "";

        for(int i = 0; i < size; i++ ){
            result += "["+ i + "] " + cell.getElement().toString() + "\n";
            cell = cell.getNextElement();
        }

        return result;

    }

    public int getSize() {
        return size;
    }

    public E getElement(int position){

        if(position < 0 || position >= this.size || isEmpty()  ){

            throw new IndexOutOfBoundsException("It was not possible to remove the element on the list: informed position invalid");

        }

        ListElement<E> previousElement;

        previousElement = this.head;

        for(int i = 0 ; i < position; i++ ){

            previousElement = previousElement.getNextElement();

        }

        return previousElement.getNextElement().getElement();
    }




    public Map<Integer, E> toMap(){

        Map<Integer,E> elementMap = new HashMap<>();
        ListElement<E> element = head.getNextElement();

        for(int i = 0; i < this.size; i++){

            elementMap.put(i, element.getElement());
            element = element.getNextElement();

        }

        return elementMap;

    }


}