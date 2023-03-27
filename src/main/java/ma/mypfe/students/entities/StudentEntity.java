package ma.mypfe.students.entities;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class StudentEntity{
    @EmbeddedId
    private StudentId studentId;
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "rue" ,column = @Column(name = "rueStudent")),
            @AttributeOverride(name = "avenue" ,column = @Column(name = "avenueStudent")),
    })
    private Adresse adresse;

    public StudentId getStudentId() {
        return studentId;
    }

    public void setStudentId(StudentId studentId) {
        this.studentId = studentId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                '}';
    }
}
