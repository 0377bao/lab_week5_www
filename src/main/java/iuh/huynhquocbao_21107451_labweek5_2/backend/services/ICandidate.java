package iuh.huynhquocbao_21107451_labweek5_2.backend.services;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Candidate;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICandidate {
    public List<Candidate> findAll();
    public Page<Candidate> findPaging(int pageNo, int pageSize, String sortBy,
                                      String sortDirection);
    public Candidate find(Long id);
    public Candidate findCandidateByUserName(String userName);
    List<Candidate> findCandidatesForJob(Long jobId);
}
