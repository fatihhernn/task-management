package com.temelt.issuemanagement.service.implementation;

import com.temelt.issuemanagement.entity.Project;
import com.temelt.issuemanagement.repository.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.temelt.issuemanagement.service.ProjectService;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {


    private final ProjectRepository projectRepository;

    public ProjectServiceImp(ProjectRepository projectRepository){
        this.projectRepository=projectRepository;
    }

    @Override
    public Project save(Project project) {

        if (project.getProjectCode()==null) {
            throw new IllegalArgumentException("Project Code cannot be null");
        }

        return projectRepository.save(project);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return projectRepository.getByProjectCode(projectCode);
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return projectRepository.getByProjectCodeContains(projectCode);
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {

        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        projectRepository.delete(project);
        return true;
    }
}
