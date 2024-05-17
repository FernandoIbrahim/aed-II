import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {  

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] agrs) {
        try{

        Path path = Paths.get("./tmp/dados_airbnb.txt");

        Map<Integer, Accommodation> accommodationMap = readFileAccommodations(path);
        Accommodation accommodation;
        Airbnb Airbnb = new Airbnb();

        Airbnb = selectAccommodations(accommodationMap);

        int operationsNumber = Integer.parseInt(scanner.nextLine());
        String[] operation;

        while (operationsNumber > 0) {

            operation = scanner.nextLine().split(" ");

            switch (operation[0]) {

                case "II":

                    accommodation = accommodationMap.get(Integer.parseInt(operation[1]));
                    Airbnb.addBegin(accommodation);

                    break;

                case "RF":
                    accommodation = Airbnb.removeTail();
                    System.out.println("(R) " + accommodation.getRoomId());
                    break;

            }

            operationsNumber--;

        }

        System.out.println(Airbnb.print());

        }catch( IOException e){

            System.out.println("Error: "+  e.getMessage());

        }

        scanner.close();
    }


    public static Map<Integer, Accommodation> readFileAccommodations(Path path)
            throws  IOException {

        CSVReader csvReader = new CSVReader(path);

        Accommodation accommodation = new Accommodation();

        List<String[]> data = csvReader.readFileLines();
        Map<Integer, String[]> dataMap = data.toMap();

        Map<Integer, Accommodation> accommodationMap = new HashMap<>();

        for (int i = 0; i < data.getSize(); i++) {

            String[] atributes = dataMap.get(i);
            accommodation = new Accommodation(
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
                    atributes[11]);

            accommodationMap.put(accommodation.getRoomId(), accommodation);
        }

        csvReader.close();

        return accommodationMap;
    }


    public static Airbnb selectAccommodations(Map<Integer, Accommodation> accommodationMap){

        Accommodation accommodation;
        String id;
        Airbnb Airbnb = new Airbnb();

        while (!(id = scanner.nextLine()).equals("FIM")) {

            accommodation = accommodationMap.get(Integer.parseInt(id));
            Airbnb.add(accommodation);

        }
        
        return Airbnb;

    }



}

