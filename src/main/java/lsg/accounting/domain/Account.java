package lsg.accounting.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@JsonPropertyOrder({ "accountId", "accountName", "accountCurrency" })
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long accountId;
    @NotBlank(message = "accountName cannot be empty")
    private String accountName;
    @NotBlank(message = "accountCurrency cannot be empty")
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
