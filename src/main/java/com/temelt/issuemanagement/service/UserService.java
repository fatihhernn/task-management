package com.temelt.issuemanagement.service;

import com.temelt.issuemanagement.entity.Issue;
import com.temelt.issuemanagement.entity.IssueHistory;
import com.temelt.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UserService {

    User save(User user);

    User getById(Long id);

    Page<User> getAllPageable(Pageable pageable);

    User findByUsername(String username);

    boolean delete(User user);
}
