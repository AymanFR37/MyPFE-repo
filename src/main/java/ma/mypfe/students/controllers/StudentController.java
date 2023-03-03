package ma.mypfe.students.controllers;


import ma.mypfe.students.dtos.StudentDto;
import ma.mypfe.students.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;

    @PostMapping
    public Long save(StudentDto dto) {
        LOGGER.debug("start save methode");
        return studentService.save(dto);
    }

    @PutMapping
    public Boolean update(StudentDto dto) {
        LOGGER.debug("start update methode");
        return studentService.update(dto);
    }

    @DeleteMapping
    public Boolean delete(Long id) {
        LOGGER.debug("start delete methode");
        return studentService.deleteById(id);
    }

    @GetMapping
    public List<StudentDto> selectAll() {
        LOGGER.debug("start selectAll methode");
        return studentService.selectAll();
    }


}
