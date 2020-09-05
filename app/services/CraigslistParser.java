package services;

import injection.RentalUrls;
import models.RentalModel;
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

    public ArrayList<RentalModel> getCraigslistData() throws IOException {
        url = urls.getUrl("craigslist", "vancouver") + "search/apa?sort=date&hasPic=1&postedToday=1&bundleDuplicates=1&search_distance=18&postal=V6B3H6&min_price=1000&max_price=1500&availabilityMode=0&laundry=1&laundry=2&laundry=3&sale_date=all+dates";
        // get listings page body (1st page only)
        Document listingDoc = Jsoup.connect(url).get();
        Elements listingLinks = listingDoc.select("a.result-image");

        ArrayList<RentalModel> listings = new ArrayList<RentalModel>();

        for (Element e :listingLinks) {
            String link = e.attr("href");
            // get individual listing body
            Document doc = Jsoup.connect(link).get();
            //ensure spacing stays the same
            doc.outputSettings().indentAmount(0).prettyPrint(false);

            Elements price = doc.select("section#postingbody");
            Elements date = doc.select("section#postingbody");
            Elements images = doc.select("section#postingbody");

            Elements descriptionElement = doc.select("section#postingbody");
            Element descriptionBreaks = descriptionElement.select("br").first();

            //check if description is just one paragraph
            if (descriptionBreaks != null) {
                //remove extra div
                descriptionElement.select("div.print-information").remove();
//                listing.put("description", descriptionElement.html());
                //create new RentalModel instance
                RentalModel listing = new RentalModel(descriptionElement.html(), );
            }


//            listing.put("images": )
//            listing.put("price": )

//            listings.add(listing);
        }


        return listings;
    }
}
