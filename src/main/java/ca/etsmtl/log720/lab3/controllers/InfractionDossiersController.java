package ca.etsmtl.log720.lab3.controllers;

import ca.etsmtl.log720.lab3.models.Dossier;
import ca.etsmtl.log720.lab3.models.InfractionDossier;
import ca.etsmtl.log720.lab3.services.DossierService;
import ca.etsmtl.log720.lab3.services.InfractionDossierService;
import ca.etsmtl.log720.lab3.services.InfractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/dossiers/{dossierId}/infractions")
public class InfractionDossiersController {

    @Autowired
    InfractionDossierService infractionDossierService;

    @Autowired
    DossierService dossierService;

    @Autowired
    InfractionService infractionService;

    @RequestMapping(method = RequestMethod.GET)
    public String listInfractionDossiers(@PathVariable int dossierId, Model model) {
        Dossier dossier = dossierService.findDossierById(dossierId);
        if (dossier == null) return "404";

        model.addAttribute("dossier", dossier);
        model.addAttribute("allInfractions", infractionService.findAllInfractions());

        return "/infraction_dossier/edit";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addInfractionDossiers(@PathVariable int dossierId,
                                        @RequestParam(value="infractions[]") String[] infractionIds,
                                        final RedirectAttributes redirectAttributes) {

        Dossier dossier = dossierService.findDossierById(dossierId);
        if (dossier == null) return "404";

        infractionDossierService.createInfractionsForDossier(dossier, infractionIds);
        redirectAttributes.addFlashAttribute("message", "Les infractions ont été ajoutés au dossier avec succès!");
        return "redirect:/dossiers/" + dossierId + "/edit";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteInfractionDossier(@PathVariable int dossierId,
                                          @PathVariable int id,
                                          final RedirectAttributes redirectAttributes) {

        InfractionDossier infractionDossier = infractionDossierService.findInfractionDossierById(id);
        if(infractionDossier == null) return "404";

        infractionDossierService.deleteInfractionDossier(infractionDossier);
        redirectAttributes.addFlashAttribute("message", "L'infraction a été supprimé du dossier avec succès!");
        return "redirect:/dossiers/" + dossierId + "/edit";
    }
}
