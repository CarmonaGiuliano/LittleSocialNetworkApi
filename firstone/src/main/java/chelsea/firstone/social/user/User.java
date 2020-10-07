package chelsea.firstone.social.user;
import chelsea.firstone.social.location.Location;

public class User {
        private String id;
        private String firstname;
        private String lastname;
        private Location location;
        private String email;

        User(){}

        User(String id, String firstname, String lastname, Location location, String email){
            this.id = id;
            this.firstname = firstname;
            this.lastname = lastname;
            this.location = location;
            this.email = email;

        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

