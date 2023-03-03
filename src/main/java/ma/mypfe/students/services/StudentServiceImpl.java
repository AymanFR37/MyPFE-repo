package ma.mypfe.students.services;

import ma.mypfe.students.dtos.StudentDto;
import ma.mypfe.students.entities.StudentEntity;
import ma.mypfe.students.mappers.StudentMapper;
import ma.mypfe.students.repositories.StudentRepository;
import ma.mypfe.students.repositories.StudentRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private final static Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    @Qualifier("repo1")//hadi bach ila kan endna bzef dyl les classe d'implementation kankhtaro whda
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Long save(StudentDto dto){
        LOGGER.debug("start save methode");
        StudentEntity e = studentMapper.convertDtoToEntity(dto);
        return studentRepository.save(e);
    }

    @Override
    public Boolean update(StudentDto dto){
        LOGGER.debug("start update methode");
        StudentEntity e = studentMapper.convertDtoToEntity(dto);
        return studentRepository.update(e);
    }

    @Override
    public Boolean deleteById(Long id){
        LOGGER.debug("start delete methode");
        return studentRepository.deleteById(id);
    }

    @Override
    public List<StudentDto> selectAll(){
        LOGGER.debug("start selectAll methode");
        List<StudentEntity> l = studentRepository.selectAll();
        List<StudentDto> ld = studentMapper.convertEntityToDto(l);
        return ld;
    }
}
