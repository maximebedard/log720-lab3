package ca.etsmtl.log720.lab3.services;

import ca.etsmtl.log720.lab3.models.Infraction;

import java.util.List;

public interface InfractionService {

    List<Infraction> findAllInfractions();

    Infraction findInfractionById(int id);

    void createInfraction(Infraction infraction);

    void updateInfraction(Infraction infraction);

    void deleteInfraction(Infraction infraction);
}
