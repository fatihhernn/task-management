package com.temelt.issuemanagement.service;

import com.temelt.issuemanagement.dto.ProjectDto;
import com.temelt.issuemanagement.entity.Project;
import com.temelt.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;



public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getByProjectCode(String projectCode);

    ProjectDto  getByProjectCodeContains(String projectCode);

    ProjectDto getById(Long id);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete(Project project);
}
