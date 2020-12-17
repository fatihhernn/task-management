package com.temelt.issuemanagement.service.implementation;

import com.temelt.issuemanagement.entity.Issue;
import com.temelt.issuemanagement.repository.IssueRepository;
import com.temelt.issuemanagement.dto.IssueDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.temelt.issuemanagement.service.IssueService;
import com.temelt.issuemanagement.util.TPage;

import java.util.Arrays;


@Service
public class IssueServiceImpl implements IssueService {


    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    //@Autowired //yazmaya da gerek yok..sen yaznasan da ben inject edecem diyor SPRING -- Best Practice
    public IssueServiceImpl(IssueRepository issueRepository ,ModelMapper modelMapper){
        this.issueRepository=issueRepository;
        this.modelMapper=modelMapper;
    }


    @Override
    public IssueDto save(IssueDto issue) {

        if (issue.getDate()==null){
            throw  new IllegalArgumentException("Issue date cannot be empty");
        }

        //dışardan gelen veriyi içerdeki modele dönüştür, içerdeki modeli de veritabanına kaydettikten sonra, o nesneyi dto ya dönüştürüp geri ver.
        Issue issueDb= modelMapper.map(issue,Issue.class);

        issueDb= issueRepository.save(issueDb);

        return modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {

        //datayı getir
        Page<Issue> data= issueRepository.findAll(pageable);

        TPage page=new TPage<IssueDto>();
        IssueDto[] dtos= modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data,Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(IssueDto issueHistory) {
        return null;
    }
}
