package com.temelt.issuemanagement.api;

import com.temelt.issuemanagement.dto.ProjectDto;
import com.temelt.issuemanagement.service.implementation.ProjectServiceImp;
import com.temelt.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/versioning")
@Api(value = ApiPaths.ProjectCtrl.CTRL,description = "Project APIs")
public class ProjectVersionedApi {

    //versiyonlama işlemlerinde dto ve servis katmanlarını tekrar revize etmeliyiz

    //get istediği yap, "/versioning/1?versioning=1" diye istek at

    @Autowired
    private ProjectServiceImp projectServiceImp;

    @GetMapping(value = "/{id}",params = "version=1")
    @ApiOperation(value = "Get By ID Operation V1",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getByIdV1(@PathVariable("id") Long id){
        ProjectDto projectDto= projectServiceImp.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @GetMapping(value = "/{id}",params = "version=2")
    @ApiOperation(value = "Get By ID Operation V2",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getByIdV2(@PathVariable("id") Long id){
        ProjectDto projectDto= projectServiceImp.getById(id);
        return ResponseEntity.ok(projectDto);
    }

}
