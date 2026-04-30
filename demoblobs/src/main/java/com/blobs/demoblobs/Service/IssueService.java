package com.blobs.demoblobs.Service;


import com.blobs.demoblobs.BlobService.BlobService;
import com.blobs.demoblobs.Model.ImageResponse;
import com.blobs.demoblobs.Model.Issue;
import com.blobs.demoblobs.Model.User;
import com.blobs.demoblobs.Repository.ImageRepository;
import com.blobs.demoblobs.Repository.IssueRepository;
import com.blobs.demoblobs.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class IssueService {

    private final IssueRepository issueRepository;

    private final UserRepository userRepository;
     private  final  BlobService blobService;
     private  final ImageRepository imageRepository;

    public IssueService(IssueRepository issueRepository, UserRepository userRepository, BlobService blobService, ImageRepository imageRepository) {
        this.issueRepository = issueRepository;
        this.userRepository = userRepository;
        this.blobService = blobService;
        this.imageRepository = imageRepository;
    }

    public void addIssue(String description, Long id, MultipartFile file){
        User newUser=userRepository.findById(id).orElseThrow();
        String[]  results;
        try {
            results=blobService.upload(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Issue newIssue=new Issue();
        ImageResponse newImage=new ImageResponse();
        newImage.setFileName(results[0]);
        newImage.setPath(results[1]);
        newIssue.setDescription(description);
        newIssue.setUser(newUser);
        newUser.getIssues().add(newIssue);
        newImage.setIssue(newIssue);
        newIssue.setImageResponse(newImage);
        issueRepository.save(newIssue);
    }

    public Issue findById(Long id) {
        return issueRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
