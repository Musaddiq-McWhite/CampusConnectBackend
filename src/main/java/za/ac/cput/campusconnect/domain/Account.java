package za.ac.cput.campusconnect.domain;

import jakarta.persistence.*;

import java.util.Objects;

/**S
 * Account.java
 * Class: Account
 * Author: Musaddiq McWhite (219369151)
 * Completion date:
 */

@Entity
public class Account {
    @Id
    private String accountNumber;
    private String username;
    private String password;
    private String userType;

    public Account() {}

    public Account(Builder builder) {
        this.accountNumber = builder.accountNumber;
        this.username = builder.username;
        this.password = builder.password;
        this.userType = builder.userType;
    }
    public String getAccountNumber() {return accountNumber;}

    public String getUsername() {return username;}

    public String getPassword() {return password;}

    public String getUserType() {return userType;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber) && Objects.equals(username, account.username) && Objects.equals(password, account.password) && Objects.equals(userType, account.userType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, username, password, userType);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }

    public static class Builder {
        private String accountNumber;
        private String username;
        private String password;
        private String userType;

        public Builder setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setUserType(String userType) {
            this.userType = userType;
            return this;
        }

        public Builder copy(Account account) {
            this.accountNumber = account.accountNumber;
            this.username = account.username;
            this.password = account.password;
            this.userType = account.userType;
            return this;
        }

        public Account build() {return new Account(this);}
    }

}
