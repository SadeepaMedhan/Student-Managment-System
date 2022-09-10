package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dto.RegistrationDTO;
import dto.StudentDTO;
import entity.Registration;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean addStudent(StudentDTO dto) {
        return studentDAO.add(new Student(
                dto.getStudentID(),
                dto.getStudentName(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getNic(),
                dto.getBirthDay(),
                dto.getGender(),
                dto.getMobile()
        ));
    }

    @Override
    public boolean updateStudent(Student dto) {
        return studentDAO.update(new Student(
                dto.getStudentID(),
                dto.getStudentName(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getNic(),
                dto.getBirthDay(),
                dto.getGender(),
                dto.getMobile()
        ));
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() {
        List<Student> students = studentDAO.getAll();
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();

        for(Student student:students){
            studentDTOS.add(new StudentDTO(
                    student.getStudentID(),
                    student.getStudentName(),
                    student.getAddress(),
                    student.getEmail(),
                    student.getNic(),
                    student.getBirthDay(),
                    student.getGender(),
                    student.getMobile()
            ));
        }
        return studentDTOS;
    }

    @Override
    public boolean deleteStudent(String code) {
        return studentDAO.delete(code);
    }

    @Override
    public Student getStudent(String code){
        List<Student> students = studentDAO.getAll();
         for (Student s:students){
             if (s.getStudentID().equals(code)){
                 return s;
             }
         }
         return null;
     }

    @Override
    public String getNewID(){
        return studentDAO.getNewID();
    }
}
