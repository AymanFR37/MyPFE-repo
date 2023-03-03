package ma.mypfe.students.services;

import ma.mypfe.students.dtos.StudentDto;
import ma.mypfe.students.entities.StudentEntity;

import java.util.List;

public interface StudentService {
    Long save(StudentDto dto);
    Boolean update(StudentDto dto);
    Boolean deleteById(Long id);
    List<StudentDto> selectAll();
}
