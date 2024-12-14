package iuh.huynhquocbao_21107451_labweek5_2.backend.services.impl;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.JobSkill;
import iuh.huynhquocbao_21107451_labweek5_2.backend.repositories.JobSkillRepository;
import iuh.huynhquocbao_21107451_labweek5_2.backend.services.IJobSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSkillService implements IJobSkill {
    @Autowired
    private JobSkillRepository jobSkillRepository;
    @Override
    public void save(JobSkill jobSkill) {
         jobSkillRepository.save(jobSkill);
    }

    @Override
    public void deleteByJob(Long jobId) {
        jobSkillRepository.deleteByJob(jobId);
    }

    @Override
    public List<JobSkill> findByIdJobId(Long id) {
        return jobSkillRepository.findByIdJobId(id);
    }
}
