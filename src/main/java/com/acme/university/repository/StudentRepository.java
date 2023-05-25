package com.acme.university.repository;

import com.acme.university.model.Enrollment;
import com.acme.university.model.Student;
import com.acme.university.repository.datasource.DataSource;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class StudentRepository {

    public void create(Student student) throws SQLException {
        String sql = "INSERT INTO STUDENT(name, address, dateOfBirth) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setDate(3, new Date(student.getDateOfBirth().getTime()));
            preparedStatement.executeUpdate();

            // setting id
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next(); // we only suppose that there is a single generated key
            student.setId(generatedKeys.getLong(1));
        } catch (SQLException e) {
            throw new SQLException("Could not create student.", e);
        }
    }

    public void createEnrollment(final Student student, final Enrollment enrollment) throws SQLException {
        String sql = "INSERT INTO ENROLLMENT(unit_id, grade, student_id) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setLong(1, enrollment.getUnit().getId());
            preparedStatement.setInt(2, enrollment.getGrade());
            preparedStatement.setLong(3, student.getId());
            preparedStatement.executeUpdate();

            // setting id
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next(); // we only suppose that there is a single generated key
            enrollment.setId(generatedKeys.getLong(1));
        } catch (SQLException e) {
            throw new SQLException("Could not create student.", e);
        }
    }

    public List<Student> findAll() throws SQLException {
        throw new UnsupportedOperationException();
    }

    public Optional<Student> findByID(Long aLong) throws SQLException {
        throw new UnsupportedOperationException();
    }

    public boolean update(Student student) throws SQLException {
        throw new UnsupportedOperationException();
    }

    public boolean delete(Student student) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
