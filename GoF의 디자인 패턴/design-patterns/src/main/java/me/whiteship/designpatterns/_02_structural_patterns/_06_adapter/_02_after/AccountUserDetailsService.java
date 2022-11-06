package me.whiteship.designpatterns._02_structural_patterns._06_adapter._02_after;

import me.whiteship.designpatterns._02_structural_patterns._06_adapter._02_after.security.UserDetails;
import me.whiteship.designpatterns._02_structural_patterns._06_adapter._02_after.security.UserDetailsService;

/**
 * 클래스를 바라볼때 "책임"이 있는 객체를 구현하것이니깐 어떤 책임이 있는지 보도록 하기(책임 이 본질임!)
 */
public class AccountUserDetailsService implements UserDetailsService {

    private AccountService accountService;

    public AccountUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 여기서 UserDetail 인터페이스로 반환함!
     * @param username
     * @return
     */
    @Override
    public UserDetails loadUser(String username) {
        return new AccountUserDetails(accountService.findAccountByUsername(username));
    }

}
