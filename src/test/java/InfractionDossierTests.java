import ca.etsmtl.log720.lab3.ApplicationConfiguration;
import ca.etsmtl.log720.lab3.models.Dossier;
import ca.etsmtl.log720.lab3.models.Infraction;
import ca.etsmtl.log720.lab3.models.InfractionDossier;
import ca.etsmtl.log720.lab3.services.DossierService;
import ca.etsmtl.log720.lab3.services.InfractionDossierService;
import ca.etsmtl.log720.lab3.services.InfractionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {ApplicationConfiguration.class, HibernateConfiguration.class})
@WebAppConfiguration
@SpringApplicationConfiguration(ApplicationConfiguration.class)
public class InfractionDossierTests {

    @Autowired
    DossierService dossierService;

    @Autowired
    InfractionService infractionService;

    @Autowired
    InfractionDossierService infractionDossierService;

    @Test
    public void testAddingInfractionDossier() {
        Dossier d = new Dossier();
        d.setNom("Lemieux");
        d.setPrenom("Henry");
        d.setNoPlaque("123123");
        d.setNoPermis("123123");

        dossierService.createDossier(d);

        Infraction i = new Infraction();
        i.setDescription("Vol de voiture");
        i.setGravite(100);

        infractionService.createInfraction(i);

        InfractionDossier asso = new InfractionDossier();
        asso.setDossier(d);
        asso.setInfraction(i);


        infractionDossierService.createInfractionDossier(asso);
    }
}

