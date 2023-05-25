package com.acme.university;

import com.acme.university.model.Enrollment;
import com.acme.university.model.Student;
import com.acme.university.model.Unit;
import com.acme.university.model.exception.BusinessException;
import com.acme.university.repository.StudentRepository;
import com.acme.university.repository.UnitRepository;
import com.acme.university.repository.datasource.DataSource;
import com.acme.university.service.StudentService;
import com.acme.university.service.UnitService;
import org.h2.tools.Server;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import static java.lang.System.exit;

public class Main {

    private Server server;
    public static void main(String[] args) throws BusinessException {
        Main main = new Main();
        main.startH2Server();
        DataSource.loadDatabaseDriver();
        main.findDatabaseVersion();
        main.initializeDatabase();
        List<Unit> units = main.unitServiceOperations();
        main.studentServiceOperations(units);
        main.stopH2Server();
        // Java Swing
    }

    private void studentServiceOperations(List<Unit> units) throws BusinessException {
        StudentService studentService = new StudentService(new StudentRepository());
        studentService.create(new Student("Ioannis", "Daniil", new Date(), List.of(new Enrollment(units.get(0), 50),new Enrollment(units.get(1), 10),new Enrollment(units.get(2), 20))));
        studentService.create(new Student("Giannis", "Daniel", new Date()));
        studentService.create(new Student("John", "Danail", new Date()));
    }

    private List<Unit> unitServiceOperations() throws BusinessException {
        UnitService unitService = new UnitService(new UnitRepository());
        Unit unit1 = new Unit("Maths", "I.D.");
        Unit unit2 = new Unit("Physics", "I.F.");
        Unit unit3 = new Unit("Chemistry", "J.D.");

        unitService.create(unit1);
        unitService.create(unit2);
        unitService.create(unit3);

        return List.of(unit1, unit2, unit3);
    }

    private void initializeDatabase() {
        String unitTableSql = "CREATE TABLE UNIT (id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR2(100), tutor_name VARCHAR2(100))";
        String studentTableSql = "CREATE TABLE STUDENT (id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR2(100), address VARCHAR2(100), dateOfBirth DATE)";
        String enrollmentTableSql = "CREATE TABLE ENROLLMENT (id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, grade NUMBER(3), student_id INTEGER, unit_id INTEGER, foreign key (student_id) references STUDENT(id), foreign key (unit_id) references UNIT(id))";
        createTable(unitTableSql);
        createTable(studentTableSql);
        createTable(enrollmentTableSql);
    }

    private void createTable(String command){
        try (Statement statement = DataSource.getConnection().createStatement()) {
            statement.execute(command);
            System.out.println("Table created: " + command);
        } catch (SQLException e) {
            System.out.println("Error while creating table: " + e);
            exit(-1);
        }
    }

    private void startH2Server() {
        try {
            server = Server.createTcpServer();
            server.start();
        } catch (SQLException e) {
            System.out.println("Error while starting H2 server: " + e);
            exit(-1);
        }
        System.out.println("H2 server has started with status: " + server.getStatus());
    }

    private void stopH2Server() {
        if (server == null) {
            return;
        }
        if (server.isRunning(true)) {
            server.stop();
            System.out.println("H2 server has been shutdown.");
        }
        server = null;
    }

    private void findDatabaseVersion(){
        try {
            String databaseVersion = DataSource.getConnection().getMetaData().getDatabaseProductVersion();
            System.out.println("Database version: " + databaseVersion);
        } catch (SQLException e) {
            System.out.println("Error while obtaining H2 server version: " + e);
            exit(-1);
        }
    }

}