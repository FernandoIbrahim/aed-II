import java.util.Scanner;

public class App {
    public static void main(String args[]){
        
        Scanner scanner = new Scanner(System.in);
        
        int totalWebSites = Integer.parseInt(scanner.nextLine());

        WebsitesPortifolio websitesPortifolio = new WebsitesPortifolio(totalWebSites);

        Website basicWebsite;

        while (totalWebSites > 0) {
            String websiteData = scanner.nextLine();

            String[] websiteDataArray = websiteData.split(" - ");
            
            basicWebsite = new Website(websiteDataArray[0] ,websiteDataArray[1]);

            websitesPortifolio.addWebsite(basicWebsite);

            totalWebSites--;
        }

        String searchWebsiteName;

        while(!( searchWebsiteName = scanner.nextLine()).equals("FIM")){

            try{

                basicWebsite = websitesPortifolio.searchWebsite(new Website(searchWebsiteName));
                System.out.println(basicWebsite.getAddress());

            }catch(Exception e){

                System.out.println(e.getMessage());

            }

        }

        System.out.println(websitesPortifolio.printPortifolio());

        scanner.close();
    }
}

