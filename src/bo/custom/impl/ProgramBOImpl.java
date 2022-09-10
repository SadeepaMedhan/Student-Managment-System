package bo.custom.impl;

import bo.custom.ProgramBO;
import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dto.ProgramDTO;
import dto.StudentDTO;
import entity.Program;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO{

     ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.PROGRAM);

    @Override
    public boolean addProgram(ProgramDTO dto) {
        return programDAO.add(new Program(
                dto.getProgramID(),
                dto.getProgram(),
                dto.getDuration(),
                dto.getFee()
        ));
    }

    @Override
    public boolean updateProgram(ProgramDTO dto) {
        return programDAO.update(new Program(
                dto.getProgramID(),
                dto.getProgram(),
                dto.getDuration(),
                dto.getFee()
        ));
    }


    @Override
    public ArrayList<ProgramDTO> getAllPrograms() {
        List<Program> programList = programDAO.getAll();
        ArrayList<ProgramDTO> programDTOS = new ArrayList<>();

        for (Program p:programList) {
            programDTOS.add(new ProgramDTO(
                    p.getProgramID(),
                    p.getProgram(),
                    p.getDuration(),
                    p.getFee()
            ));
        }
        return programDTOS;
    }

    @Override
    public boolean deleteProgram(String code) {
        return programDAO.delete(code);
    }

    @Override
    public Program getProgram(String code){
        ArrayList<ProgramDTO> allPrograms = getAllPrograms();
        for (ProgramDTO p:allPrograms){
            if (p.getProgramID().equals(code)){
                return new Program(
                        p.getProgramID(),
                        p.getProgram(),
                        p.getDuration(),
                        p.getFee()
                );
            }
        }
        return null;
    }
}
