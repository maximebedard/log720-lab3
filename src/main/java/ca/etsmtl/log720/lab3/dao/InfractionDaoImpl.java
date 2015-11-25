package ca.etsmtl.log720.lab3.dao;

import ca.etsmtl.log720.lab3.models.Infraction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("infractionDao")
public class InfractionDaoImpl extends AbstractDao<Integer, Infraction> implements InfractionDao {
    @Override
    public List<Infraction> findAllInfractions() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Override
    public Infraction findInfractionById(int id) {
        return getByKey(id);
    }

    @Override
    public void createInfraction(Infraction infraction) {
        persist(infraction);
    }

    @Override
    public void deleteInfractionById(int id) {
        Infraction infraction = new Infraction();
        infraction.setId(id);
        getSession().delete(infraction);
    }
}
