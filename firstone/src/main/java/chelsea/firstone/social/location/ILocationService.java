package chelsea.firstone.social.location;



import java.util.List;

public interface ILocationService {


    List<Location> getAllLocations();

    Location getLocationById(String id);

    boolean locationExists(Location location);

    void addNewLocation(Location location);

    void deleteAllLocations();

    void deleteById(String id);

    void updateLocation(String id, Location loc);

}
