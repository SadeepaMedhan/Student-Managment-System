package dao.custom.impl;

import dao.custom.RegistrationDAO;
import entity.Program;
import entity.Registration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {
    @Override
    public boolean add(Registration dto) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(dto);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String code) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Registration registration = session.get(Registration.class, code);
        session.delete(registration);

        transaction.commit();
        return true;
    }

    @Override
    public boolean update(Registration dto) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(dto);

        transaction.commit();
        return true;    }

    @Override
    public Registration search(String code) {
        return null;
    }

    @Override
    public List<Registration> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Registration");
        List<Registration> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String getNewID() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Registration r ORDER BY r.rId desc";
        Query query = session.createQuery(hql);
        List resultList = query.getResultList();

        transaction.commit();
        session.close();

        if(resultList.size() > 0){
            int tempID = Integer.parseInt(((Registration)resultList.get(0)).getrId().split("R")[1]);
            tempID = tempID + 1;
            if(tempID <= 9){
                return "R000" + tempID;
            }else if(tempID <= 99){
                return "R00" + tempID;
            }else if(tempID <= 999){
                return "R0" + tempID;
            }else {
                return "R" + tempID;
            }
        }
        else{
            return "R0001";
        }
    }
}
