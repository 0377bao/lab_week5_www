package iuh.huynhquocbao_21107451_labweek5_2.backend.services.impl;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Candidate;
import iuh.huynhquocbao_21107451_labweek5_2.backend.repositories.CandidateRepository;
import iuh.huynhquocbao_21107451_labweek5_2.backend.services.ICandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateService implements ICandidate {
    @Autowired
    private CandidateRepository candidateRepository;
    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Page<Candidate> findPaging(int pageNo, int pageSize, String sortBy,
                                      String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return candidateRepository.findAll(pageable);
    }

    @Override
    public Candidate find(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    @Override
    public Candidate findCandidateByUserName(String userName) {
        return candidateRepository.findCandidateByUserName(userName);
    }

    @Override
    public List<Candidate> findCandidatesForJob(Long jobId) {
        return candidateRepository.findCandidatesForJob(jobId);
    }
}
