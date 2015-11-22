package ca.etsmtl.log720.lab3.dao;

import ca.etsmtl.log720.lab3.models.Dossier;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dossierDao")
public class DossierDaoImpl extends AbstractDao<Integer, Dossier> implements DossierDao {
    @Override
    public List<Dossier> findAllDossiers() {
        Criteria criteria = createEntityCriteria();
        return criteria.list();
    }

    @Override
    public Dossier findDossierById(int id) {
        return getByKey(id);
    }

    @Override
    public void createDossier(Dossier dossier) {
        persist(dossier);
    }
}
