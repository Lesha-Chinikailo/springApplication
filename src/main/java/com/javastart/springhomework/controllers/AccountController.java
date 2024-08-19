package com.javastart.springhomework.controllers;

import com.javastart.springhomework.controllers.dto.AccountRequestDTO;
import com.javastart.springhomework.controllers.dto.AccountResponseDTO;
import com.javastart.springhomework.controllers.dto.BillRequestDTO;
import com.javastart.springhomework.entity.Bill;
import com.javastart.springhomework.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts/{accountId}")
    public AccountResponseDTO getById(@PathVariable Long accountId) {
        return new AccountResponseDTO(accountService.getAccountById(accountId));
    }

    @PostMapping("/accounts")
    public Long create(@RequestBody AccountRequestDTO accountRequestDTO){
        return accountService.save(accountRequestDTO.getName(),
                accountRequestDTO.getEmail(),
                accountRequestDTO.getBills().stream()
                        .map(billRequestDTO -> new Bill(billRequestDTO.getAmount(), billRequestDTO.isDefault()))
                        .collect(Collectors.toList()));

    }
}
