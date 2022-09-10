package dao.custom.impl;

import dao.custom.StudentDAO;

import entity.Registration;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;    }

    @Override
    public boolean delete(String code) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, code);
        session.delete(student);

        transaction.commit();

        return true;    }

    @Override
    public boolean update(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        return true;
    }

    @Override
    public List<Student> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Student");
        List<Student> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String getNewID() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Student s ORDER BY s.id desc";
        Query query = session.createQuery(hql);
        List resultList = query.getResultList();

        transaction.commit();
        session.close();

        if(resultList.size() > 0){
            int tempID = Integer.parseInt(((Student)resultList.get(0)).getStudentID().split("S")[1]);
            tempID = tempID + 1;
            if(tempID <= 9){
                return "S000" + tempID;
            }else if(tempID <= 99){
                return "S00" + tempID;
            }else if(tempID <= 999){
                return "S0" + tempID;
            }else {
                return "S" + tempID;
            }
        }
        else{
            return "S0001";
        }
    }
}
