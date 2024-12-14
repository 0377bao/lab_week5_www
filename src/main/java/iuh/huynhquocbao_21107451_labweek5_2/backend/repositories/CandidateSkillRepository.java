package iuh.huynhquocbao_21107451_labweek5_2.backend.repositories;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.CandidateSkill;
import iuh.huynhquocbao_21107451_labweek5_2.backend.models.CandidateSkillId;
import iuh.huynhquocbao_21107451_labweek5_2.backend.models.JobSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillId> {
    @Query("SELECT cs FROM CandidateSkill cs WHERE cs.can.id = :id")
    public List<CandidateSkill> findByIdCanId(Long id);
}