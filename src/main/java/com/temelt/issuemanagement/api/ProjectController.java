package com.temelt.issuemanagement.api;

import com.temelt.issuemanagement.dto.ProjectDto;
import com.temelt.issuemanagement.service.implementation.ProjectServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectServiceImp projectServiceImp;

    public ProjectController(ProjectServiceImp projectServiceImp){
        this.projectServiceImp=projectServiceImp;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id){
        ProjectDto projectDto= projectServiceImp.getById(id);
        return ResponseEntity.ok(projectDto);//http 200 isteğ ile dönüp dtoyu veriyoruz
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project){
       return ResponseEntity.ok(projectServiceImp.save(project));
    }


}
