package com.temelt.issuemanagement.api;


import com.temelt.issuemanagement.dto.IssueDto;
import com.temelt.issuemanagement.service.implementation.IssueServiceImpl;
import com.temelt.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

    private final IssueServiceImpl issueServiceImp;

    public IssueController(IssueServiceImpl issueServiceImp){
        this.issueServiceImp=issueServiceImp;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id",required = true)  Long id){
        IssueDto issueDto= issueServiceImp.getById(id);
        return ResponseEntity.ok(issueDto);
    }

    @PostMapping
    public ResponseEntity<IssueDto> createIssue(@Valid @RequestBody IssueDto issue){
       return ResponseEntity.ok(issueServiceImp.save(issue));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<IssueDto> createRepository(@PathVariable(value = "id",required = true) Long id, @Valid @RequestBody IssueDto issue){
        return ResponseEntity.ok(issueServiceImp.update(id,issue));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(issueServiceImp.delete(id));
    }

}
