package ca.etsmtl.log720.lab3.services;

import ca.etsmtl.log720.lab3.models.InfractionDossier;

public interface InfractionDossierService {
    void createInfractionDossier(InfractionDossier infractionDossier);

    void deleteInfractionDossierById(int id);
}
