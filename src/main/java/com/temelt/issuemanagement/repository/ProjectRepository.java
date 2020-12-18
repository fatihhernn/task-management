package com.temelt.issuemanagement.repository;

import com.temelt.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//spring 2 den sonra bunu koymaya gerek kalmadı
public interface ProjectRepository extends JpaRepository<Project,Long> {

    Project getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> findAll(Pageable projectCode);

    List<Project> findAll(Sort sort);
}
