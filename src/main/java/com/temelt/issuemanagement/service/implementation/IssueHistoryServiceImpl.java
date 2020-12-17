package com.temelt.issuemanagement.service.implementation;

import com.temelt.issuemanagement.entity.IssueHistory;
import com.temelt.issuemanagement.repository.IssueHistoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.temelt.issuemanagement.service.IssueHistoryService;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository){
        this.issueHistoryRepository=issueHistoryRepository;
    }

    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        if (issueHistory.getId()==null){
            throw new IllegalArgumentException("Issue History cannot be null");
        }
        return issueHistoryRepository.save(issueHistory);
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return true;
    }
}
