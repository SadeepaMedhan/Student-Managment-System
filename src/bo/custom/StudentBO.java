package bo.custom;

import bo.SuperBO;
import dto.RegistrationDTO;
import dto.StudentDTO;
import entity.Registration;
import entity.Student;

import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    ArrayList<StudentDTO> getAllStudents();

    boolean deleteStudent(String code);

    boolean addStudent(StudentDTO dto);

    boolean updateStudent(Student dto);

    public Student getStudent(String code);

    public String getNewID();
}
