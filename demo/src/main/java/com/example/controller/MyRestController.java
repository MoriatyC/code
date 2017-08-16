package com.example.controller;

import static com.example.utils.Judge.youngJudge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.PersonRepository;
import com.example.dao.ProjectRepository;
import com.example.model.Person;
import com.example.model.Project;

@RestController
public class MyRestController {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    PersonRepository   personRepository;
    @RequestMapping("/autojudge")
    public String autoJudg(Integer id) {
        Project project = projectRepository.findById(id);
        if (youngJudge(project)) {
            return "OK";
        }
        else {
            return "FAIL";
        }
        
    }
    
 
    @GetMapping("/q1")
    public List<Person> q1() {
        List<Person> people = personRepository.findAll();
        return people;
    }
    
    @DeleteMapping("/index/{projectId}")
    public String deleteProject(@PathVariable("projectId") int id) {
        if (Integer.valueOf(id) == null) {
            return "FAIL";
        }
        projectRepository.delete(Integer.valueOf(id));
        return  "OK";
    }
    

}
