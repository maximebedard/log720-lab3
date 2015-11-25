package ca.etsmtl.log720.lab3.dao;

import ca.etsmtl.log720.lab3.models.Dossier;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dossierDao")
public class DossierDaoImpl extends AbstractDao<Integer, Dossier> implements DossierDao {
    @Override
    public List<Dossier> findAllDossiers() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
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

    @Override
    public void deleteDossierById(int id) {
        Dossier dossier = new Dossier();
        dossier.setId(id);
        getSession().delete(dossier);
    }
}
