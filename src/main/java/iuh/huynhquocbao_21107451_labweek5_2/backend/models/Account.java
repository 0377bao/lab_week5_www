package iuh.huynhquocbao_21107451_labweek5_2.backend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "account")
public class Account {
    public Account(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;
    @Column(name = "pass_word", nullable = false)
    private String passWord;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Account(String userName, String passWord, Role role) {
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }
}
