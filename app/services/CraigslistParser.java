package services;

import injection.RentalUrls;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class CraigslistParser extends Parser {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    // url for this request
    public String url;

    public CraigslistParser(RentalUrls urls) {
        super(urls);
    }

    public ArrayList<Hashtable<String, String>> getCraigslistData() throws IOException {
        url = urls.getUrl("craigslist", "vancouver") + "search/apa?sort=date&hasPic=1&postedToday=1&bundleDuplicates=1&search_distance=18&postal=V6B3H6&min_price=1000&max_price=1500&availabilityMode=0&laundry=1&laundry=2&laundry=3&sale_date=all+dates";
        Document listingDoc = Jsoup.connect(url).get();
        Elements listingLinks = listingDoc.select("a.result-image");

        ArrayList<Hashtable<String, String>> listings = new ArrayList<Hashtable<String, String>>();

        for (Element e :listingLinks) {
            Hashtable<String, String> listing = new Hashtable<String, String>();

            String link = e.attr("href");
            Document doc = Jsoup.connect(link).get();
            //ensure spacing stays the same
            doc.outputSettings().indentAmount(0).prettyPrint(false);

            Elements descriptionElement = doc.select("section#postingbody");
            Element descriptionBreaks = descriptionElement.select("br").first();

            //check if description is just one paragraph
            if (descriptionBreaks != null) {
                //remove extra div
                descriptionElement.select("div.print-information").remove();
                doc.outputSettings().indentAmount(0).prettyPrint(false);
                listing.put("description", descriptionElement.html());
            }
//            listing.put("images": )
//            listing.put("price": )

            listings.add(listing);
        }


        return listings;
    }
}
