package bg.softUni.cache.service;

import bg.softUni.cache.model.StudentDto;
import bg.softUni.cache.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Cacheable("students")
    public List<StudentDto> getAllStudents(){
        LOGGER.info("Getting all students.");
        return this.studentRepository.getAllStudents();
    }

    @Cacheable("student")
    public StudentDto getStudentByName(String name){
        LOGGER.info("Getting student by name {}.",name);
        return this.studentRepository.getStudentByName(name);

    }

    @CacheEvict(cacheNames = "students",allEntries = true)
    public void refresh(){


    }


}
