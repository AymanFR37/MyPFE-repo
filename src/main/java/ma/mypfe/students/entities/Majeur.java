package ma.mypfe.students.entities;

import javax.persistence.Entity;

@Entity
public class Majeur extends StudentEntity{
    private String cin;

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

}
