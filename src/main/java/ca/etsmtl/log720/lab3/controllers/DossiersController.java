package ca.etsmtl.log720.lab3.controllers;

import ca.etsmtl.log720.lab3.models.Dossier;
import ca.etsmtl.log720.lab3.services.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/dossiers")
public class DossiersController {

    @Autowired
    DossierService service;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String listDossiers(ModelMap model) {
        List<Dossier> dossiers = service.findAllDossiers();
        model.addAttribute("dossiers", dossiers);
        return "dossiers/index";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newDossier(ModelMap model) {
        Dossier dossier = new Dossier();
        model.addAttribute("dossier", dossier);
        model.addAttribute("edit", false);
        return "dossiers/new";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String createDossier(@Valid Dossier dossier, BindingResult result,
                                ModelMap model) {
        return "redirect:/dossiers";

    }
}
