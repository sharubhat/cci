package oneinterview;

/**
 * Build a simple Yelp-like system: Given a set of restaurant and metadata (coordinates, ratings, opening hours),
 * design and implement the following functionalities without using a database.

 1. Find restaurants within specified radius, given a coordinate
 2. Improve the above function by only returning restaurants that are open given desired dining hour
 3. Improve the above function by sorting the results by average ratings

 */
import java.util.ArrayList;
import java.util.List;

public class Yelp {
    private List<Restaurant> restaurants;
    private List<Rating> ratings;

    public Yelp(List<Restaurant> restaurants, List<Rating> ratings) {
        this.restaurants = restaurants;
        this.ratings = ratings;
    }

    /*
     * Returns list of Restaurant within radius.
     *
     *  latitude: double
     *  longitude: double
     *  radius: kilometer in int
     *  diningHour: If null, find any restaurant in radius.
     *              Otherwise return list of open restaurants at specified hour.
     *  sortByRating: If true, sort result in descending order,
     *                highest rated first.
     */
    public List<Restaurant> find(double latitude, double longitude, int radius,
                                 Integer diningHour, boolean sortByRating) {
        List<Restaurant> result = new ArrayList<>();

        for(Restaurant r : restaurants) {
            if(withinRadius(latitude, longitude, r.latitude, r.longitude, radius)
                    && openNow(diningHour, r.openHour, r.closeHour)) {
                result.add(r);
            }
        }
        return result;
    }

    private boolean withinRadius(double latOrigin, double longOrigin,
                                 double latRest, double longRest, int radius) {
        long radSquared = radius * radius;
        double latSquared = (latRest - latOrigin) * (latRest - latOrigin);
        double longSquared = (longRest - longOrigin) * (longRest - longOrigin);

        return radSquared > latSquared + longSquared;
    }

    private boolean openNow(Integer diningHour, int openHour, int closeHour) {
        if(diningHour == null || (diningHour >= openHour && diningHour <= closeHour)) {
            return true;
        }
        return false;
    }

    public static class Restaurant {
        private double latitude;
        private double longitude;
        private int id;
        private String name;
        private int openHour;   /* in [0-23] */
        private int closeHour;  /* in [0-23] */

        public Restaurant(double latitude, double longitude, int id, String name, int openHour, int closeHour) {
            if(openHour < 0 || openHour > 23)
                throw new IllegalArgumentException("Invalid openHour");
            if(closeHour < 0 || closeHour > 23)
                throw new IllegalArgumentException("Invalid closeHour");
            this.latitude = latitude;
            this.longitude = longitude;
            this.id = id;
            this.name = name;
            this.openHour = openHour;
            this.closeHour = closeHour;
        }

        @Override
        public String toString() {
            return "Restaurant{" +
                    "latitude=" + latitude +
                    ", longitude=" + longitude +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", openHour=" + openHour +
                    ", closeHour=" + closeHour +
                    '}';
        }
    }

    public static class Rating {
        private int id;
        private int rating;      /* in [1-5] */

        public Rating(int id, int rating) {
            if(rating < 1 || rating > 5)
                throw new IllegalArgumentException("Invalid rating");
            this.id = id;
            this.rating = rating;
        }
    }

    public static void main(String[] args) {
        List<Restaurant> restaurants = new ArrayList<>();  /* Omitted */
        restaurants.add(new Restaurant(37.7577, -122.4376, 0, "Domino's Pizza", 7, 23));
        restaurants.add(new Restaurant(-37.7, -122.6, 1, "McDonald", 7, 23));
        List<Rating> ratings = new ArrayList<>();          /* Omitted */
        ratings.add(new Rating(0, 3));

        Yelp y = new Yelp(restaurants, ratings);
        System.out.println(y.find(-37.7, -122.6, 5, null, false));
        System.out.println(y.find(-37.7, -122.6, 5, 8, false));
        System.out.println(y.find(-37.7, -122.6, 5, 6, false));
    }
}