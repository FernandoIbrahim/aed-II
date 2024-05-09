import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App{
    public static void main(String[] agrs){

        Path path = Paths.get("./tmp/dados_airbnb.txt");
        Scanner scanner = new Scanner(System.in);

        try(CSVReader csvReader = new CSVReader(path)){

            Acomodacao acomodacao = new Acomodacao();

            List<String[]> data = csvReader.readFileLines();
            List<Acomodacao> acomodationsList = new ArrayList<>();

            
            for (String[] atributes : data) {

                acomodacao = new Acomodacao(
                    atributes[0],
                    atributes[1],
                    atributes[2],
                    atributes[3],
                    atributes[4],
                    atributes[5], 
                    atributes[6], 
                    atributes[7], 
                    atributes[8], 
                    atributes[9], 
                    atributes[10], 
                    atributes[11]
                );

                acomodationsList.add(acomodacao);
            }

            Airbnb airbnb = new Airbnb(acomodationsList);

            String id;

            while ((id = scanner.nextLine()) != "FIM") {
                
                String acomodacaoData = airbnb.getAcomodacaoDataById(Integer.parseInt(id));
                System.out.println(acomodacaoData);

            }

        }catch(Exception e){

            System.out.println("Error: " + e.getMessage());

        }

        scanner.close();

    }   

}

