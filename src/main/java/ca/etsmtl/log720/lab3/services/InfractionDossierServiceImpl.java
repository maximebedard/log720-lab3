package ca.etsmtl.log720.lab3.services;

import ca.etsmtl.log720.lab3.dao.InfractionDossierDao;
import ca.etsmtl.log720.lab3.models.InfractionDossier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("infractionDossierService")
public class InfractionDossierServiceImpl implements InfractionDossierService {

    @Autowired
    InfractionDossierDao dao;

    @Override
    public void createInfractionDossier(InfractionDossier infractionDossier) {
        dao.create(infractionDossier);
    }

    @Override
    public void deleteInfractionDossierById(int id) {
        dao.deleteById(id);
    }
}
