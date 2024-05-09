import java.util.NoSuchElementException;

public class List<E>{

    private int first;
    private int last;
    private E[] listArray;

    @SuppressWarnings("unchecked")
    List(int tamanho){
        this.listArray = (E[]) new Object[tamanho];
    } 

    public boolean isFull(){
        return (this.last == listArray.length);
    }

    public boolean isEmpty(){
        return (first == last);
    }

    public void insert(E item, int position){

        if(isFull()){

            throw new IllegalStateException("It's not possible to insert the value, the list is full");

        }

        if((position < 0 ) || position > this.last){
            throw new IndexOutOfBoundsException("It's not possible to insert the value, invalid position");
        }

        for(int i = this.last; i > position; i--){
            listArray[i] = listArray[i-1];
        }

        listArray[position] = item;
   
        last++;
    }

    public void insert(E item){

        if(isFull()){

            throw new IllegalStateException("It's not possible to insert the value, the list is full");
            
        }

        listArray[this.last++] = item;

    }


    public E remove(int position){

        if(position < 0 || position >= this.last){

            throw new IndexOutOfBoundsException("It's not possible to insert the value, invalid position");

        }

        E removedElement = listArray[position];
        this.last--;
        
        for(int i = position; i < this.last; i++){

            listArray[i] = listArray[i+1];
            
        }
        return removedElement;

    }


    public int getPosition(E soughtElement){

        for(int i = 0; i < listArray.length; i++){
            if(listArray[i].equals(soughtElement)){
                return i;
            }
        }
        throw new NoSuchElementException("O item procurado nao foi encontrado!");
    }

    public E getElement(int position){
        if((position < 0 ) || position > this.last){
            throw new IndexOutOfBoundsException("It's not possible to insert the value, invalid position");
        }

        return this.listArray[position];

    }


    public int getSize(){
        return this.last;
    }



}