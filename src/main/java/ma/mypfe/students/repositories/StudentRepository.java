package ma.mypfe.students.repositories;

import ma.mypfe.students.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("repo1")
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

}
