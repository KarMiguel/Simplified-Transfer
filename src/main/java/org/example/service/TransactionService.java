package org.example.service;

import org.example.domain.transaction.Transaction;
import org.example.domain.user.User;
import org.example.dtos.TransactionDTO;
import org.example.repository.TransactionRepository;
import org.example.repository.UserRepository;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository repository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private NotificationService notificationService;

    public Transaction creatTransection(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender,transaction.value());

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());


        sender.setBalance(sender.getBalance() - transaction.value());;
        receiver.setBalance(sender.getBalance() + transaction.value());

        this.repository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);

        this.notificationService.sendNotification(sender,"Transação realizada com sucesso");

        this.notificationService.sendNotification(receiver,"Transação recebida com sucesso");

        return newTransaction;
    }

}
