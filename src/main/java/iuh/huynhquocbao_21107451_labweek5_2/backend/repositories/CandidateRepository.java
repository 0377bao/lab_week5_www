package iuh.huynhquocbao_21107451_labweek5_2.backend.repositories;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Candidate;
import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query("SELECT c FROM Candidate c WHERE c.account.userName = :userName")
    Candidate findCandidateByUserName(String userName);
    @Query("SELECT c FROM Candidate c " +
            "WHERE NOT EXISTS (" +
            "    SELECT js.skill.id FROM JobSkill js " +
            "    WHERE js.job.id = :jobId AND js.skill.id NOT IN " +
            "          (SELECT cs.skill.id FROM CandidateSkill cs WHERE cs.can.id = c.id)" +
            ")")
    List<Candidate> findCandidatesForJob(Long jobId);

}