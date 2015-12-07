package ca.etsmtl.log720.lab3.dao;

import ca.etsmtl.log720.lab3.models.Dossier;
import org.springframework.stereotype.Repository;

@Repository("dossierDao")
public class DossierDaoImpl extends AbstractDao<Integer, Dossier> implements DossierDao {

}
