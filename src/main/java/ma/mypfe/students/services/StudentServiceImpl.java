package ma.mypfe.students.services;

import ma.mypfe.students.dtos.StudentDto;
import ma.mypfe.students.dtos.StudentIdDto;
import ma.mypfe.students.entities.StudentEntity;
import ma.mypfe.students.mappers.StudentMapper;
import ma.mypfe.students.repositories.StudentRepository;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "serv1")
public class StudentServiceImpl implements StudentService{
    private final static Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);

    @Override
    public StudentDto save(StudentDto dto){

        LOGGER.debug("start save methode dto :{}",dto);
        LOGGER.debug(" Mapping DTO TO ENTITY : {} ", studentMapper.convertDtoToEntity(dto));
        StudentDto toDto = studentMapper.convertEntityToDto(studentRepository.save(studentMapper.convertDtoToEntity(dto)));
        return toDto;
    }

    @Override
    public Long update(StudentDto dto){
        LOGGER.debug("start update methode dto :{}",dto);
        StudentDto studentDto = studentMapper.convertEntityToDto(studentRepository.save(studentMapper.convertDtoToEntity(dto)));
        return studentDto.getStudentId().getId();
    }

    @Override
    public Boolean deleteById(StudentIdDto idDto){
        LOGGER.debug("start delete methode");
         studentRepository.deleteById(studentMapper.studentIdDtoToStudentId(idDto));
         return true;
    }

    @Override
    public List<StudentDto> selectAll(){
        LOGGER.debug("start selectAll methode");
        return studentMapper.convertEntitiesToDtos(studentRepository.findAll());
    }

    @Override
    public StudentDto selectById(StudentIdDto idDto) {
        return  studentMapper.convertEntityToDto(studentRepository.findById(studentMapper.studentIdDtoToStudentId(idDto)).orElse(null));
    }
}
