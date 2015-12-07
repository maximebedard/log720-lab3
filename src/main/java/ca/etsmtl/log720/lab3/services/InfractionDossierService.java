package ca.etsmtl.log720.lab3.services;

import ca.etsmtl.log720.lab3.models.Dossier;
import ca.etsmtl.log720.lab3.models.InfractionDossier;

public interface InfractionDossierService {
    void createInfractionsForDossier(Dossier dossier, String[] infractionIds);

    InfractionDossier findInfractionDossierById(int id);

    void deleteInfractionDossier(InfractionDossier infractionDossier);
}
