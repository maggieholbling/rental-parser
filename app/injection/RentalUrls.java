package injection;

import java.util.Hashtable;

public final class RentalUrls {

    public final String startOfUrl = "https://"; // this can be private
    public Hashtable<String, String> urls = new Hashtable<String, String>(); // dont need the second <String, String>

    /**
     * Constructor class, building out the hashtable with used urls
     */
    public RentalUrls() {
        urls.put("craigslist", ".craigslist.org/");
    }

    /**
     * Get base url of rental website
     * @param rentalCompany - the name of the rental website company (lowercase)
     * @return base url string
     */
    public String getUrl(String rentalCompany) {
        if (urls.get(rentalCompany) == null) return null;
        return startOfUrl + "www" + urls.get(rentalCompany); // String.format("%swww%s", startOfUrl, urls.get(rentalCompany));
    }

    /**
     * Get base url of rental website with a specified city
     * @param rentalCompany - the name of the rental website company
     * @param city  - the name of the specified city (lowercase)
     * @return base url string with a city
     */
    public String getUrl(String rentalCompany, String city) {
        if (urls.get(rentalCompany) == null) return null;
        return startOfUrl + city + urls.get(rentalCompany); //String.format()
    }
}
