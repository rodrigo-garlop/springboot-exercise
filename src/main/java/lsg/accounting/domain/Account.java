package lsg.accounting.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;

@Entity
@JsonPropertyOrder({ "accountId", "accountName", "accountCurrency" })
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long accountId;
    private String accountName;
    private String accountCurrency;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getUserId() {
        return user.getUserId();
    }

}
