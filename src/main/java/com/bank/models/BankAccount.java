package com.bank.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
//Entity Class for Bank Accounts
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    private String accountNo;
    private String bankName;
    private float balance;
    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="bank_account_account_id")
    @JsonManagedReference
    @ToString.Exclude
    private List<BankingService> bankingService;
}
