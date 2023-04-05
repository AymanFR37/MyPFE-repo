package ma.mypfe.students.dtos;

import java.io.Serializable;
import java.util.Objects;

public class StudentIdDto implements Serializable{
    private long id;
    private String code;

    public StudentIdDto(long id, String code) {
        this.id = id;
        this.code = code;
    }

    public StudentIdDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentIdDto studentId = (StudentIdDto) o;
        return id == studentId.id && Objects.equals(code, studentId.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "StudentIdDto{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
