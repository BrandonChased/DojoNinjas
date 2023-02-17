package brandon.dojoninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import brandon.dojoninjas.models.Dojo;
import brandon.dojoninjas.models.Ninja;
import brandon.dojoninjas.services.DojoService;
import brandon.dojoninjas.services.NinjaService;

@Controller
public class MainController {

    @Autowired
    DojoService dojoService;
    @Autowired
    NinjaService ninjaService;

    // New Dojo Page
    @GetMapping(value = { "/dojos/new", "/" })
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "dojos/new.jsp";
    }

    // Create new Dojo
    @PostMapping("/dojos")
    public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
        dojoService.createDojo(dojo);
        return "redirect:/";
    }

    // New Ninja Page
    @GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        List<Dojo> dojos = dojoService.getAll();
        model.addAttribute("dojos", dojos);
        return "ninjas/newNinja.jsp";
    }

    // Create New Ninja
    @PostMapping("/ninjas")
    public String createNinja(@ModelAttribute("ninja") Ninja ninja) {
        ninjaService.createNinja(ninja);
        return "redirect:/";
    }

    @GetMapping("/show/{id}")
    public String oneDojo(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.getDojo(id);
        model.addAttribute("dojo", dojo);
        return "dojos/show.jsp";
    }

}
