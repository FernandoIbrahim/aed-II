public class Website {

    private String name;
    private String address;
    private int acces;

    Website(String name, String address){
        this.name = name;
        this.address = address;
        this.acces = 0;
    }

    Website(String name){
        this.name = name;
        this.acces = 0;
        this.address = null;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void incrementAccess() {
        this.acces++;
    }


    public int getAcces() {
        return acces;
    }

    @Override
    public boolean equals(Object object) {

        Website compareWebsite = (Website) object;

        return this.name.equals(compareWebsite.getName());

    }

    public String getWebsiteDataString(){
        return "Nome: [" + this.getName() + "]\nEndereco: [" + this.getAddress() + "]\nNumero de acessos: " + this.getAcces();
    }
        

}
