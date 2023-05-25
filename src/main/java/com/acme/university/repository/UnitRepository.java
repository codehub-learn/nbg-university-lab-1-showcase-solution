package com.acme.university.repository;

import com.acme.university.model.Unit;
import com.acme.university.repository.datasource.DataSource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class UnitRepository {


    public void create(Unit unit) throws SQLException {
        String sql = "INSERT INTO UNIT(name, tutor_name) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, unit.getName());
            preparedStatement.setString(2, unit.getTutorName());
            preparedStatement.executeUpdate();

            // setting id
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next(); // we only suppose that there is a single generated key
            unit.setId(generatedKeys.getLong(1));
        } catch (SQLException e) {
            throw new SQLException("Could not create unit.", e);
        }
    }

    public List<Unit> findAll() throws SQLException {
        throw new UnsupportedOperationException();
    }

    public Optional<Unit> findByID(Long id) throws SQLException {
        throw new UnsupportedOperationException();
    }

    public boolean update(Unit unit) throws SQLException {
        throw new UnsupportedOperationException();
    }

    public boolean delete(Unit unit) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
