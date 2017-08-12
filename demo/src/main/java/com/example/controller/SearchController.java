package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.PersonRepository;
import com.example.dao.ProjectRepository;
import com.example.dao.SubjectRepository;
import com.example.model.Person;
import com.example.model.Project;
import com.example.model.Subject;

@Controller
public class SearchController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @RequestMapping("/save")
    public Person save(String name, String college, Integer age, String title, String sex) {
        Person p = personRepository.save(new Person(null, name, age, college, title, sex));
        return p;
    }
    
    @GetMapping("/index")
    public String form(Model model) {
        for(Person p:personRepository.findAll())
        System.out.println(p.getName());
        model.addAttribute("persons", personRepository.findAll());
        model.addAttribute("project", new Project());
        model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("subjects", subjectRepository.findAll());

        return "index";
    }


    //截取request中的参数，找到与参数列表中对应的key并赋值
    //@RequestParam(name="subject")指定request中的subject变量
    @PostMapping("/index")
    public String save(String projectName, String person, String description, 
            @RequestParam(name="subject")String subjectName, String date) {
        Person people = personRepository.findByName(person);
        Subject subject = subjectRepository.findBySubjectName(subjectName);
        Project p = new Project(null, projectName, people, description, subject, date, "待定");
        projectRepository.save(p);
       //model.addAttribute("project", new Project());
        //model.addAttribute("projects", projectRepository.findAll());
        return "redirect:/index";
    }

    @RequestMapping("/q1")
    public List<Person> q1(String college) {
        List<Person> people = personRepository.findAll();
        return people;
    }

    // @RequestMapping("/q2")
    // public Person q2(String name, String college) {
    // Person people = personRepository.findByNameAndCollege(name, college);
    // return people;
    // }
    // @RequestMapping("/q3")
    // public Person q3(String name, String college) {
    // Person people = personRepository.withNameAndCollegeQuery(name, college);
    // return people;
    // }
    // public Person q4(String name, String college) {
    // Person p = personRepository.withNameAndCollegeNamedQuery(name, college);
    // return p;
    // }
    @RequestMapping("/sort")
    public List<Person> sort() {
        List<Person> people = personRepository.findAll(new Sort(Direction.ASC, "age"));
        return people;
    }

    @RequestMapping("/page")
    public Page<Person> page() {
        Page<Person> pagePeople = personRepository.findAll(new PageRequest(1, 2));
        return pagePeople;
    }

}
