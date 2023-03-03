package ma.mypfe.students.mappers;

import ma.mypfe.students.dtos.StudentDto;
import ma.mypfe.students.entities.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {
    public StudentEntity convertDtoToEntity(StudentDto dto){
        StudentEntity entity = new StudentEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
    public List<StudentEntity> convertDtoToEntity(List<StudentDto> dto){
        StudentEntity entity = new StudentEntity();
         return dto.stream().map(dtos -> convertDtoToEntity(dtos)).collect(Collectors.toList());
    }

    public StudentDto convertEntityToDto(StudentEntity entity){
        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public List<StudentDto> convertEntityToDto(List<StudentEntity> entity){
        StudentDto dto = new StudentDto();
        return entity.stream().map(entities -> convertEntityToDto(entities)).collect(Collectors.toList());
    }


}
