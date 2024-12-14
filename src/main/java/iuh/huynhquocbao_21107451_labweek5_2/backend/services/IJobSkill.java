package iuh.huynhquocbao_21107451_labweek5_2.backend.services;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.JobSkill;

import java.util.List;

public interface IJobSkill {
    public void save(JobSkill jobSkill);
    public void deleteByJob(Long jobId);
    public List<JobSkill> findByIdJobId(Long id);
}
