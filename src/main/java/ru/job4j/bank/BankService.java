package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель банковского сервиса
 * @author Николай Загородников
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение всех пользователей системы с привязанными к ним счетами
     * осуществляется в коллекции типа HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в систему.
     * Пользователю добавляется пустой список счетов.
     * @param user новый пользователь.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из системы.
     * Поиск пользователя осуществляется по паспорту.
     * @param passport паспорт пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет новый банковский счет пользователю.
     * У пользователя могут быть несколько счетов.
     * @param passport паспорт пользователя
     * @param account банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод позволяет найти пользователя по номеру паспорта.
     * @param passport паспорт пользователя
     * @return возвращает пользователя или null если пользователь не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод позволяет найти счет пользователя по номеру паспорта и реквизитам счета.
     * @param passport  паспорт пользователя
     * @param requisite реквизиты счета пользователя
     * @return возвращает счет пользователя или null если счет пользователя не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод позволяет переводить деньги с одного банковского счета на другой.
     * Если счёт не найден или не хватает денег на счёте, с которого переводят,
     * то метод возвращает false.
     *
     * @param sourcePassport  паспорт отправителя
     * @param sourceRequisite      реквизиты счета отправителя
     * @param destinationPassport  паспорт получателя
     * @param destinationRequisite реквизиты счета получателя
     * @param amount               сумма перевода
     * @return возвращает true, если перевод прошел успешно, либо false если
     * счёт не найден или не хватает денег на счёте отправителя.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account source = findByRequisite(sourcePassport, sourceRequisite);
        Account target = findByRequisite(destinationPassport, destinationRequisite);
        if (source != null && target != null && source.getBalance() >= amount) {
            source.setBalance(source.getBalance() - amount);
            target.setBalance(target.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод позволяет получить список всех банковских счетов пользователя
     * @param user пользователь, чьи счета нам необходимо получить
     * @return возвращает список всех банковских счетов пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}