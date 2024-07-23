package com.bank.Service;

import com.bank.Config.MyUserDetails;
import com.bank.DB.User;
import com.bank.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String UserName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(UserName);

        return user.map(MyUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException(UserName+"Такого пользователя не существует"));
    }
}
