package iuh.huynhquocbao_21107451_labweek5_2;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Account;
import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Address;
import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Candidate;
import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Role;
import iuh.huynhquocbao_21107451_labweek5_2.backend.repositories.AddressRepository;
import iuh.huynhquocbao_21107451_labweek5_2.backend.repositories.CandidateRepository;
import iuh.huynhquocbao_21107451_labweek5_2.backend.services.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class HuynhQuocBao21107451Labweek52Application {

    public static void main(String[] args) {
        SpringApplication.run(HuynhQuocBao21107451Labweek52Application.class, args);
    }
//    @Autowired
//    private CandidateRepository candidateRepository;
//    @Autowired
//    private AddressRepository addressRepository;
//    @Autowired
//    private AccountService accountService;
//    @Bean
//    CommandLineRunner initData(){
//        return args -> {
//            Random rnd =new Random();
//            for (int i = 1; i < 1000; i++) {
//                Address add = new Address("Quang Trung","HCM", Short.parseShort("7"),
//                        rnd.nextLong(1,1000)+"", rnd.nextInt(70000,80000)+"");
//                addressRepository.save(add);
//                Account acc = new Account("username_"+i,rnd.nextLong(1,1000)+"", Role.CANDIDATE);
//                accountService.save(acc);
//                Candidate can=new Candidate(
//                        LocalDate.of(1998,rnd.nextInt(1,13),rnd.nextInt(1,29)),
//                        "email_"+i+"@gmail.com",
//                        "Name #"+i,
//                        rnd.nextLong(1111111111L,9999999999L)+"",
//                        add,
//                        acc
//                        );
//                candidateRepository.save(can);
//                System.out.println("Added: " +can);
//            }
//        };
//    }
}
