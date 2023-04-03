package ma.mypfe.students.entities;

import javax.persistence.Entity;

@Entity
public class Mineur extends StudentEntity{
    private boolean isAuthorized;

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }
}
