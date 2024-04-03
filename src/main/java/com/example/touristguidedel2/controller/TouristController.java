    package com.example.touristguidedel2.controller;

    import com.example.touristguidedel2.model.TouristAttraction;
    import com.example.touristguidedel2.repository.Repository_DB;
    import com.example.touristguidedel2.service.TouristService;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;

    @Controller
    @RequestMapping("attractions")
    public class TouristController {
        private TouristService touristService;
        private Repository_DB repository_db;

        public TouristController(TouristService touristService, Repository_DB repository_db) {
            this.touristService = touristService;
            this.repository_db = repository_db;
        }

        @GetMapping("/")
        public String index() {
            return "index";
        }


        @GetMapping("")
        public String getAll(Model model) {
            model.addAttribute("attractions", repository_db.getAll());
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

        /*@GetMapping("/add")
        public String addAttraction(Model model) {
            model.addAttribute("attractions", new TouristAttraction());
            model.addAttribute("city", touristService.getCities());
            model.addAttribute("tags", touristService.getNameByTag());
            return "addAttraction";
        }

         */

        @GetMapping("/add")
        public String addAttraction(Model model, TouristAttraction touristAttraction) {
            model.addAttribute("attractions", touristAttraction);
            repository_db.create(touristAttraction);
            model.addAttribute("city", touristService.getCities());
            model.addAttribute("tags", touristService.getNameByTag());
            return "addAttraction";
        }



        @PostMapping("/save")
        public String save(@ModelAttribute TouristAttraction touristAttraction, Model model) {
            model.addAttribute("add", touristService.addAttraction(touristAttraction));
            return "redirect:/attractions";
        }



        @GetMapping("/edit/{name}")
        public String edit(@PathVariable String name, Model model) {
            model.addAttribute("attraction", touristService.getByName(name));
            model.addAttribute("city", touristService.getCities());
            model.addAttribute("tags",  touristService.getNameByTag());
            return "updateAttraction";
        }


        @PostMapping("/update")
        public String update(@ModelAttribute TouristAttraction touristAttraction) {
            touristService.update(touristAttraction);
            return "redirect:/attractions";
        }




        /*
        @PostMapping("/update")
        public String update(@ModelAttribute String name, String description, String city, List<String> tagList) {
            touristService.edit(name, description, city, tagList);
            return "redirect:/attractions";
        }

         */


        @GetMapping("/delete/{id}")
        public String delete(@PathVariable int id, Model model) {
            repository_db.delete(id);
            model.addAttribute("attraction", id);
            return "redirect:/attractions";
        }

        @GetMapping("/{name}/tags")
        public String getAttractionTags(Model model, @PathVariable String name) {
            List<TouristAttraction> touristAttractions = touristService.getAll();
            TouristAttraction attraction = null;
            for (TouristAttraction touristAttraction : touristAttractions) {
                if (touristAttraction.getName().equals(name)) {
                    attraction = touristAttraction;
                }
            }
            model.addAttribute("attraction", attraction);
            return "tags";
        }
    }