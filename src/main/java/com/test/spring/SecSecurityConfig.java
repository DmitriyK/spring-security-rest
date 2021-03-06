package com.test.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan("com.test.security")
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Autowired
    private RestAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler;
    @Bean
    SimpleUrlAuthenticationFailureHandler myFailureHandler() {
        return new SimpleUrlAuthenticationFailureHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/api*//**").authenticated().and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint);
        http.formLogin().loginProcessingUrl("/j_spring_security_check").usernameParameter("j_username")
                .passwordParameter("j_password").successHandler(mySuccessHandler).failureHandler(myFailureHandler());//.permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER").and()
                .withUser("admin").password("admin").roles("USER", "ADMIN");
    }*/
}
