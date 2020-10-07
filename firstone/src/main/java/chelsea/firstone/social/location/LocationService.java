package chelsea.firstone.social.location;


import chelsea.firstone.social.Exceptions.BusinessException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component @Service
public class LocationService implements ILocationService {

    private final List<Location> locations = new ArrayList<>();


    @Override
    @Bean
    public List<Location> getAllLocations() throws BusinessException {
        try {

            return locations;
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Location getLocationById(String id) throws BusinessException {
        try {
            Location location = locations.stream()
                    .filter(p -> id.equals(p.getId()))
                    .findFirst()
                    .orElse(null);
            if (location == null) {
                throw new BusinessException("Location not found");
            }
            return location;
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean locationExists(Location location) throws BusinessException {
        try {
            
            Location locVerifiedById = locations.stream()
                    .filter(p -> location.getId().equals(p.getId()))
                    .findFirst()
                    .orElse(null);

            Location locVerifiedByName = locations.stream()
                    .filter(t -> location.getName().equals(t.getName()))
                    .findFirst()
                    .orElse(null);
            if(locVerifiedById != null && locVerifiedByName != null) {
                return true;
            }else if(locVerifiedById != null ){
                return true;
            }else return locVerifiedByName != null;

        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void addNewLocation(Location location) throws BusinessException {
        try {
            boolean exists = locationExists(location);
            System.out.println(exists);
            if (!exists) {
                locations.add(location);
            } else {
                throw new BusinessException("This Location already exists");
            }
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllLocations() throws BusinessException {
        try {
            locations.clear();
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(String id) throws BusinessException {
        try {
            Location locToBeDeleted = locations.stream()
                    .filter(p -> id.equals(p.getId()))
                    .findFirst()
                    .orElse(null);
            locations.remove(locToBeDeleted);
            if (locToBeDeleted == null) {
                throw new BusinessException("Location not found");
            } else {
                locations.remove(locToBeDeleted);
            }
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void updateLocation(String id, Location loc) throws BusinessException {
        try {
            Location locToBeUpdated = locations.stream()
                    .filter(p -> id.equals(p.getId()))
                    .findFirst()
                    .orElse(null);
            if (locToBeUpdated != null) {
                locations.set(locations.indexOf(locToBeUpdated), loc);
            } else {
                throw new BusinessException("Location not found");
            }
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}