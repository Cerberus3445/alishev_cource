package C.controllers;

import C.model.Person;
import C.services.PeopleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", peopleService.findAll());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute(peopleService.findOne(id));
        return "people/show";
    }
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }
    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) { //С помощью @ModelAttribute создаём нового пустого человека, затем @ModelAttribute внедряет этого человека из формы в этот объект класса person, и затем она этот объект внедряет в модель
        if(bindingResult.hasErrors()) return "people/new";
        peopleService.save(person);
        return "redirect:/people";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", peopleService.findOne(id));
        return "people/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,BindingResult bindingResult, @PathVariable("id") int id){
        if(bindingResult.hasErrors()) return "people/edit";
        peopleService.update(id, person);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        peopleService.delete(id);
        return "redirect:/people";
    }
    @GetMapping("/admin")
    public String adminPage(Model model, @ModelAttribute("person") Person person){
        model.addAttribute("all_people", peopleService.findAll());
        return "people/adminPage";
    }
    @PatchMapping("/admin/add")
    public String makeAdmin(@ModelAttribute("person") Person person){
        System.out.println(person.getId());
        return "redirect:/people";
    }
}
