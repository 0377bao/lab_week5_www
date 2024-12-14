package iuh.huynhquocbao_21107451_labweek5_2.backend.services;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Skill;

import java.util.List;

public interface ISkill {
    public List<Skill> findAll();
    public Skill findById(Long id);
}
