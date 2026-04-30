package com.blobs.demoblobs.Controller;


import com.blobs.demoblobs.Model.Issue;

import com.blobs.demoblobs.Service.IssueService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/Issue")
public class IssueController {
    private final IssueService issueService;
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }


    @PostMapping("/add/{id}")
    public  void addIssue(  @RequestParam String description,@PathVariable Long id,@RequestParam("file") MultipartFile file){
        issueService.addIssue(description,id,file);
    }
    @PostMapping("/get")
    public Issue getUser(@PathVariable Long id){
        return issueService.findById(id);
    }
}
