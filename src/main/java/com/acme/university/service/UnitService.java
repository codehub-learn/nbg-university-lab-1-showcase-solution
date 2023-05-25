package com.acme.university.service;

import com.acme.university.model.Unit;
import com.acme.university.model.exception.BusinessException;
import com.acme.university.repository.UnitRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UnitService {

    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public void create(Unit unit) throws BusinessException {
        System.out.println("Creating Unit");
        try {
            unitRepository.create(unit);
            System.out.println("Created unit: " + unit);
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Unit> findAll() throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public Optional<Unit> findByID(Long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public boolean update(Unit Unit) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public boolean delete(Unit Unit) throws BusinessException {
        throw new UnsupportedOperationException();
    }
}
