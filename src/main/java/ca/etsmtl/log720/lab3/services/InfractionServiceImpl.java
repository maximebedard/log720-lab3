package ca.etsmtl.log720.lab3.services;

import ca.etsmtl.log720.lab3.dao.InfractionDao;
import ca.etsmtl.log720.lab3.models.Infraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("infractionService")
@Transactional
public class InfractionServiceImpl implements InfractionService {
    @Autowired
    private InfractionDao dao;

    @Override
    public List<Infraction> findAllInfractions() {
        return dao.findAll();
    }

    @Override
    public Infraction findInfractionById(int id) {
        return dao.findById(id);
    }

    @Override
    public void createInfraction(Infraction infraction) {
        dao.create(infraction);
    }

    @Override
    public void updateInfraction(Infraction infraction) {
        Infraction entity = dao.findById(infraction.getId());
        if(entity == null) return;

        entity.setDescription(infraction.getDescription());
        entity.setGravite(infraction.getGravite());
    }

    @Override
    public void deleteInfraction(Infraction infraction) {
        dao.delete(infraction);
    }
}
