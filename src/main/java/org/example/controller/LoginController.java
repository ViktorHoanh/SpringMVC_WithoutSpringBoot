package org.example.controller;

import org.example.dao.AccountMapper;
import org.example.dto.AccountDTO;
import org.example.util.AccountHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    AccountMapper accountMapper;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView loginView = new ModelAndView("login");
        return loginView;
    }
    @RequestMapping(value="/checkLogin", method = RequestMethod.GET)
    public ModelAndView checkLogin(@RequestParam("username") String username,
                                   @RequestParam("password") String password) {
        ModelAndView loginView = new ModelAndView("login");
        if(accountMapper.checkAccount(username, password)){
            return new ModelAndView(new RedirectView("/Mini-project-springmvc/listEmployee?username=" + username));
        } else {
            loginView.addObject("error", "Invalid username or password");
            return loginView;
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public  ModelAndView register(){
        ModelAndView registerView = new ModelAndView("register");
        return registerView;
    }

    @RequestMapping(value = "/checkRegister", method = RequestMethod.GET)
    public ModelAndView checkRegister(@RequestParam("username") String username,
                                      @RequestParam("password") String password,
                                      @RequestParam("repasssword") String repassword){
        ModelAndView registerView = new ModelAndView("register");
        if(accountMapper.checkExist(username)){
            registerView.addObject("usernameerror", "Username already exists");
            return registerView;
        } else if (!AccountHandler.checkUsername(username)) {
            registerView.addObject("usernameerror", "Username only include number, letters and username's length must be smaller than 45 character");
            return registerView;
        } else if (!Objects.equals(password, repassword)) {
            registerView.addObject("passworderror", "Password does not pass");
            return registerView;
        } else {
            AccountDTO accountDTO = new AccountDTO(username, password);
            accountMapper.insertAccount(accountDTO);
            registerView.addObject("error", "success");
            return registerView;
        }
    }
}