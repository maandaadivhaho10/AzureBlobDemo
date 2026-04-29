package com.blobs.demoblobs.Repository;

import com.blobs.demoblobs.Model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Long> {

}
