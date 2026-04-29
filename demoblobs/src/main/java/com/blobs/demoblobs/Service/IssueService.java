package com.blobs.demoblobs.Service;


import com.blobs.demoblobs.Model.Issue;
import com.blobs.demoblobs.Model.User;
import com.blobs.demoblobs.Repository.IssueRepository;
import com.blobs.demoblobs.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IssueService {

    private final IssueRepository issueRepository;

    private final UserRepository userRepository;

    public IssueService(UserRepository userRepository, IssueRepository issueRepository) {
        this.userRepository = userRepository;
        this.issueRepository = issueRepository;
    }

    public void addIssue(Issue issue, Long id){
        User newUser=userRepository.findById(id).orElseThrow();
        Issue newIssue=new Issue();
        newIssue.setDescription(issue.getDescription());
        newIssue.setUser(newUser);
        newUser.getIssues().add(issue);
        issueRepository.save(newIssue);
    }

    public Issue findById(Long id) {
        return issueRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
