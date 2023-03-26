package ma.mypfe.students.controllers;


import ma.mypfe.students.dtos.StudentDto;
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

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        LOGGER.debug("start delete methode dto");
        return studentService.deleteById(id);
    }

    @GetMapping("/all")
    public List<StudentDto> selectAll() {
        LOGGER.debug("start selectAll methode");
        return studentService.selectAll();
    }


}
