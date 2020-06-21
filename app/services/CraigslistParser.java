package services;

import injection.RentalUrls;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class CraigslistParser extends Parser {
    // url for this request
    public String url;


    public CraigslistParser(RentalUrls urls) {
        super(urls);
    }

    public String getCraigslistData() throws IOException {
        url = urls.getUrl("craigslist", "vancouver") + "search/apa?sort=date&hasPic=1&postedToday=1&bundleDuplicates=1&search_distance=18&postal=V6B3H6&min_price=1000&max_price=1500&availabilityMode=0&laundry=1&laundry=2&laundry=3&sale_date=all+dates";
        Document doc = Jsoup.connect(url).get();
        String title = doc.title();

        return title;
    }
}
