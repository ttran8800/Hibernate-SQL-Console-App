package org.example;

import com.google.protobuf.EmptyOrBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{

    private SessionFactory sessionFactory;

    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addEmployee(Employee employee) {
        try (Session session = sessionFactory.openSession()){

            //begin a transaction
            Transaction transaction = session.beginTransaction();

            //save employee to database
            session.save(employee);

            //commit transaction
            transaction.commit();

            System.out.println("Employee added Successfully.");
            System.out.println(employee);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (Session session = sessionFactory.openSession()){

            //begin a transaction
            Transaction transaction = session.beginTransaction();

            //update employee to database
            session.update(employee);

            //commit transaction
            transaction.commit();

            System.out.println("Employee updated Successfully.");
            System.out.println(employee);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        try (Session session = sessionFactory.openSession()){

            //begin a transaction
            Transaction transaction = session.beginTransaction();

            //delete employee to database
            session.delete(employee);

            //commit transaction
            transaction.commit();

            System.out.println("Employee delete Successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getEmployees() {
        try (Session session = sessionFactory.openSession()){

            //begin a transaction
            Transaction transaction = session.beginTransaction();

            //get all records in table and return as a List
            return session.createQuery("FROM Employee", Employee.class).list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getEmployeeById(int id) {
        try (Session session = sessionFactory.openSession()){

            //begin a transaction
            Transaction transaction = session.beginTransaction();

            //retrieve employee record by their id and return it
            return session.get(Employee.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
