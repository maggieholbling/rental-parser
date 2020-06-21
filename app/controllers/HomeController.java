package controllers;

import injection.RentalUrls;
import play.mvc.*;
import services.CraigslistParser;

import java.io.IOException;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    public RentalUrls urls = new RentalUrls();
    public CraigslistParser craigslistParser = new CraigslistParser(urls);
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() throws IOException {
        String result = craigslistParser.getCraigslistData();
        return ok(result);
    }

    /**
     * An action that filters
     */
    public Result filtered() {
        return ok();
    }

}
