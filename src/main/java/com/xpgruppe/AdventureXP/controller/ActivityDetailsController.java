package com.xpgruppe.AdventureXP.controller;
import com.xpgruppe.AdventureXP.model.Equipment;
import com.xpgruppe.AdventureXP.service.ActivityService;
import com.xpgruppe.AdventureXP.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ActivityDetailsController {

    @Autowired
    EquipmentService equipmentService;
    @Autowired
    ActivityService activityService;

    @GetMapping("/activity-details")
    public String activityDetails(Model model) {
        List<Equipment> equipmentList = equipmentService.getAll();
        model.addAttribute("activity", activityService.getActivity(1L));
        model.addAttribute("equipment",equipmentList);
        return "activityDetails";

    }

}
