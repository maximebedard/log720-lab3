package ca.etsmtl.log720.lab3.services;

import ca.etsmtl.log720.lab3.dao.InfractionDossierDao;
import ca.etsmtl.log720.lab3.models.Dossier;
import ca.etsmtl.log720.lab3.models.Infraction;
import ca.etsmtl.log720.lab3.models.InfractionDossier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("infractionDossierService")
public class InfractionDossierServiceImpl implements InfractionDossierService {

    @Autowired
    InfractionDossierDao dao;

    @Override
    public void createInfractionsForDossier(Dossier dossier, String[] infractionIds) {
        List<InfractionDossier> associations = new ArrayList<>();
        for(String s : infractionIds){
            try {
                Integer infractionId = Integer.valueOf(s);

                Infraction infraction = new Infraction();
                infraction.setId(infractionId);

                InfractionDossier infractionDossier = new InfractionDossier();
                infractionDossier.setDossier(dossier);
                infractionDossier.setInfraction(infraction);

                dossier.addInfractionDossier(infractionDossier);
                dao.create(infractionDossier);
            } catch (NumberFormatException ex) {}
        }
    }

    @Override
    public InfractionDossier findInfractionDossierById(int id) {
        return dao.findById(id);
    }

    @Override
    public void deleteInfractionDossier(InfractionDossier infractionDossier) {
        dao.delete(infractionDossier);
    }
}
