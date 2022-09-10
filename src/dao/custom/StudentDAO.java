package dao.custom;
import dao.SuperDAO;
import entity.Student;

import java.util.List;

public interface StudentDAO extends SuperDAO {
    public boolean add(Student entity);
    public boolean delete(String code);
    public boolean update(Student entity);
    public List<Student> getAll();
    public String getNewID();
}
