package dao.custom;

import dao.SuperDAO;
import entity.Program;
import java.util.List;

public interface ProgramDAO extends SuperDAO {
    public boolean add(Program dto);
    public boolean delete(String code);
    public boolean update(Program dto);
    public Program search(String code);
    public List<Program> getAll();
}
