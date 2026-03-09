package com.xpgruppe.AdventureXP.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/CRUD")
public class CRUDActivityController {

    @GetMapping("/activity")
    public String getPage(){
        return "crud-activity";
    }


}
