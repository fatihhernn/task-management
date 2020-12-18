package com.temelt.issuemanagement.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.temelt.issuemanagement.dto.ProjectDto;
import com.temelt.issuemanagement.entity.Project;
import com.temelt.issuemanagement.repository.ProjectRepository;
import com.temelt.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.temelt.issuemanagement.service.ProjectService;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {


    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImp(ProjectRepository projectRepository, ModelMapper modelMapper){
        this.projectRepository=projectRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {

        Project projectCheck=projectRepository.getByProjectCode(project.getProjectCode());

        if (projectCheck!=null) {
            throw new IllegalArgumentException("Project Code already exist");
        }
        Project p= modelMapper.map(project,Project.class);
        p=projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public ProjectDto getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p= projectRepository.getOne(id);
        return modelMapper.map(p,ProjectDto.class);
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data=projectRepository.findAll(pageable);
        TPage<ProjectDto> response=new TPage<ProjectDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(),ProjectDto[].class)));
        return response;
    }

    @Override
    public Boolean delete(Project project) {
        projectRepository.delete(project);
        return true;
    }
}
