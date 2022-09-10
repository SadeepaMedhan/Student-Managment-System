package bo.custom;

import bo.SuperBO;
import dto.RegistrationDTO;

import java.util.ArrayList;

public interface RegistrationBO extends SuperBO {
    ArrayList<RegistrationDTO> getAllRegistrations();

    boolean deleteRegistration(String code);

    boolean addRegistration(RegistrationDTO dto);

    boolean updateRegistration(RegistrationDTO dto);

    String getNewID();
}
