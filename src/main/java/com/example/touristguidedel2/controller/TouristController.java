package com.example.touristguidedel2.controller;

import com.example.touristguidedel2.model.TouristAttraction;
import com.example.touristguidedel2.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    /*@GetMapping("/")
    public String index() {
        return "index";
    }

     */

    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("attractions", touristService.getAll());
        return "attractions";
    }

    @GetMapping("/{name}")
    public String getByName(@PathVariable String name, Model model) {
        if (touristService.getByName(name) != null) {
            model.addAttribute("attractions", touristService.getByName(name));
            return "attractions-Details";
        } else {
            return "error";
        }
    }

    @GetMapping("/add")
    public String create(TouristAttraction touristAttraction, Model model) {
        model.addAttribute("attractions", touristService.create(touristAttraction));
        return "add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute TouristAttraction touristAttraction) {
        touristService.save(touristAttraction);
        return "save";
    }

    @GetMapping("/edit/{name}")
    public String edit(String name, String description, String city, List<String> tagList, Model model) {
        model.addAttribute(touristService.edit(name, description, city, tagList));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@RequestBody TouristAttraction touristAttraction) {
        touristService.update(touristAttraction);
        return "update";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String name, Model model) {
        touristService.delete(name);
        model.addAttribute("delitedAttractionName", name);
        return "delete";
    }

    @GetMapping("/{name}/tags")
    public String getNameByTag(@PathVariable("name") String name, Model model) {
        model.addAttribute("tags", touristService.attractionTagsList(name));
        return "tags";
    }


}
