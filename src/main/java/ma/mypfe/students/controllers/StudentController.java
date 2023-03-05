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

    @PostMapping("/add")
    public Long save(@RequestBody StudentDto dto) {
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

    @GetMapping("getStudents")
    public List<StudentDto> selectAll() {
        LOGGER.debug("start selectAll methode");
        return studentService.selectAll();
    }


}
