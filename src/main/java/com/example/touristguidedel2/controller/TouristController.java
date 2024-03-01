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

        @GetMapping("/")
        public String index() {
            return "index";
        }


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
        public String addAttraction(Model model) {
            model.addAttribute("attractions", new TouristAttraction());
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
            model.addAttribute("cities", touristService.getCities());
            model.addAttribute("tags", touristService.getNameByTag());
            return "updateAttraction";
        }

        @PostMapping("/update")
        public String update(@ModelAttribute TouristAttraction touristAttraction) {
            touristService.update(touristAttraction);
            return "redirect:/attractions";
        }

        @GetMapping("/delete/{name}")
        public String delete(@PathVariable String name, Model model) {
            touristService.delete(name);
            model.addAttribute("attraction", name);
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