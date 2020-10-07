package chelsea.firstone.social.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {

   private final ILocationService locationService;

    @Autowired
    LocationController(ILocationService locationService) {
      this.locationService = locationService;
    }

    @RequestMapping(value = "/locations")
    public List<Location> getAllLocation(){
        return locationService.getAllLocations();
    }

    @RequestMapping(value = "/locations/{id}")
    public Location getLocationById(@PathVariable String id){
        return locationService.getLocationById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/locations")
    public void addNewLocation(@RequestBody Location location){
        locationService.addNewLocation(location);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/locations/delete")
    public void deleteAllLocations(){
        locationService.deleteAllLocations();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/locations/{id}")
    public void deleteById(@PathVariable String id){
        locationService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/locations/{id}")
    public void updateLocation(@PathVariable String id, @RequestBody Location loc){
     locationService.updateLocation(id, loc);
    }
}