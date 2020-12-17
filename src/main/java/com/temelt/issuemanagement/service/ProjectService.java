package com.temelt.issuemanagement.service;

import com.temelt.issuemanagement.entity.IssueHistory;
import com.temelt.issuemanagement.entity.Project;
import com.temelt.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProjectService {

    Project save(Project project);

    List<Project> getByProjectCode(String projectCode);

    List<Project>  getByProjectCodeContains(String projectCode);

    Project getById(Long id);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete(Project project);
}
