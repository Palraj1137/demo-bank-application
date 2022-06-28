package com.bank.controllers;


import com.bank.models.BankAccount;
import com.bank.models.BankingService;
import com.bank.models.User;
import com.bank.services.BankAccountServiceImpl;
import com.bank.services.BankingServiceImpl;
import com.bank.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Rest controller class to implement all the HTTP methods
@RestController
public class BankController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private BankAccountServiceImpl bankAccountServiceImpl;

    @Autowired
    private BankingServiceImpl bankingServiceImpl;

    //Getting all the available users from database(OPTIONAL)
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userServiceImpl.getAllUsers();
    }

    //Getting user details and all available accounts details to the user  by using user id
    @GetMapping("/user/{userId}")
    @ResponseBody
    public Map<User,List<BankAccount>> getUserByUserId(@PathVariable("userId") int userId) {
        Map<User, List<BankAccount>> userAndAccountDetailsByUserId = new HashMap<>();
        userAndAccountDetailsByUserId.put(userServiceImpl.getUserById(userId),bankAccountServiceImpl.getAllAccountsByUserId(userId));
        return userAndAccountDetailsByUserId;
    }

    //Creating the user
    @PostMapping("/user")
    public Map<String, String> saveUser(@RequestBody User user){
        userServiceImpl.createUser(user);
        Map<String, String> response = new HashMap<>();
        response.put("Status: 200", "New User Created");
        return response;
    }

    //Getting all the available accounts from database(OPTIONAL)
    @GetMapping("/bank-accounts")
    public List<BankAccount> getAllAccounts(){
        return bankAccountServiceImpl.getAllAccounts();
    }

    //Getting account details and available services to that account by using the account id
    @GetMapping("/bank-account/{accountId}")
    public BankAccount getAccountByAccountId(@PathVariable("accountId") int accountId){
        return bankAccountServiceImpl.getAccountByAccountId(accountId);
    }

    //Creating the account and banking services
    @PostMapping("/bank-account")
    public Map<String, String> createBankAccount(@RequestBody BankAccount bankAccount){
        bankAccountServiceImpl.createAccount(bankAccount);
        Map<String, String> response = new HashMap<>();
        response.put("Status: 200", "New Account Created");
        return response;
    }

    //Creating banking services(OPTIONAL)
    @PostMapping("/banking-service")
    public Map<String, String> createBankingServices(@RequestBody BankingService bankingService){
        bankingServiceImpl.saveBankingServices(bankingService);
        Map<String, String> response = new HashMap<>();
        response.put("Status: 200", "New Services Activated");
        return response;
    }

    //Getting accounts by using the banking service name
    @GetMapping("/bank-account")
    public List getAccountByService(@RequestParam(required = false, name = "service") String service){
        System.out.println("Service name : "+ service);
        return bankAccountServiceImpl.getAccountsByService(service);
    }

}
