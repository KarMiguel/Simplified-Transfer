package org.example.controllers;

import org.apache.coyote.Response;
import org.example.domain.transaction.Transaction;
import org.example.dtos.TransactionDTO;
import org.example.service.TransactionService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionService  transactionService;

    @PostMapping
    ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
        Transaction newTransaction = this.transactionService.creatTransection(transaction);;

        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }
}
