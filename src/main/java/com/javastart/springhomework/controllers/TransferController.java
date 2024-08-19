package com.javastart.springhomework.controllers;

import com.javastart.springhomework.controllers.dto.TransferRequestDTO;
import com.javastart.springhomework.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
    private final TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }


    @PostMapping("/transfers")
    public Object transfer(@RequestBody TransferRequestDTO transferRequestDTO){
        return transferService.transfer(transferRequestDTO.getAccountIdFrom(), transferRequestDTO.getAccountIdTo(),
                transferRequestDTO.getAmount());
    }
}
