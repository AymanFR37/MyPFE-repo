package ma.mypfe.students.services;

import ma.mypfe.students.dtos.StudentDto;
import ma.mypfe.students.mappers.StudentMapper;
import ma.mypfe.students.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "serv1")
public class StudentServiceImpl implements StudentService{
    private final static Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentDto save(StudentDto dto){

        LOGGER.debug("start save methode dto :{}",dto);
        StudentDto toDto = studentMapper.convertEntityToDto(studentRepository.save(studentMapper.convertDtoToEntity(dto)));
        return toDto;
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
        return studentMapper.convertEntitiesToDtos(studentRepository.findAll());
    }
}
