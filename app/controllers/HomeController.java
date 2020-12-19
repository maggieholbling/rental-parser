package controllers;

import com.fasterxml.jackson.databind.JsonNode; // In intellij you can press command + option + o to optimize imports, which will remove unused imports
import com.google.gson.Gson;
import injection.RentalUrls;
import play.mvc.*;
import services.CraigslistParser;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */

/*
 Learn about injecting https://www.playframework.com/documentation/2.8.x/JavaDependencyInjection
 Always inject heavy packages (like GSON) instead of initializing them on every webcall. Injection will use a shared version of the package
 */
public class HomeController extends Controller {
    public RentalUrls urls = new RentalUrls(); // Theres no reason for these two to be public
    public CraigslistParser craigslistParser = new CraigslistParser(urls); //ditto
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() throws IOException { // instead of throwing the io exception (which play will deal with by throwing a 500), put the code in a try/catch block and return an error status with a readable error message
        ArrayList result = craigslistParser.getCraigslistData(); // Don't use ArrayList by itself; add what type its supposed to hold in <>. This would be ArrayList<Hashtable<String, String>>
        //convert arraylist to json
        String jsonResult = new Gson().toJson(result); // Never initialize Gson (or most libraries) directly like this. It takes up a lot of resources to do this. Instead, inject it into the class
        return ok(jsonResult);
    }

    /**
     * An action that filters
     */
    public Result filtered() {
        return ok(); // You can return status(Http.Status.NOT_IMPLEMENTED); for not implemented routes.
    }

}
