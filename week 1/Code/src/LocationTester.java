public class LocationTester {
    public static void main(String[] args) {
        SimpleLocation ucsd = new SimpleLocation(32.9, -117.2);
        SimpleLocation lima = new SimpleLocation(-12.0, -77.0);

        //allowed to change because member variable is public
        lima.latitude = -12.04;
        //ERROR
        //lima.longitude = 0.0;

        //allowed to call method because it is public
        System.out.println(ucsd.distance(lima));
    }
}
