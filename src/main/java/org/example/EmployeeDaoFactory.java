package org.example;

import org.hibernate.SessionFactory;


public class EmployeeDaoFactory {
    private static EmployeeDao employeeDao;
    private EmployeeDaoFactory() {
    }

    public static EmployeeDao getEmployeeDao(SessionFactory sessionFactory) {
        if (employeeDao == null) {
            employeeDao = new EmployeeDaoImpl(sessionFactory);
        }
        return employeeDao;
    }
}
