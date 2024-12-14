package iuh.huynhquocbao_21107451_labweek5_2.backend.services;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Candidate;
import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Job;
import iuh.huynhquocbao_21107451_labweek5_2.backend.models.JobSkill;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IJob {
    public void save(Job job);
    public List<Job> findAll();
    public List<Job> findByCompany(Long id);
    public void deleteById(Long id);
    public Job findById(Long id);

    public List<Job> findJobsForCandidate(Long candidateId);
}
