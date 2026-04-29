package com.blobs.demoblobs.Controller;


import com.blobs.demoblobs.Model.Issue;

import com.blobs.demoblobs.Service.IssueService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Issue")
public class IssueController {
    private final IssueService issueService;
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }


    @PostMapping("/add")
    public  void addIssue(@RequestBody Issue issue,Long id){
        issueService.addIssue(issue,id);
    }
    @PostMapping("/get")
    public Issue getUser(@PathVariable Long id){
        return issueService.findById(id);
    }
}
