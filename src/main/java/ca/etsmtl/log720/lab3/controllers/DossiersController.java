package ca.etsmtl.log720.lab3.controllers;

import ca.etsmtl.log720.lab3.models.Dossier;
import ca.etsmtl.log720.lab3.services.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String listDossiers(Model model) {
        List<Dossier> dossiers = service.findAllDossiers();
        model.addAttribute("dossiers", dossiers);
        model.addAttribute("dossier", new Dossier());
        return "dossiers/index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createDossier(@Valid Dossier dossier, BindingResult result,
                                Model model) {
        if(result.hasErrors()) return "dossiers/index";

        service.createDossier(dossier);
        return "redirect:/dossiers";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editDossier(@PathVariable int id, Model model){
        Dossier dossier = service.findDossierById(id);
        model.addAttribute("dossier", dossier);
        return "dossiers/edit";
    }

    public String updateDossier() {
        return "";
    }
}
