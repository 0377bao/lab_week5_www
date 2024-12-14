package iuh.huynhquocbao_21107451_labweek5_2.frontend.controllers;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Account;
import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Candidate;
import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Company;
import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Role;
import iuh.huynhquocbao_21107451_labweek5_2.backend.services.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private JobService jobService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private CandidateSkillService candidateSkillService;
    @PostMapping("/login")
    public String login(Model model, @RequestParam("username") String userName, @RequestParam("password") String passWord) {
         Account account = accountService.findAccountByUserName(userName);
         if(account == null) {
                model.addAttribute("message", "Account not found");
                return "homes/messageErrorLogin";
         } else if (!account.getPassWord().equals(passWord)) {
             model.addAttribute("message", "Password is incorrect");
             return "homes/messageErrorLogin";
         }
         else {
             switch(account.getRole()) {
                 case COMPANY:
                 {
                     Company company = companyService.findCompanyByUserName(account.getUserName());
                     model.addAttribute("company", company);
                     model.addAttribute("companyName", company.getCompName());
                     model.addAttribute("companies", companyService.findAll());
                     model.addAttribute("jobs", jobService.findByCompany(company.getId()));
                     model.addAttribute("skills", skillService.findAll());
                     model.addAttribute("isCompany", true);
                     return "companies/companyHome";
                 }
                 case CANDIDATE:
                 {
                     Candidate cd = candidateService.findCandidateByUserName(account.getUserName());
                     model.addAttribute("jobs", jobService.findAll());
                     model.addAttribute("skills", candidateSkillService.findByIdCanId(cd.getId()));
                     model.addAttribute("candidate", cd);
                     model.addAttribute("isCompany", false);
                     return "candidates/candidateHome";
                 }
             }
         }
         return "homes/messageErrorLogin";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        model.asMap().remove("candidate");
        model.asMap().remove("isCompany");
        model.asMap().remove("company");
        model.asMap().remove("companyName");
        model.asMap().remove("companies");
        model.asMap().remove("jobs");
        model.asMap().remove("skills");
        model.asMap().remove("isCompany");
        return "index";
    }
}
