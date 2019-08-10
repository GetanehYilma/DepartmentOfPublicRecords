package gov.wakanda.DepartmentOfPublicRecords.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gov.wakanda.DepartmentOfPublicRecords.model.Citizen;
import gov.wakanda.DepartmentOfPublicRecords.model.State;
import gov.wakanda.DepartmentOfPublicRecords.service.CitizenService;
import gov.wakanda.DepartmentOfPublicRecords.service.StateService;



@Controller
public class CitizenController {
	
	@Autowired
	private StateService stateService;
	@Autowired
	private CitizenService citizenService;
	
	@GetMapping(value = {"citizen/list"})
	public ModelAndView showListOfCitizen(@RequestParam(defaultValue = "0") int pageNo) {
		
        ModelAndView mv = new ModelAndView();
       mv.addObject("citizens", citizenService.getAllCitizens(pageNo));
       mv.addObject("totalYearlyIncome", citizenService.computeYearlyIncome());
        mv.addObject("currentPageNo", pageNo);
        mv.setViewName("citizen/list");
        
        
        return mv;
    }
	
	@GetMapping(value = {"/citizen/add"})
    public String newAccountForm(Model model) {
		
		Citizen citizen = new Citizen();
       // List<Citizen> citizens = citizenService.getAllCitizens();
        List<State> states = stateService.getAllStates();
        model.addAttribute("citizen", citizen);
       
        model.addAttribute("states", states);
       
        return "citizen/add";
    }
	
	@PostMapping(value = {"/citizen/add"})
    public String addProduct(@Valid @ModelAttribute("citizen") Citizen citizen,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            System.out.println(bindingResult.getErrorCount());
            List<State> states = stateService.getAllStates();            
            model.addAttribute("states", states);
            return "citizen/add";
        }
        
        citizen = citizenService.addNewCitizen(citizen);
        return "redirect:/citizen/list";
	}

}
