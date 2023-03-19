package com.example.management.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.management.pojo.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class LoginStaff implements UserDetails {

    private Staff staff;
    private List<String> permissions;

    public LoginStaff(Staff staff, List permissions) {
        this.staff = staff;
        this.permissions = permissions;
    }

    public LoginStaff(Staff staff) {
        this.staff = staff;
    }

    @JSONField(serialize = false)
    private  List<SimpleGrantedAuthority>  authorities;

    //获取权限信息
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities!=null){
            return authorities;
        }
        authorities = permissions.stream().
                map(SimpleGrantedAuthority::new).
                collect(Collectors.toList());

        return authorities;
    }

    @Override
    public String getPassword() {
        return staff.getStaffPassword();
    }

    @Override
    public String getUsername() {
        return staff.getStaffAccount();
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

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
