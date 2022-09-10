package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;
import entity.Program;

import java.util.ArrayList;

public interface ProgramBO extends SuperBO {
    ArrayList<ProgramDTO> getAllPrograms();

    boolean deleteProgram(String code);

    boolean addProgram(ProgramDTO dto);

    boolean updateProgram(ProgramDTO dto);

    public Program getProgram(String code);

}
