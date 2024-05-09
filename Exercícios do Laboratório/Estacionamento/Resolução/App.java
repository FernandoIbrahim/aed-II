import java.util.Scanner;

public class App {

	public static void main(String[] agrs) throws Exception{

		Scanner scanner = new Scanner(System.in);

		Parking e = new Parking();
		String data;
		

			while(!(data = scanner.nextLine()).equals("FIM")){

				try{

					String[] dataArray = data.split(" ");

					String operation = dataArray[0];
					Car car = new Car(dataArray[1] + " " + dataArray[2]);

					switch (operation) {

						case "P":

							car = e.removeVehicle(car);
							System.out.println("Carro de placa " + car.getPlate() +" saiu do estacionamento.");
							System.out.println("Esse carro foi manobrado "+ car.getManeuvers() + " vezes.");

							break;

						case "C":

							e.parkVehicle(car);
							System.out.println("Carro de placa " + car.getPlate() + " entrou no estacionamento.");

							break;
					
					}

					car = null;

					}catch(RuntimeException error){

						System.out.println(error.getMessage());

					}

			}

			e.printAll();

			scanner.close();
	}
}



