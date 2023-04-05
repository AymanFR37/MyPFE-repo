package ma.mypfe.students.mappers;

import ma.mypfe.students.dtos.StudentDto;
import ma.mypfe.students.dtos.StudentIdDto;
import ma.mypfe.students.entities.StudentEntity;
import ma.mypfe.students.entities.StudentId;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper
public interface StudentMapper {
    StudentEntity convertDtoToEntity(StudentDto dto);

    List<StudentDto> convertEntitiesToDtos(List<StudentEntity> entity);

    StudentDto convertEntityToDto(StudentEntity entity);

    StudentId studentIdDtoToStudentId(StudentIdDto studentIdDto);
}
