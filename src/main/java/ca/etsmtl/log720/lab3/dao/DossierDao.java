package ca.etsmtl.log720.lab3.dao;

import ca.etsmtl.log720.lab3.models.Dossier;

import java.util.List;

public interface DossierDao {

    List<Dossier> findAllDossiers();

    Dossier findDossierById(int id);

    void createDossier(Dossier dossier);

    void deleteDossierById(int id);
}
