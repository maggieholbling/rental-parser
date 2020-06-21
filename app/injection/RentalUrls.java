package injection;

import java.util.Hashtable;

public final class RentalUrls {

    public final String startOfUrl = "https://";
    public Hashtable<String, String> urlsMap = new Hashtable<String, String>();

    /**
     * Constructor class, building out the hashtable with used urls
     */
    public RentalUrls() {
        urlsMap.put("craigslist", ".craigslist.org/");
    }

    /**
     * Get base url of rental website
     * @param rentalCompany - the name of the rental website company (lowercase)
     * @return base url string
     */
    public String getUrl(String rentalCompany) {
        if (urlsMap.get(rentalCompany) == null) return null;
        return startOfUrl + "www" + urlsMap.get(rentalCompany);
    }

    /**
     * Get base url of rental website with a specified city
     * @param rentalCompany - the name of the rental website company
     * @param city  - the name of the specified city (lowercase)
     * @return base url string with a city
     */
    public String getUrl(String rentalCompany, String city) {
        if (urlsMap.get(rentalCompany) == null) return null;
        return startOfUrl + city + urlsMap.get(rentalCompany);
    }
}
