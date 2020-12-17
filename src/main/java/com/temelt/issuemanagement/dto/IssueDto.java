package com.temelt.issuemanagement.dto;

import com.temelt.issuemanagement.entity.IssueStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDto {

    private Long id;
    private String description;
    private String details;
    private String date;
    private IssueStatus issueStatus;
    private UserDto assignee;
    private ProjectDto project;
}
