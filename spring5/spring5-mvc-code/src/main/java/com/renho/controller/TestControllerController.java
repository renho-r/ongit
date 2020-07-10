package com.renho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Controller
@RequestMapping("/test/controller")
public class TestControllerController {

    @GetMapping("/owners/{ownerId}/pets/{petId}")
    public String findPet(@PathVariable String ownerId, @PathVariable String petId, Model model) {
        System.out.println("findPet: ownerId>" + ownerId + ", petId>" + petId);
        return "redirect:/";
    }

    @RequestMapping("/spring-web/{symbolicName:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{extension:\\.[a-z]+}")
    public String handle(@PathVariable String version, @PathVariable String extension) {
        System.out.println("handle: version>" + version + ", extension>" + extension);
        return "redirect:/";
    }

    @GetMapping("/pets/{petId}")
    public String findPetMatrix(@PathVariable String petId, @MatrixVariable int q) {
        System.out.println("findPetMatrix: petId>" + petId + ", q>" + q);
        return "redirect:/";
    }

    @GetMapping(path = "/pets/{petId}", params = "myParam=myValue")
    public String findPetMyParam(@PathVariable String petId, Model model) {
        System.out.println("findPetMyParam: petId>" + petId);
        return "redirect:/";
    }

//    @GetMapping("/processSubmit")
//    public String processSubmit(@Validated @ModelAttribute("pet") Pet pet, Model model, BindingResult result) {
//        System.out.println("processSubmit: pet.name>" + pet.name);
//        return "redirect:/";
//    }

    @GetMapping("/processSubmit")
    public String processSubmit(@Validated @ModelAttribute("pet") Pet pet, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "petForm";
        }
        System.out.println("processSubmit: pet.name>" + pet.name);
        return "redirect:/";
    }

    public static class Pet {

        @NotNull(message="名字不能为空")
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
