package bg.softUni.cache.repository;


import bg.softUni.cache.model.StudentDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository  {

    private List<StudentDto> allStudents = List.of(
            new StudentDto("Pesho",21,85),
            new StudentDto("Anna",29,105),
            new StudentDto("Ivan",91,36)
            );

    public List<StudentDto> getAllStudents(){
        this.dummyWait();;
        return this.allStudents;
    }

    public StudentDto getStudentByName(String name){
        this.dummyWait();

        return this.allStudents.
                stream().
                filter(s->s.getName().equals(name)).findAny().orElse(null);
    }

    public void dummyWait(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
