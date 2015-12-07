package ca.etsmtl.log720.lab3.dao;

import ca.etsmtl.log720.lab3.models.InfractionDossier;
import org.springframework.stereotype.Repository;

@Repository("infractionDossierDao")
public class InfractionDossierDaoImpl extends AbstractDao<Integer, InfractionDossier> implements InfractionDossierDao {

    @Override
    public void delete(InfractionDossier entity) {
        getSession().delete(entity);
        getSession().flush();
    }

    @Override
    public void create(InfractionDossier entity) {
        super.create(entity);
        getSession().flush();
    }
}
