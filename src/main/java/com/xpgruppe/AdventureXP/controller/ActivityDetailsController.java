package com.xpgruppe.AdventureXP.controller;
import com.xpgruppe.AdventureXP.service.ActivityService;
import com.xpgruppe.AdventureXP.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActivityDetailsController {

    @Autowired
    EquipmentService equipmentService;

    @GetMapping("/activity-details")
    public String activityDetails(Model model) {
        model.addAttribute("getEquipment",equipmentService.getEquipment(1L));
        return "activityDetails";

    }

}
