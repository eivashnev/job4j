package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private Map<User, List<Account>> bank = new HashMap<>();

    public void addUser(User user) {
        bank.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        bank.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        User user = findUserByPassport(passport);
        if (user != null && bank.get(user).indexOf(account) == -1) {
            bank.get(user).add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        if (null != findUserByPassport(passport)) {
            bank.get(findUserByPassport(passport)).remove(account);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        return bank.get(findUserByPassport(passport));
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                  String dstPassport, String dstRequisite,
                                  double amount) {
        boolean result = false;
        Account srcAcc = findAccount(srcPassport, srcRequisite);
        Account dstAcc = findAccount(dstPassport, dstRequisite);
        if (srcAcc != null && dstAcc != null && srcAcc.getValue() > amount) {
            srcAcc.setValue(srcAcc.getValue() - amount);
            dstAcc.setValue(dstAcc.getValue() + amount);
            result = true;
        }
        return result;
    }

    public User findUserByPassport(String passport) {
        User result = null;
        for (User user : bank.keySet()) {
            if (passport.equals(user.getPassport())) {
                result = user;
            }
        }
        return result;
    }

    public Account findAccount(String passport, String requisites) {
        Account result = null;
        User user = findUserByPassport(passport);
        if (user != null) {
            for (Account account : bank.get(user)) {
                if (requisites.equals(account.getRequisites())) {
                    result = account;
                }
            }
        }
        return result;
    }
}
