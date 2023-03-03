package ma.mypfe.students.repositories;

import ma.mypfe.students.entities.StudentEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository(value = "repo1")
public class StudentRepositoryImpl implements StudentRepository{

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentRepositoryImpl.class);

    @Override
    public Long save(StudentEntity e) {
        LOGGER.debug("start methode save");
        return null;
    }

    @Override
    public Boolean update(StudentEntity e) {
        LOGGER.debug("start methode update");
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        LOGGER.debug("start delete save");
        return null;
    }

    @Override
    public List<StudentEntity> selectAll() {
        LOGGER.debug("start methode selectAll");
        return new ArrayList<>();
    }
}
