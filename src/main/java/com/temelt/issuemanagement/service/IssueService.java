package com.temelt.issuemanagement.service;

import com.temelt.issuemanagement.dto.IssueDto;
import org.springframework.data.domain.Pageable;
import com.temelt.issuemanagement.util.TPage;


public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(Long issueId);

    IssueDto update(Long id, IssueDto issue);
}
