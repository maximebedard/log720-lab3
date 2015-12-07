package ca.etsmtl.log720.lab3.dao;

import ca.etsmtl.log720.lab3.models.InfractionDossier;

import java.util.List;

public interface InfractionDossierDao {

    List<InfractionDossier> findAll();

    InfractionDossier findById(Integer id);

    void create(InfractionDossier infractionDossier);

    void delete(InfractionDossier infractionDossier);

}
