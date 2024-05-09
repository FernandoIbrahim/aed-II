import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


public class Airbnb {
    
    private List<Acomodacao> listAcomodacoes;

    public List<Acomodacao> getListAcomodacoes() {
        return listAcomodacoes;
    }

    Airbnb(){
        this.listAcomodacoes = new ArrayList<>();
    }

    Airbnb(List<Acomodacao> listAcomodacoes){
        this.listAcomodacoes = listAcomodacoes;
    }

    public Acomodacao findByIdAcomodacao(int id){
        Optional<Acomodacao> findedAcomodacao = listAcomodacoes.stream().filter(a -> a.getRoomId() == id).findFirst();
        if(!findedAcomodacao.isPresent())
            return null;

        return findedAcomodacao.get();
    }


    public String getAcomodacaoDataById(int id){
        Acomodacao a = findByIdAcomodacao(id);

        if(a == null)
            throw new NoSuchElementException();

        return a.print();
    }


}
