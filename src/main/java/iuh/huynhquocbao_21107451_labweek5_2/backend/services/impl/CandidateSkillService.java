package iuh.huynhquocbao_21107451_labweek5_2.backend.services.impl;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.CandidateSkill;
import iuh.huynhquocbao_21107451_labweek5_2.backend.repositories.CandidateSkillRepository;
import iuh.huynhquocbao_21107451_labweek5_2.backend.services.ICandidateSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateSkillService implements ICandidateSkill {
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;

    @Override
    public List<CandidateSkill> findByIdCanId(Long id) {
        return candidateSkillRepository.findByIdCanId(id);
    }
}
