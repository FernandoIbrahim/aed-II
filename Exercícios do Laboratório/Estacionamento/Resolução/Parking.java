import java.util.NoSuchElementException;

class Parking{

	private Queue<Car> carsQueu;
	private Queue<Car> auxQueu;
 
	Parking(){
		carsQueu = new Queue<Car>();
		auxQueu = new Queue<Car>();
	}

	public void parkVehicle(Car c){
		carsQueu.enqueue(c);
	}

	/*
	 * manobrarVeiculo
	 * simplementeRetira o veiculo do topo até achar o veiculo requisitado
	 */

	public boolean maneuverVehicle(Car selectedCar) throws Exception{


			if(selectedCar.getPlate().equals(carsQueu.peek().getPlate())){
				return true;
			}
				
			Car c = carsQueu.dequeue();
			c.maneuver();
			auxQueu.enqueue(c);
			return false;

	}

	/*
	 * retirarVeiculo
	 * verificar se o veiculo a ser retirado é igual ao veiculo do topo
	 * caso não seja, joga o veiculo para a fila Auxiliar
	 * 
	 * ao encontrar ele retira o veiculo desejado da filaPrincipal
	 * 
	 * termina de jogar os carros restantes a filaAux;
	 * 
	 * tranforma a filaPrincipal em filaAux;
	 * limpaFilaAux 
	 * 
	 */


	public Car removeVehicle(Car c) throws NoSuchElementException{

		try{
			while (!(maneuverVehicle(c)));

				c = carsQueu.dequeue();
				
		}catch(Exception NoSuchElementException){
			throw new NoSuchElementException("Carro nao encontrado!");
		}

		while (!carsQueu.isEmpty()){
			auxQueu.enqueue(carsQueu.dequeue());
		}

		carsQueu = auxQueu;
		auxQueu = new Queue<Car>();

        return c;
	}

	public void printAll() throws NoSuchElementException{
		while(!carsQueu.isEmpty()){
			Car c = carsQueu.dequeue();
			System.out.println(c.getPlate());
		}

	}



}