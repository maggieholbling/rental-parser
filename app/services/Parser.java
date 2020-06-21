package services;

import injection.RentalUrls;


public abstract class Parser {

    protected final RentalUrls urls;

    protected Parser(RentalUrls urls) {
        this.urls = urls;
    }
}
