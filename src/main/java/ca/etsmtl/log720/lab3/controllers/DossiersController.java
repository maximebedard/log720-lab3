package ca.etsmtl.log720.lab3.controllers;

import ca.etsmtl.log720.lab3.models.Dossier;
import ca.etsmtl.log720.lab3.models.Infraction;
import ca.etsmtl.log720.lab3.services.DossierService;
import ca.etsmtl.log720.lab3.services.InfractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/dossiers")
public class DossiersController {

    @Autowired
    DossierService dosierService;

    @Autowired
    InfractionService infractionService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String listDossiers(Model model) {
        List<Dossier> dossiers = dosierService.findAllDossiers();
        model.addAttribute("dossiers", dossiers);
        model.addAttribute("dossier", new Dossier());
        return "dossiers/index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createDossier(@Valid Dossier dossier, BindingResult result, final RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) return "dossiers/index";

        dosierService.createDossier(dossier);
        redirectAttributes.addFlashAttribute("message", "Le dossier à été créé avec succès.");
        return "redirect:/dossiers";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editDossier(@PathVariable int id, Model model){
        Dossier dossier = dosierService.findDossierById(id);
        List<Infraction> infractions = infractionService.findAllInfractions();

        model.addAttribute("dossier", dossier);
        model.addAttribute("allInfractions", infractions);
        return "dossiers/edit";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String updateDossier(@Valid Dossier dossier, @PathVariable int id, BindingResult result, final RedirectAttributes redirectAttributes) {

        if(result.hasErrors()) return "dossiers/edit";

        dosierService.updateDossier(dossier);
        redirectAttributes.addFlashAttribute("message", "Le dossier à été modifié avec succès.");
        return "redirect:/dossiers";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteDossier(@PathVariable int id, final RedirectAttributes redirectAttributes) {
        dosierService.deleteDossierById(id);
        redirectAttributes.addFlashAttribute("message", "Le dossier à été supprimé avec succès");
        return "redirect:/dossiers";
    }
}
