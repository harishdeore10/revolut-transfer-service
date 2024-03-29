package com.revolut.transfer.service;

import com.revolut.transfer.exceptions.ObjectModificationException;
import com.revolut.transfer.model.BankAccount;
import com.revolut.transfer.dto.BankAccountDto;

import java.util.Collection;

/**
 * Right now the proxy service under the {@link BankAccountDto}. Should be used to abstract the presentation layer
 * from the persistence layer
 *
 * TODO: needs to move business logic from BankAccountDto. Validations for example.
 * TODO: Use DI to abstract from persistence layer
 */
public class BankAccountService {
    private static final BankAccountService bas = new BankAccountService();

    public static BankAccountService getInstance() {
        return bas;
    }

    public Collection<BankAccount> getAllBankAccounts() {
        return BankAccountDto.getInstance().getAllBankAccounts();
    }

    public BankAccount getBankAccountById(Long id) {
        return BankAccountDto.getInstance().getBankAccountById(id);
    }

    public void updateBankAccount(BankAccount bankAccount) throws ObjectModificationException {
        BankAccountDto.getInstance().updateBankAccountSafe(bankAccount);
    }

    public BankAccount createBankAccount(BankAccount bankAccount) throws ObjectModificationException {
        return BankAccountDto.getInstance().createBankAccount(bankAccount);
    }
}
