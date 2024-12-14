package iuh.huynhquocbao_21107451_labweek5_2.backend.repositories;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("SELECT j FROM Job j WHERE j.company.id = :id")
    List<Job> findByCompany(Long id);
    @Query("SELECT j FROM Job j " +
            "WHERE (SELECT COUNT(js.skill.id) FROM JobSkill js WHERE js.job.id = j.id) = " +
            "      (SELECT COUNT(js.skill.id) FROM JobSkill js " +
            "       WHERE js.job.id = j.id AND js.skill.id IN " +
            "             (SELECT cs.skill.id FROM CandidateSkill cs WHERE cs.can.id = :candidateId))")
    List<Job> findJobsForCandidate(Long candidateId);
}