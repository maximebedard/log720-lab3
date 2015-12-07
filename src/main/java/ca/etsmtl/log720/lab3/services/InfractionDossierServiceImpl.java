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

    @Autowired
    InfractionService infractionService;

    @Override
    public void createInfractionsForDossier(Dossier dossier, String[] infractionIds) {
        List<InfractionDossier> associations = new ArrayList<>();
        for(String s : infractionIds){
            try {
                Integer id = Integer.valueOf(s);
                Infraction infraction = infractionService.findInfractionById(id);
                if (infraction == null) continue;

                InfractionDossier infractionDossier = new InfractionDossier();
                infractionDossier.setDossier(dossier);
                infractionDossier.setInfraction(infraction);
                dao.create(infractionDossier);
            } catch (NumberFormatException ex) {}
        }
    }
}
