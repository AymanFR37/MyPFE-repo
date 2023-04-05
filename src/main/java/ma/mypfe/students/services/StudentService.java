package ma.mypfe.students.services;

import ma.mypfe.students.dtos.StudentDto;
import ma.mypfe.students.dtos.StudentIdDto;

import java.util.List;

public interface StudentService {
    StudentDto save(StudentDto dto);
    Long update(StudentDto dto);
    Boolean deleteById(StudentIdDto idDto);
    List<StudentDto> selectAll();

    StudentDto selectById(StudentIdDto idcompose);
}
