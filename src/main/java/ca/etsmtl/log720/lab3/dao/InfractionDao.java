package ca.etsmtl.log720.lab3.dao;

import ca.etsmtl.log720.lab3.models.Infraction;

import java.util.List;

public interface InfractionDao {

    List<Infraction> findAllInfractions();

    Infraction findInfractionById(int id);

    void createInfraction(Infraction infraction);

    void deleteInfractionById(int id);
}
