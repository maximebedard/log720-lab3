package ca.etsmtl.log720.lab3.dao;

import ca.etsmtl.log720.lab3.models.InfractionDossier;
import org.springframework.stereotype.Repository;

@Repository("infractionDossierDao")
public class InfractionDossierDaoImpl extends AbstractDao<Integer, InfractionDossier> implements InfractionDossierDao {

}
