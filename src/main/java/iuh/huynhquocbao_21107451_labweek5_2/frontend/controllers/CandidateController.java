package iuh.huynhquocbao_21107451_labweek5_2.frontend.controllers;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Candidate;
import iuh.huynhquocbao_21107451_labweek5_2.backend.repositories.CandidateSkillRepository;
import iuh.huynhquocbao_21107451_labweek5_2.backend.services.impl.CandidateService;
import iuh.huynhquocbao_21107451_labweek5_2.backend.services.impl.CandidateSkillService;
import iuh.huynhquocbao_21107451_labweek5_2.backend.services.impl.CompanyService;
import iuh.huynhquocbao_21107451_labweek5_2.backend.services.impl.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private JobService jobService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CandidateSkillService candidateSkillService;
    @GetMapping("/getAll")
    public String getAllCandidates(Model model, @RequestParam("compId") Long compId) {
        model.addAttribute("company", companyService.find(compId));
        model.addAttribute("isCompany", true);
        model.addAttribute("candidates", candidateService.findAll());
        return "candidates/candidates";
    };

    @GetMapping("/getAllJob")
    public String getAllJob(Model model, @RequestParam("candidateId") Optional<Long> idcheck) {
        Long id = idcheck.orElse(null);
        model.addAttribute("candidate", candidateService.find(id));
        model.addAttribute("jobs", jobService.findAll());
        model.addAttribute("skills", candidateSkillService.findByIdCanId(id));
        model.addAttribute("isCompany", false);
        return "candidates/candidateHome";
    }

    @GetMapping("/getSuitableJob")
    public String getSuitableJob(Model model, @RequestParam("candidateId") Optional<Long> idcheck) {
        Long id = idcheck.orElse(null);
        model.addAttribute("candidate", candidateService.find(id));
        model.addAttribute("jobs", jobService.findJobsForCandidate(id));
        model.addAttribute("skills", candidateSkillService.findByIdCanId(id));
        model.addAttribute("isCompany", false);
        return "candidates/candidateHome";
    }
    @GetMapping("/getPaginated")
    public String showCandidateListPaging(Model model,
                                          @RequestParam("page") Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size,
                                          @RequestParam("compId") Long compId) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Candidate> candidatePage= candidateService.findPaging(
                currentPage - 1,pageSize,"id","asc");
        model.addAttribute("company", companyService.find(compId));
        model.addAttribute("candidatePage", candidatePage);
        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "candidates/candidates-paging";
    }
}
