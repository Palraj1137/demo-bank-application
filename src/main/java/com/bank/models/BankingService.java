package com.bank.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
//Entity Class for Banking Services
public class BankingService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;
    @ManyToOne
    @JoinColumn(name = "bank_account_account_id")
    @JsonBackReference
    private BankAccount bankAccount;
    @Enumerated(EnumType.STRING)
    private BankingServices bankingServices;
    private LocalDate activatedOn;
    private boolean active;
}
