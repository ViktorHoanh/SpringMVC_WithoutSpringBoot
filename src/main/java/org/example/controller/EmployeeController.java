package org.example.controller;

import org.example.dao.EmployeeMapper;
import org.example.dao.ProjectMapper;
import org.example.dao.TeamMapper;
import org.example.dto.EmployeeDTO;
import org.example.entity.Employee;
import org.example.entity.EmployeeModel;
import org.example.entity.Project;
import org.example.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    TeamMapper teamMapper;

    @RequestMapping(value="/listEmployee", method = RequestMethod.GET)
    public ModelAndView listEmployee(@RequestParam("username") String username) {
        ModelAndView listEmployeeView = new ModelAndView("listEmployee");
        List<EmployeeDTO> employeeDTOList = employeeMapper.getAllEmployeeDTO();
        List<Team> teamList = teamMapper.getAllTeam();
        List<Project> projectList = projectMapper.getAllProject();
        listEmployeeView.addObject("listEmployee", employeeDTOList);
        listEmployeeView.addObject("teamList", teamList);
        listEmployeeView.addObject("projectList", projectList);
        listEmployeeView.addObject("username", username);
        return listEmployeeView;
    }

    @RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
    public ModelAndView addEmployee(@ModelAttribute("employeeModel") EmployeeModel employeeModel,
                                    @RequestParam("username") String username){
        employeeMapper.insertEmployee(employeeModel, username);
        return new ModelAndView(new RedirectView("/Mini-project-springmvc/listEmployee?username=" + username));
    }

    @RequestMapping(value = "/deleteEmployees", method = RequestMethod.GET)
    public ModelAndView deleteEmployees(@RequestParam("ids") List<Integer> employeeIDs,
                                    @RequestParam("username") String username){
        for (Integer employeeID : employeeIDs) {
            System.out.println(employeeID);
        }
        return new ModelAndView(new RedirectView("/Mini-project-springmvc/listEmployee?username=" + username));
    }
}