package ma.mypfe.students.controllers;


import ma.mypfe.students.dtos.StudentDto;
import ma.mypfe.students.dtos.StudentIdDto;
import ma.mypfe.students.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    // debug ==> info ==> warn ==> error
    private final static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;

    public StudentController(@Qualifier(value = "serv1") StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public StudentDto save(@RequestBody StudentDto dto) {
        LOGGER.debug("start save methode dto :{}",dto);
        return studentService.save(dto);
    }

    @PutMapping("/update")
    public Long update(@RequestBody StudentDto dto) {
        LOGGER.debug("start update methode dto :{}",dto);
        return studentService.update(dto);
    }

    @DeleteMapping("/delete/{id}/{code}")
    public Boolean delete(@PathVariable("id") long id,@PathVariable("code") String code) {
        LOGGER.debug("start delete methode dto");
        StudentIdDto idcomp = new StudentIdDto(id,code);
        return studentService.deleteById(idcomp);
    }

    @GetMapping("/all")
    public List<StudentDto> selectAll() {
        LOGGER.debug("start selectAll methode");
        return studentService.selectAll();
    }

    @GetMapping("/{id}/{code}")
    public StudentDto selectById(@PathVariable("id") long id,@PathVariable("code") String code) {
        LOGGER.debug("start select method by id {} , code {} ",id,code);
        StudentIdDto idcompose =new StudentIdDto(id,code);
        return studentService.selectById(idcompose);
    }
}
