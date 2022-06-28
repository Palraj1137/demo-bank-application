# Hibernate & JPA

## Entities
### User
userId: int <br/>
Name: String <br/>
String: phone; <br/>
String: email; <br/>

### BankAccount
accountId: int <br/>
accountNo: String <br/>
bankName: String <br/>
balance: float <br/>
User user; <br/>
List<BankingService> <br/>

### BankingService
serviceId: int <br/>
BankAccount <br/>
BankingService: Enum(Mobile banking, Internet banking, Debit Card, Credit Card, Cheque book) <br/>
activatedOn: LocalDate <br/>
Active: boolean <br/>

## Entity relationships
User -> BankAccount <br/>
An account can be owned by only one user.  A user can have multiple bank accounts.
 <br/>
BankAccount -> BankingService <br/>
You can activate multiple services in your account like Mobile banking, Internet banking, Debit Card, Credit Card, Cheque book.  

## Specifications
Use MySQL as DB implementationCreate JpaRepositories for User and BankAccount entity <br/>
You can create queries only using JPQL language or by defining your own methods in the JPA repositories

# APIs
## Level 1
Get Account Details: show account details + services activated for the account (/bank-account/{accountId}) <br/>
Get User Details: show user details + accounts for a user (/user/{userId})

## Level 2
Create User (/user) <br/>
Create a bank account: It should persist the bank account details and banking services activated during account opening (/bank-account)

## Level3
Find accounts by service in active state (/bank-account?service={BackingService}) 	 <br/>		
eg. /bank-account?service=CREDIT_CARD
 
# Added Postman collection for testing purposes in repostitory with name BankApplication.postman_collection
 

