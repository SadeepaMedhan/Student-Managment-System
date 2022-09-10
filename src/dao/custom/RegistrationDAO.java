package dao.custom;

import dao.SuperDAO;
import entity.Registration;

import java.util.List;

public interface RegistrationDAO extends SuperDAO {
    public boolean add(Registration dto);
    public boolean delete(String code);
    public boolean update(Registration dto);
    public Registration search(String code);
    public List<Registration> getAll();

    String getNewID();
}
