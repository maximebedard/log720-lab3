package ca.etsmtl.log720.lab3.services;

import ca.etsmtl.log720.lab3.dao.DossierDao;
import ca.etsmtl.log720.lab3.models.Dossier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("dossierService")
@Transactional
public class DossierServiceImpl implements DossierService {
    @Autowired
    private DossierDao dao;


    @Override
    public List<Dossier> findAllDossiers() {
        return dao.findAll();
    }

    @Override
    public Dossier findDossierById(int id) {
        return dao.findById(id);
    }

    @Override
    public void createDossier(Dossier dossier) {
        dao.create(dossier);
    }

    @Override
    public void updateDossier(Dossier dossier) {
        Dossier entity = dao.findById(dossier.getId());
        if(entity == null) return;

        entity.setNom(dossier.getNom());
        entity.setPrenom(dossier.getPrenom());
        entity.setNoPermis(dossier.getNoPermis());
        entity.setNoPlaque(dossier.getNoPlaque());
    }

    @Override
    public void deleteDossier(Dossier dossier) {
        dao.delete(dossier);
    }
}
