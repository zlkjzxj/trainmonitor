package com.zlkj.trainmonitor.confs;

import com.zlkj.trainmonitor.services.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserService userDetailService;

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }
//    @Autowired
//    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("111111").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("111111").roles("ADMIN");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/services/**").and().sessionManagement()
                .maximumSessions(10)
                .maxSessionsPreventsLogin(true)
                .expiredUrl("/")
                .and().invalidSessionUrl("/")
                .and()
                .authorizeRequests()
//                .antMatchers("/chat").permitAll()
                .mvcMatchers("/static/**").permitAll()
                .anyRequest().authenticated()
                .and().
                formLogin()
                .loginPage("/")
                .usernameParameter("username")
                .passwordParameter("password")
                .successForwardUrl("/index")
                .loginProcessingUrl("/login")
                .failureForwardUrl("/")
                .permitAll()
                .and().
                logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/loginOut.jsp")
                .permitAll()
                .and().
                headers()
                .and().csrf().disable();

    }
}
