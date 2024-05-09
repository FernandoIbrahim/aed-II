
public class WebsitesPortifolio{

    private List<Website> listWebsites;

    WebsitesPortifolio(int size ){
        
        listWebsites = new List<>(size);

    }

    public void addWebsite(Website website){
        listWebsites.insert(website);
    }


    public Website sentSoughtWebToBegin(Website website){

        website = removeWebsite(website);
        listWebsites.insert(website, 0);

        return website;
    }

    public Website removeWebsite(Website removingWebsite){

        int position = listWebsites.getPosition(removingWebsite);
        return listWebsites.remove(position);

    }

    public Website searchWebsite(Website website){
        Website findedWebsite = sentSoughtWebToBegin(website);
        findedWebsite.incrementAccess();
        return findedWebsite;
    }

    public String printPortifolio(){
        String portifolioData = "";

        for(int i = 0; i < listWebsites.getSize() ; i++){
            portifolioData += listWebsites.getElement(i).getWebsiteDataString()+"\n";       
        }

        return portifolioData;
    }


}