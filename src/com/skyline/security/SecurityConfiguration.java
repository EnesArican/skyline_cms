package com.skyline.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.skyline.service.security.MyUserDetailsServiceImpl;
 
@Configuration
@EnableWebSecurity
@Order(2)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
	private final MyUserDetailsServiceImpl userDetailsService;
	private final TokenAuthenticationService tokenAuthenticationService;
	
	
	 public SecurityConfiguration() {
	    super(true);
	    this.userDetailsService = new MyUserDetailsServiceImpl();
	    tokenAuthenticationService = new TokenAuthenticationService("tooManySecrets", userDetailsService);
	 }
	
	
	
	
	@Bean
	public UserDetailsService userDetailsService() {
	    return new MyUserDetailsServiceImpl();
	};
   
	@Autowired
	DataSource dataSource;
 
  //  @Autowired
  //  public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
     // 	 auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
   // }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http.authorizeRequests().antMatchers("/", "/list")
                .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
                .antMatchers("/newuser/**", "/delete-user-*").access("hasRole('ADMIN')").antMatchers("/edit-user-*")
                .access("hasRole('ADMIN') or hasRole('DBA')").and().formLogin().loginPage("/login")
                .loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password").and()
                .rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
                .tokenValiditySeconds(86400).and().csrf().and().exceptionHandling().accessDeniedPage("/Access_Denied");*/
    	
    
    	http.authorizeRequests().antMatchers("/login").permitAll()
			.antMatchers("/", "/*").access("hasRole('ROLE_USER')").and()
			.formLogin().and()
    	
    	
    	
    	// Custom Token based authentication based on the header previously given to the client
        .addFilterBefore(new StatelessAuthenticationFilter(tokenAuthenticationService),
                UsernamePasswordAuthenticationFilter.class);
    
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public TokenAuthenticationService tokenAuthenticationService() {
        return tokenAuthenticationService;
    }
    
    
}





