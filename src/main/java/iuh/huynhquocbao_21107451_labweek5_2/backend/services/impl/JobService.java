package iuh.huynhquocbao_21107451_labweek5_2.backend.services.impl;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Candidate;
import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Job;
import iuh.huynhquocbao_21107451_labweek5_2.backend.repositories.CandidateRepository;
import iuh.huynhquocbao_21107451_labweek5_2.backend.repositories.JobRepository;
import iuh.huynhquocbao_21107451_labweek5_2.backend.services.ICandidate;
import iuh.huynhquocbao_21107451_labweek5_2.backend.services.IJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService implements IJob {
    @Autowired
    private JobRepository jobRepository;

    @Override
    public void save(Job job) {
        jobRepository.save(job);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public List<Job> findByCompany(Long id) {
        return jobRepository.findByCompany(id);
    }

    @Override
    public void deleteById(Long id) {
        jobRepository.deleteById(id);
    }

    @Override
    public Job findById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public List<Job> findJobsForCandidate(Long candidateId) {
        return jobRepository.findJobsForCandidate(candidateId);
    }
}
