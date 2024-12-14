package iuh.huynhquocbao_21107451_labweek5_2.backend.repositories;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.JobSkill;
import iuh.huynhquocbao_21107451_labweek5_2.backend.models.JobSkillId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillId> {
    @Modifying
    @Transactional
    @Query("delete from JobSkill js where js.id.jobId = :jobId")
    public void deleteByJob(Long jobId);
    @Query("SELECT js FROM JobSkill js WHERE js.job.id = :id")
    public List<JobSkill> findByIdJobId(Long id);
}