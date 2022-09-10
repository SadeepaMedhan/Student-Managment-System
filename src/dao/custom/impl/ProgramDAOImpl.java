package dao.custom.impl;

import dao.custom.ProgramDAO;
import dto.ProgramDTO;
import entity.Program;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramDAOImpl implements ProgramDAO {
    @Override
    public boolean add(Program entity){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String code){
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Program program = session.get(Program.class, code);
        session.delete(program);

        transaction.commit();

        return true;
    }

    @Override
    public boolean update(Program entity){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        return true;
    }

    @Override
    public Program search(String code){
        return null;
    }

    @Override
    public List<Program> getAll(){
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Program");
        List<Program> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

}
