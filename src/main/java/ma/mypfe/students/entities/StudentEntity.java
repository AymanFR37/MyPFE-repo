package ma.mypfe.students.entities;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JoinTable(name = "list_student_cours")
    private List<CourseEntity> courses;

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

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
                ", adresse=" + adresse +
                ", courses=" + courses +
                '}';
    }
}
