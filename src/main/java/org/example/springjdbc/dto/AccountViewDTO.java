package org.example.springjdbc.dto;

import org.example.springjdbc.entity.Account;

public record AccountViewDTO() {

    public static AccountViewDTO fromEntity(Account account) {
        return new AccountViewDTO();
    }
}