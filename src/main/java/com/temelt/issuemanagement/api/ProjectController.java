package com.temelt.issuemanagement.api;

import com.temelt.issuemanagement.dto.ProjectDto;
import com.temelt.issuemanagement.service.implementation.ProjectServiceImp;
import com.temelt.issuemanagement.util.ApiPaths;
import com.temelt.issuemanagement.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value = "Project APIs")
@Slf4j
public class ProjectController {

    private final ProjectServiceImp projectServiceImp;

    public ProjectController(ProjectServiceImp projectServiceImp){
        this.projectServiceImp=projectServiceImp;
    }


    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Patination Operation",response = ProjectDto.class)
    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable){
        return ResponseEntity.ok(projectServiceImp.getAllPageable(pageable));
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Get By ID Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id){
        log.info("ProjectController -> GetById -> PARAM : "+id);
        log.debug("ProjectController -> GetById -> PARAM : "+id);
        ProjectDto projectDto= projectServiceImp.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project){
       return ResponseEntity.ok(projectServiceImp.save(project));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation",response = ProjectDto.class)
    public  ResponseEntity<ProjectDto> createRepository(@PathVariable(value = "id",required = true) Long id, @Valid @RequestBody ProjectDto project){
        return ResponseEntity.ok(projectServiceImp.update(id,project)) ;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation",response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(projectServiceImp.delete(id));
    }

}
