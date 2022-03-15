package com.example.webpos.web;

import com.example.webpos.biz.PosService;
import com.example.webpos.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PosController {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @GetMapping("/")
    public String pos(Model model) {
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        return "index";
    }
    @GetMapping("/add")
    public String add(@RequestParam(value = "id") String id) {
        posService.add(id,1);
        return "redirect:/";
    }
    @GetMapping("/minus")
    public String minus(@RequestParam(value = "id") String id) {
        posService.add(id,-1);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam(value = "id") String id) {
        posService.delete(id);
        return "redirect:/";
    }
    @GetMapping("/charge")
    public String charge() {
        posService.checkout(this.posService.getCart());
        return "redirect:/";
    }
    @GetMapping("/cancel")
    public String cancel() {
        posService.cancel(this.posService.getCart());
        return "redirect:/";
    }
}
