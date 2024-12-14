package iuh.huynhquocbao_21107451_labweek5_2.backend.services.impl;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Skill;
import iuh.huynhquocbao_21107451_labweek5_2.backend.repositories.SkillRepository;
import iuh.huynhquocbao_21107451_labweek5_2.backend.services.ISkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService implements ISkill {
    @Autowired
    private SkillRepository skillRepository;
    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Skill findById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }
}
