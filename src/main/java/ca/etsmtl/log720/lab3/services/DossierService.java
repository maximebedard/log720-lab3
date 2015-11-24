package ca.etsmtl.log720.lab3.services;

import ca.etsmtl.log720.lab3.models.Dossier;

import java.util.List;

public interface DossierService {

    List<Dossier> findAllDossiers();

    Dossier findDossierById(int id);

    void createDossier(Dossier dossier);

    void updateDossier(Dossier dossier);
}
