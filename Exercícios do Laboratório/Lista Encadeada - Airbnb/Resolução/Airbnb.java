public class Airbnb {
    
    private List<Accommodation> accommodationsList;

    public List<Accommodation> getAccommodationsList() {

        return accommodationsList;

    }

    Airbnb(){

        this.accommodationsList = new List<>();

    }

    Airbnb(List<Accommodation> listAcomodacoes){

        this.accommodationsList = listAcomodacoes;

    }

    public void addBegin(Accommodation a){

        accommodationsList.addBegin(a);

    }

    public Accommodation removeTail(){

        return accommodationsList.removeTail();

    }


    public String print(){

        return accommodationsList.print();

    }
    
    public Accommodation getAcomodacaoById(int id){

        for(int i = 0; i < accommodationsList.getSize(); i++){

            if(accommodationsList.getElement(i).getRoomId() == id ){

                return accommodationsList.getElement(i);

            }

        }

        return null;

    }

    public void add(Accommodation a){

        accommodationsList.addBegin(a);

    }


}
