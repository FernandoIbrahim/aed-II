public class Car {
	
	private String plate;
    private int manuevers;

	Car(String plate){
		this.plate = plate;
		manuevers = 0;
	}

	public void maneuver(){
		this.manuevers++;
	}

    public int getManeuvers() {
        return manuevers;
    }

	public String getPlate() {
		return plate;
	}
}
