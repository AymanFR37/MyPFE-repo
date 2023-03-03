package ma.mypfe.students.repositories;

import ma.mypfe.students.entities.StudentEntity;

import java.util.List;

public interface StudentRepository {

     Long save(StudentEntity e);
     Boolean update(StudentEntity e);
     Boolean deleteById(Long id);
     List<StudentEntity> selectAll();
}
