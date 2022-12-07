package com.example.Rabota.Controller;

import com.example.Rabota.Models.Specifications;
import com.example.Rabota.repo.SpecsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SpecsController {
    @Autowired
    private SpecsRepository specsRepository;
    @GetMapping("/Specs")
    public String GetSpecs(Model model)
    {
        Iterable<Specifications> specifications = specsRepository.findAll();
        model.addAttribute("Specifications",specifications);
        return "MainSpecs";
    }
    @GetMapping("/Add/Specs")
    public String GetAddSpecs(Model model)
    {
        return "Add-Specs";
    }
    @PostMapping("/Add/Specs")
    public String blogPostAdd(@RequestParam(value="CPU") String CPU,
                              @RequestParam(value ="RAM" ) int RAM,
                              @RequestParam(value = "MemorySize") String MemorySize,
                              @RequestParam(value ="GPU" ) String GPU,
                              @RequestParam(value = "OS") String OS,
                              Model model)
    {
        Specifications specifications = new Specifications(CPU, RAM, MemorySize, GPU, OS);
        specsRepository.save(specifications);
        return "redirect:/Specs";
    }
    @GetMapping( path = "/Search/Specs")
    public String blogFilter(Model model)
    {
        return "Search-Specs";
    }

    @PostMapping("/Search/Specs-result")
    public String blogResult(@RequestParam String CPU, Model model)
    {
        List<Specifications> specifications = specsRepository.findByCPU(CPU);
        model.addAttribute("result", specifications);
        return "Search-Specs";
    }
    @PostMapping("/Search/Specs")
    public String simpleSearch(@RequestParam String GPU, Model model)
    {
        List<Specifications> specifications = specsRepository.findByGPU(GPU);
        model.addAttribute("result", specifications);
        return "Search-Specs";
    }

}
