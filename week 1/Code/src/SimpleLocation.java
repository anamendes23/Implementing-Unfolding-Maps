//Protecting your data and methods
//public means can access from any class
//private means can access only from SimpleLocation
//RULE OF THUMB: make member variables private (and methods either public or private)
//METHODS:
//public: for world use
//private: helper methods
//give the right level of access
//getters and setters
//can the user change the value?
//getters and setters give us more control

public class SimpleLocation {
    //data associated with SimpleLocation
    //member variables: data the objects need to store
    public double latitude;
    private double longitude;

    //constructor: method to create a new object
    //no return type
    //in this case, takes 2 arguments
    //parameter constructor
    public SimpleLocation(double lat, double lon) {
        this.latitude = lat;
        //allowed to access longitude even though it's private because it's within the class
        this.longitude = lon;
    }

    //default constructor (not passing any data)
    //overloading constructor
    public SimpleLocation() {
        this.latitude = 0.0;
        this.longitude = 0.0;
    }
    //getter
    public double getLongitude() {
        return this.longitude;
    }
    //setter
    public void setLongitude(double lon) {
        if(lon < -180 || lon > 180)
            System.out.println("Invalid longitude value.");
        else
            this.longitude = lon;
    }

    //setter
    public void setLatitude(double lat) {
        if(lat < -90 || lat > 80)
            System.out.println("Invalid latitude value.");
        else
            this.latitude = lat;
    }

    //Methods: the things this class can do
    public double distance(SimpleLocation other) {
        return getDist(this.latitude, this.longitude, other.latitude, other.longitude);
    }

    //Why overload? gives options
    //return type is NOT part of the method signature
    //Overloaded methods CAN have different return types
    //Changing the return type is NOT ENOUGH for overloading
    //Parameters MUST be different
    //overloading method
    public double distance(double otherLat, double otherLon) {
        //TODO
        return 0.0;
    }

    private double getDist(double lat1, double lon1, double lat2, double lon2) {
        double diff1 = lat1 - lat2;
        double diff2 = lon1 - lon2;
        return Math.sqrt(Math.pow(diff1, 2) + Math.pow(diff2,2));
    }
}
