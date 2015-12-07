package ca.etsmtl.log720.lab3.dao;

import ca.etsmtl.log720.lab3.models.Dossier;

import java.util.List;

public interface DossierDao {

    List<Dossier> findAll();

    Dossier findById(Integer id);

    void create(Dossier infraction);

    void deleteById(Integer id);

}
