package bg.softUni.cache.web;

import bg.softUni.cache.model.StudentDto;
import bg.softUni.cache.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/students")
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(this.studentService.getAllStudents());
    }

    @GetMapping("/search")
    public ResponseEntity<StudentDto> findByName(
            @RequestParam String name
    ){
        var studentDto = this.studentService.getStudentByName(name);
        if(studentDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping("/evict")
    public ResponseEntity<StudentDto> evict(){
        studentService.refresh();
        return ResponseEntity.noContent().build();
    }

}
