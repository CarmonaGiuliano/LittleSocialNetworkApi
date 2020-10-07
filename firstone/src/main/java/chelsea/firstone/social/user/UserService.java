package chelsea.firstone.social.user;
import chelsea.firstone.social.Exceptions.BusinessException;
import chelsea.firstone.social.location.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final ILocationService locationService;

    private final List<User> Users = new ArrayList<>();

    @Autowired
    UserService(ILocationService locationService) {
        this.locationService = locationService;
    }


    @Override
    public List<User> getAllUsers() throws BusinessException{
        try {

            return Users;

        }catch (BusinessException e){

            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;

        }
    }


    @Override
    public User getUserById(String id) throws BusinessException {

        try {
            User user = Users.stream()
                    .filter(p -> id.equals(p.getId()))
                    .findFirst()
                    .orElse(null);
            if (user != null) {
                return user;
            } else {
                throw new BusinessException("User not found");
            }
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean userExists(User user) throws BusinessException {
        try {

            User userCheckedByEmail = Users.stream()
                    .filter(p -> user.getEmail().equals(p.getEmail()))
                    .findFirst()
                    .orElse(null);

            User userCheckedById = Users.stream()
                    .filter(t -> user.getId().equals(t.getId()))
                    .findFirst()
                    .orElse(null);

            if (userCheckedById != null && userCheckedByEmail != null) {
                return true;
            }else if(userCheckedById != null){
                return true;
            }else return userCheckedByEmail != null;

        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void addNewUser(User user) throws BusinessException {
        try {
            boolean exists = userExists(user);
            if (!exists) {
                Users.add(user);
                locationService.addNewLocation(user.getLocation());
            } else {
                throw new BusinessException("This User already Exists");
            }
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllUsers() throws BusinessException {
        try {
            Users.clear();
            locationService.deleteAllLocations();

        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public void deleteById(String id) throws BusinessException {
        try {
            User ToBeDeleted = Users.stream()
                    .filter(p -> id.equals(p.getId()))
                    .findFirst()
                    .orElse(null);
            if (ToBeDeleted == null) {
                throw new BusinessException("User not Found");
            }else{
                Users.remove(ToBeDeleted);
            }
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }


    @Override
    public void updateUser(String id, User user) throws BusinessException {
        try {
            User userToBeUpdated = Users.stream()
                    .filter(p -> id.equals(p.getId()))
                    .findFirst()
                    .orElse(null);
            if (userToBeUpdated != null) {
                Users.set(Users.indexOf(userToBeUpdated), user);
                locationService.updateLocation(user.getLocation().getId(), user.getLocation());
            } else {
                throw new BusinessException("User not Found");
            }

        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}


