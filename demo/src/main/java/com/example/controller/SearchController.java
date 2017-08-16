package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.PersonRepository;
import com.example.dao.ProjectRepository;
import com.example.dao.SubjectRepository;
import com.example.model.Person;
import com.example.model.Project;

@Controller
public class SearchController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    
    @RequestMapping("/index")
    public String index(Model model) {
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
            @RequestParam(name="subject")String subject, String date) {
        System.out.println(person);
        System.out.println(subject);
        Project p = new Project(null, projectName, personRepository.findById(Integer.valueOf(person)), 
                description, subjectRepository.findById(Integer.valueOf(subject)), date, "待定");
        projectRepository.save(p);

        return "redirect:/index";//好像是请求的什么方法就用什么方法请求return的地方
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
