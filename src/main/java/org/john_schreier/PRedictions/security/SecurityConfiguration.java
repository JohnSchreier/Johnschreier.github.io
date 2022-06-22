package org.john_schreier.PRedictions.security;

import org.john_schreier.PRedictions.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Qualifier("userServiceImpl")
    @Autowired
    UserService userDetailsService;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
//    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/login","/Create_User", "/register","/static/**", "/javascript/**","/css/**","/images/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/errorPage")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/Home_Page")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll();


//
//        http
//                .authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/register").permitAll()
//                .antMatchers("/errorrr").permitAll()
//                .antMatchers("/Home_Page").authenticated()
//                .antMatchers("/Choose_A_Coach").authenticated()
//                .antMatchers("/Profile_Page").authenticated()
//                .antMatchers("/Half-Marathon_Predictor").authenticated()
//                .antMatchers("/Marathon_Predictor").authenticated()
//                .anyRequest().authenticated()
//                .and().csrf().disable()
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/errorrr") // error
//                .defaultSuccessUrl("/Home_Page", true)
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login").and().exceptionHandling();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(getPasswordEncoder());
        return auth;
    }



    //@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/Home_Page").authenticated()
//                .antMatchers("/Choose_A_Coach").authenticated()
//                .antMatchers("/Profile_Page").authenticated()
//                .antMatchers("/Half-Marathon_Predictor").authenticated()
//                .antMatchers("/Marathon_Predictor").authenticated()
//                .anyRequest().permitAll()
//                    .and()
//                    .formLogin()
//                    .loginPage("/")
//                    .defaultSuccessUrl("/Home_Page", true)
//                    .permitAll()
//                        .and()
//                        .logout()
//                        .invalidateHttpSession(true)
//                        .clearAuthentication(true)
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .logoutSuccessUrl("/")
//                        .permitAll();
//    }



}













