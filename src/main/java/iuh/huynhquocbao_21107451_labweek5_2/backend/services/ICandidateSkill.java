package iuh.huynhquocbao_21107451_labweek5_2.backend.services;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.CandidateSkill;

import java.util.List;

public interface ICandidateSkill {

    public List<CandidateSkill> findByIdCanId(Long id);
}
