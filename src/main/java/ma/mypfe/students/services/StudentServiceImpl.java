package ma.mypfe.students.services;

import ma.mypfe.students.dtos.StudentDto;
import ma.mypfe.students.mappers.StudentMapper;
import ma.mypfe.students.repositories.StudentRepository;
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
        LOGGER.debug("start save methode dto :{}",dto);
        StudentDto toDto = studentMapper.convertEntityToDto(studentRepository.save(studentMapper.convertDtoToEntity(dto)));
        return toDto.getId();
    }

    @Override
    public Long update(StudentDto dto){
        LOGGER.debug("start update methode dto :{}",dto);
        StudentDto studentDto = studentMapper.convertEntityToDto(studentRepository.save(studentMapper.convertDtoToEntity(dto)));
        return studentDto.getId();
    }

    @Override
    public Boolean deleteById(Long id){
        LOGGER.debug("start delete methode");
         studentRepository.deleteById(id);
         return true;
    }

    @Override
    public List<StudentDto> selectAll(){
        LOGGER.debug("start selectAll methode");
        return studentMapper.convertEntityToDto(studentRepository.findAll());
    }
}
