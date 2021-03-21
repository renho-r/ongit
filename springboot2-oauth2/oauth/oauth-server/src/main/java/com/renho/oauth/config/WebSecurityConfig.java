package com.renho.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**","/resources/**");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        String[] proUris = new String[]{"/nauth", "/login", "/oauth/*"};
//        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =
//                http.formLogin().loginPage("/login")
//                        //.loginProcessingUrl("/authentication/form")
//                        .and()
//                        .authorizeRequests();
//        for (String url : proUris) {
//            registry.antMatchers(url).permitAll();
//        }
//        registry.anyRequest().authenticated()
//                .and()
//                .csrf().disable();

        http
            .authorizeRequests()
            .antMatchers("/login","/logout.do").permitAll()
            .antMatchers("/**").authenticated()
            .and()
            .formLogin()
            .loginProcessingUrl("/login.do")
            .usernameParameter("username")
            .passwordParameter("password")
            .loginPage("/login")
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout.do"))
            .and()
            .userDetailsService(userDetailsServiceBean());
    }
}
