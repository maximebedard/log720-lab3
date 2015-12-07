package ca.etsmtl.log720.lab3.dao;

import ca.etsmtl.log720.lab3.models.Infraction;

import java.util.List;

public interface InfractionDao {

    List<Infraction> findAll();

    Infraction findById(Integer id);

    void create(Infraction infraction);

    void delete(Infraction infraction);
}
