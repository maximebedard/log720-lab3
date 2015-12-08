package ca.etsmtl.log720.lab3.controllers;

import ca.etsmtl.log720.lab3.models.Dossier;
import ca.etsmtl.log720.lab3.models.Infraction;
import ca.etsmtl.log720.lab3.services.DossierService;
import ca.etsmtl.log720.lab3.services.InfractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ExecutionException;


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
        loadDossiers(model);
        model.addAttribute("dossier", new Dossier());
        return "dossiers/index";
    }

    private void loadDossiers(Model model) {
        List<Dossier> dossiers = dosierService.findAllDossiers();
        model.addAttribute("dossiers", dossiers);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createDossier(@Valid Dossier dossier, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            loadDossiers(model);
            return "dossiers/index";
        }

        try {
            dosierService.createDossier(dossier);

            redirectAttributes.addFlashAttribute("message", "Le dossier à été créé avec succès.");
        } catch (Exception ex) { // hack pour voir si il y a une erreur (dupplicate entry)
            redirectAttributes.addFlashAttribute("message", "Une erreur s'est produite lors de la sauvegarde du dossier." +
                    "Un dossier avec un numéro de permis identique existe déjà.");
        }
        return "redirect:/dossiers";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editDossier(@PathVariable int id, Model model){
        Dossier dossier = dosierService.findDossierById(id);
        if(dossier == null) return "404";

        model.addAttribute("dossier", dossier);
        return "dossiers/edit";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String updateDossier(@Valid Dossier dossier, BindingResult result, final RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) return "dossiers/edit";

        try{
            dosierService.updateDossier(dossier);

            redirectAttributes.addFlashAttribute("message", "Le dossier à été modifié avec succès.");
        } catch (Exception ex) { // hack pour voir si il y a une erreur (dupplicate entry)
            redirectAttributes.addFlashAttribute("message", "Une erreur s'est produite lors de la sauvegarde du dossier." +
                    "Un dossier avec un numéro de permis identique existe déjà.");
        }
        return "redirect:/dossiers";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteDossier(@PathVariable int id, final RedirectAttributes redirectAttributes) {
        Dossier dossier = dosierService.findDossierById(id);
        if (dossier == null) return "404";

        dosierService.deleteDossier(dossier);
        redirectAttributes.addFlashAttribute("message", "Le dossier à été supprimé avec succès");
        return "redirect:/dossiers";
    }
}
