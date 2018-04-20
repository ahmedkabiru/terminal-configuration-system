package com.globalaccelerex.tcs.controller;


import com.globalaccelerex.tcs.domain.Terminal;
import com.globalaccelerex.tcs.domain.User;
import com.globalaccelerex.tcs.service.TerminalService;
import com.globalaccelerex.tcs.service.UserService;
import com.globalaccelerex.tcs.util.BreadCrumbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/terminal")
public class TerminalController {


    private TerminalService terminalService;
    private UserService userService;

    @Autowired
    public TerminalController(TerminalService terminalService,UserService userService) {
        this.terminalService = terminalService;
        this.userService =userService;
    }


    @RequestMapping(value = "",method = RequestMethod.GET)
    public  String index(Model model, Principal principal){
        String pageTitle = "Terminal Management";
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user",user);
        List<Terminal> terminals =terminalService.getAllTerminal();
        model.addAttribute("terminals",terminals);
        BreadCrumbs.set(model, pageTitle);
        return "terminal/manage";
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public  String addTerminal(Terminal terminal){

        return  "terminal/add";
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public String addTerminal(@Valid Terminal terminal, BindingResult bindingResult, Model model, Principal principal, RedirectAttributes redirectAttributes){
        validInputField(terminal,bindingResult);
        if(bindingResult.hasErrors()){
            return  "terminal/add";
        }
        User user = userService.findByUsername(principal.getName());
        terminal.setUserId(user.getUserId());
        terminalService.add(terminal);
        redirectAttributes.addFlashAttribute("successMsg", "The Terminal is Created Successfully!");

        return "redirect:/terminal";

    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updateTerminal(@RequestParam(value = "id") Long id ,Model model){

        Terminal terminal = terminalService.findById(id);
        model.addAttribute("terminal",terminal);

        return "terminal/update";

    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public  String updateTerminal(@ModelAttribute("configId") Long configId,Terminal terminal,Model model,RedirectAttributes redirectAttributes){
         terminalService.update(configId,terminal);
         redirectAttributes.addFlashAttribute("successMsg","Terminal Updated Successfully");
        return "redirect:/terminal";
    } 


    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public ModelAndView viewTerminalInfo(@RequestParam(value = "id") Long id){
        Terminal terminal = terminalService.findById(id);
        System.out.println("Terminal Params"+terminal);
        return  new ModelAndView("terminal/view","terminals",terminal);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public  String deleteTerminal(@RequestParam(value = "id") Long id){
        terminalService.delete(id);
        return "redirect:/terminal";
    }


    private void validInputField(Terminal terminal,BindingResult bindingResult){
        if(terminalService.checkTerminalIdExist(terminal.getTerminalId())){
            bindingResult.rejectValue("terminalId", "error.terminal", "Terminal ID  Already exists!");
        }
        else if(terminalService.checkSerialNoExist(terminal.getSerialNo())){
            bindingResult.rejectValue("serialNo", "error.terminal", "Serial No Already exists!");
        }
    }


}
