package bo.custom.impl;

import bo.BoFactory;
import bo.custom.RegistrationBO;
import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.SuperDAO;
import dao.custom.ProgramDAO;
import dao.custom.RegistrationDAO;
import dao.custom.StudentDAO;
import dto.RegistrationDTO;
import entity.Registration;

import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {
    RegistrationDAO registrationDAO = (RegistrationDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.REGISTRATION);

    @Override
    public ArrayList<RegistrationDTO> getAllRegistrations() {
        List<Registration> registrationList = registrationDAO.getAll();
        ArrayList<RegistrationDTO> registrationDTOS = new ArrayList<>();

        for (Registration r:registrationList){
            registrationDTOS.add(new RegistrationDTO(
                    r.getrId(),
                    r.getStID(),
                    r.getProgramID(),
                    r.getDate()
            ));
        }
        return registrationDTOS;
    }

    @Override
    public boolean deleteRegistration(String code) {
        return registrationDAO.delete(code);
    }

    @Override
    public boolean addRegistration(RegistrationDTO dto) {

        return registrationDAO.add(new Registration(
                dto.getrId(),
                dto.getStID(),
                dto.getProgramID(),
                dto.getDate()
        ));
    }

    @Override
    public boolean updateRegistration(RegistrationDTO dto) {
        return registrationDAO.update(new Registration(
                dto.getrId(),
                dto.getStID(),
                dto.getProgramID(),
                dto.getDate()
        ));
    }

    @Override
    public String getNewID() {
        return registrationDAO.getNewID();
    }
}
