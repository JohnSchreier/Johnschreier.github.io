package com.example.Schreier_John_PRedictions_CaseStudy.services;
import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import com.example.Schreier_John_PRedictions_CaseStudy.repository.UserRepository;
import com.example.Schreier_John_PRedictions_CaseStudy.model.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class MyUserDetailsService  {

    @Autowired
    UserRepository userRepository;

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> user = Optional.ofNullable(userRepository.findUserByEmail(email));
//        user.orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
//        return user.map(MyUserDetails::new).get();
//    }


}
