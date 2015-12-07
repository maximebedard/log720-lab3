package ca.etsmtl.log720.lab3.dao;

import ca.etsmtl.log720.lab3.models.Infraction;
import org.springframework.stereotype.Repository;

@Repository("infractionDao")
public class InfractionDaoImpl extends AbstractDao<Integer, Infraction> implements InfractionDao {

}
