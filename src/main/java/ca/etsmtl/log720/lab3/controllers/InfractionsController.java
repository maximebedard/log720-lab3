package ca.etsmtl.log720.lab3.controllers;

import ca.etsmtl.log720.lab3.models.Infraction;
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
@RequestMapping("/infractions")
public class InfractionsController {

    @Autowired
    InfractionService service;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String listInfractions(Model model) {
        loadInfractions(model);
        model.addAttribute("infraction", new Infraction());
        return "infractions/index";
    }

    private void loadInfractions(Model model) {
        List<Infraction> infractions = service.findAllInfractions();
        model.addAttribute("infractions", infractions);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createInfraction(@Valid Infraction infraction, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            loadInfractions(model);
            return "infractions/index";
        }

        service.createInfraction(infraction);
        redirectAttributes.addFlashAttribute("message", "L'infraction a été créé avec succès.");
        return "redirect:/infractions";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editInfraction(@PathVariable int id, Model model){
        Infraction infraction = service.findInfractionById(id);
        if (infraction == null) return "404";

        model.addAttribute("infraction", infraction);
        return "infractions/edit";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String updateInfraction(@Valid Infraction infraction, BindingResult result, final RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) return "infractions/edit";


        service.updateInfraction(infraction);
        redirectAttributes.addFlashAttribute("message", "L'infraction a été modifié avec succès.");
        return "redirect:/infractions";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteInfraction(@PathVariable int id, final RedirectAttributes redirectAttributes) {
        Infraction infraction = service.findInfractionById(id);
        if(infraction == null) return "404";

        service.deleteInfraction(infraction);
        redirectAttributes.addFlashAttribute("message", "L'infraction a été supprimé avec succès");
        return "redirect:/infractions";
    }
}
