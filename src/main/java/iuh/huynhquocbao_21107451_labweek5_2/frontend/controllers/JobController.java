package iuh.huynhquocbao_21107451_labweek5_2.frontend.controllers;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.*;
import iuh.huynhquocbao_21107451_labweek5_2.backend.services.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private JobSkillService jobSkillService;
    @Autowired
    private CandidateService candidateService;
    @GetMapping("/getAll")
    public String getAllJobs(Model model, @RequestParam("companyname") String companyName) {
//        Company company = companyService.findCompanyByCompName(companyName);
//        model.addAttribute("companyName", company.getCompName());
//        model.addAttribute("companies", companyService.findAll());
//        model.addAttribute("jobs", jobService.findByCompany(company.getId()));
//        model.addAttribute("skills", skillService.findAll());
        Company company = companyService.findCompanyByCompName(companyName);
        model.addAttribute("company", company);
        model.addAttribute("companyName", company.getCompName());
        model.addAttribute("companies", companyService.findAll());
        model.addAttribute("jobs", jobService.findByCompany(company.getId()));
        model.addAttribute("skills", skillService.findAll());
        model.addAttribute("isCompany", true);
        return "companies/companyHome";
//        return "jobs/jobs";
    }

    @PostMapping("/deleteJob")
    public String deleteJob(Model model, @RequestParam("jobid") Long jobId, @RequestParam("companyname") String companyName,
                            @RequestHeader(value = "Referer", required = false) String referer) {
        jobSkillService.deleteByJob(jobId);
        jobService.deleteById(jobId);
        Company company = companyService.findCompanyByCompName(companyName);
        model.addAttribute("company", company);
        model.addAttribute("companyName", company.getCompName());
        model.addAttribute("companies", companyService.findAll());
        model.addAttribute("jobs", jobService.findByCompany(company.getId()));
        model.addAttribute("skills", skillService.findAll());
        model.addAttribute("isCompany", true);
        return "companies/companyHome";
    }

    @PostMapping("/addJob")
    public String addJob(Model model, @RequestParam("companyName") String companyName,
                         @RequestParam("jobdesc") String jobDesc,
                         @RequestParam("jobname") String jobName,
                         @RequestParam("skills")List<String> skills,
                         @RequestParam("levels") List<String> levels,
                         @RequestParam("moreinfs") List<String> moreinfs,
                         @RequestHeader(value = "Referer", required = false) String referer
                         ) {
        Company company = companyService.findCompanyByCompName(companyName);
        Job jobnew = new Job(jobDesc, jobName, company);
        jobService.save(jobnew);
        for(int i = 0; i < skills.size(); i++) {
            JobSkillId jobSkillId = new JobSkillId(jobnew.getId(), Long.parseLong(skills.get(i)));
            JobSkill jobSkill = new JobSkill(jobSkillId, jobnew, skillService.findById(Long.parseLong(skills.get(i))),
                        moreinfs.get(i), SkillLevel.valueOf(levels.get(i)));
            jobSkillService.save(jobSkill);
        }
        model.addAttribute("company", company);
        model.addAttribute("companyName", company.getCompName());
        model.addAttribute("companies", companyService.findAll());
        model.addAttribute("jobs", jobService.findByCompany(company.getId()));
        model.addAttribute("skills", skillService.findAll());
        model.addAttribute("isCompany", true);
        return "companies/companyHome";
    }

    @GetMapping("/getDetail")
    public String getDetail(Model model, @RequestParam("jobid") Long jobId, @RequestParam("isCom") Boolean isCom) {
        Job job = jobService.findById(jobId);
        model.addAttribute("job", job);
        model.addAttribute("jobSkills", jobSkillService.findByIdJobId(job.getId()));
        model.addAttribute("candidates", candidateService.findCandidatesForJob(job.getId()));
        model.addAttribute("isCompany", isCom);
        return "jobs/jobdetail";
    }
    @GetMapping("/getSuitableCandidates")
    public String getSuitableJob(Model model, @RequestParam("jobId") Optional<Long> idcheck) {
        Long id = idcheck.orElse(null);
        model.addAttribute("candidate", candidateService.find(id));
        model.addAttribute("jobs", jobService.findJobsForCandidate(id));
        model.addAttribute("isCompany", false);
        return "candidates/candidateHome";
    }
}
