package org.top.ordersmvccappexample.model.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.top.ordersmvccappexample.model.entity.User;


import java.util.Collection;
import java.util.Collections;

// класс-сервис для работы с суностью пользователя
public class DbUserDetails implements UserDetails {

    private User dbUser;  // сущность пользователя из БД

    public User getDbUser() {
        return dbUser;
    }

    public void setDbUser(User dbUser) {
        this.dbUser = dbUser;
    }

    // конструктор
    public DbUserDetails(User dbUser) {
        this.dbUser = dbUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (dbUser.getLogin().equals("admin"))
            return Collections.<GrantedAuthority>singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        else
            return Collections.<GrantedAuthority>singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return dbUser.getPassword();
    }

    @Override
    public String getUsername() {
        return dbUser.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
