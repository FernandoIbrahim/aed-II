import java.util.Scanner;

public class Accommodation {

    private int roomId;
    private int hostId;
    private String roomType;
    private String country;
    private String city;
    private String neighbourhood;
    private int reviews;
    private double overallSatisfaction;
    private int accommodations;
    private double bedrooms;
    private double price;
    private String propertyType;

    public Accommodation(int roomId, int hostId, String roomType, String country, String city, String neighbourhood,
            int reviews, double ouverallSatisfaction, int accommodations, double bedrooms, double price,
            String propertyType) {

        setRoomId(roomId);
        setHostId(hostId);
        setRoomType(roomType);
        setCountry(country);
        setCity(city);
        setNeighbourhood(neighbourhood);
        setReviews(reviews);
        setOverallSatisfaction(ouverallSatisfaction);
        setAccommodations(accommodations);
        setBedrooms(bedrooms);
        setPrice(price);
        setPropertyType(propertyType);
        
    }

    public Accommodation(String roomId, String hostId, String roomType, String country, String city, String neighbourhood,
            String reviews, String ouverallSatisfaction, String accommodations, String bedrooms, String price,
            String propertyType) {

        String[] StringToIntegerItensArray = new String[] { roomId, hostId, reviews, accommodations };
        int[] integerItensArray = new int[StringToIntegerItensArray.length];

        for (int i = 0; i < integerItensArray.length; i++) {

            integerItensArray[i] = Integer.parseInt(StringToIntegerItensArray[i]);

        }

        String[] StringToDoubleItensArray = new String[] { ouverallSatisfaction, bedrooms, price };
        double[] doubleItensArray = new double[StringToDoubleItensArray.length];

        for (int i = 0; i < doubleItensArray.length; i++) {

            doubleItensArray[i] = Double.parseDouble(StringToDoubleItensArray[i]);

        }

        setRoomId(integerItensArray[0]);
        setHostId(integerItensArray[1]);
        setRoomType(roomType);
        setCountry(country);
        setCity(city);
        setNeighbourhood(neighbourhood);
        setReviews(integerItensArray[2]);
        setOverallSatisfaction(doubleItensArray[0]);
        setAccommodations(integerItensArray[3]);
        setBedrooms(doubleItensArray[1]);
        setPrice(doubleItensArray[2]);
        setPropertyType(propertyType);
    }

    public Accommodation() {

    }

    public String print() {

        return "[" + getRoomId() + " ## " + getHostId() + " ## " + getRoomType() + " ## " + getCountry() + " ## "
                + getCity() + " ## " + getNeighbourhood() + " ## " + getReviews() + " ## " + getOverallSatisfaction()
                + " ## " + getAccommodations() + " ## " + getBedrooms() + " ## " + getPrice() + " ## "
                + getPropertyType() + "]";

    }

    public static Accommodation ler() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o ID do quarto:");
        int roomId = Integer.parseInt(scanner.nextLine());

        System.out.println("Informe o ID do anfitrião:");
        int hostId = Integer.parseInt(scanner.nextLine());

        System.out.println("Informe o Tipo de quarto:");
        String roomType = scanner.nextLine();

        System.out.println("Informe o País:");
        String country = scanner.nextLine();

        System.out.println("Informe a Cidade:");
        String city = scanner.nextLine();

        System.out.println("Informe o Bairro:");
        String neighbourhood = scanner.nextLine();

        System.out.println("Informe as Avaliações:");
        int reviews = Integer.parseInt(scanner.nextLine());

        System.out.println("Informe a Satisfação geral:");
        double overallSatisfaction = Double.parseDouble(scanner.nextLine());

        System.out.println("Informe as Acomodações:");
        int accommodations = Integer.parseInt(scanner.nextLine());

        System.out.println("Informe o Número de quartos:");
        double bedrooms = Double.parseDouble(scanner.nextLine());

        System.out.println("Informe o Preço:");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.println("Informe o Tipo de Propiedade:");
        String propertyType = scanner.nextLine();

        scanner.close();

        return new Accommodation(roomId, hostId, roomType, country, city, neighbourhood, reviews, overallSatisfaction,
                accommodations, bedrooms, price, propertyType);

    }

    public Accommodation clone() {

        try {

            return (Accommodation) super.clone();

        } catch (CloneNotSupportedException e) {

            throw new RuntimeException("Clonagem não suportada", e);

        }

    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public void setOverallSatisfaction(double overallSatisfaction) {
        this.overallSatisfaction = overallSatisfaction;
    }

    public void setAccommodations(int accommodations) {
        this.accommodations = accommodations;
    }

    public void setBedrooms(double bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getHostId() {
        return hostId;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public int getReviews() {
        return reviews;
    }

    public double getOverallSatisfaction() {
        return overallSatisfaction;
    }

    public int getAccommodations() {
        return accommodations;
    }

    public double getBedrooms() {
        return bedrooms;
    }

    public double getPrice() {
        return price;
    }

    public String getPropertyType() {
        return propertyType;
    }

    @Override
    public String toString() {
        return print();
    }

    @Override
    public boolean equals(Object obj) {

        Accommodation otherAccommodation = (Accommodation) obj;
        return this.getHostId() == otherAccommodation.getHostId();
        
    }

}