package iuh.huynhquocbao_21107451_labweek5_2.frontend.controllers;
import iuh.huynhquocbao_21107451_labweek5_2.backend.services.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send-email")
    public String switchPageSendEmail(Model model, @RequestParam("email") String email) {
        model.addAttribute("email", email);
        return "email/sendEmail";
    }

    @PostMapping("/send-email")
    public String sendEmail(Model model, @RequestParam String to, @RequestParam String subject, @RequestParam String text) {
        boolean result = emailService.sendEmail(to, subject, text);
        String message = "";
        if(result) {
            message = "Email has been sent!";
        }
        else {
            message = "Failed to send email!";
        }
        model.addAttribute("message", message);
        return "email/resultSendMail";
    }
}

