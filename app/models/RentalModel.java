package models;

import java.util.ArrayList;
import java.util.List;

public class RentalModel {
    private String description = null;
    private List images = new ArrayList<String>();
    private int price = 0;
    private int date = 0;

    public RentalModel(String description, List images, int price, int date) {
        this.description = description;
        this.images = images;
        this.price = price;
        this.date = date;
    }
}
