package my.zjm.spring.boot.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author jiangmingzhou
 */
@Configuration @EnableWebSecurity public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    @Override protected void configure(HttpSecurity http) throws Exception {
        /*
            设置'/','/home','/login','/logout'地址访问无限制；其余地址均需要授权访问。
         */
        http.authorizeRequests().antMatchers("/", "/home").permitAll().and().authorizeRequests().anyRequest()
                .authenticated().and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
    }

    @Override protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser(USERNAME)
                .password(passwordEncoder().encode(PASSWORD)).roles("USER");
    }

    //    @Bean @Override public UserDetailsService userDetailsService() {
    //        /*
    //        User.withDefaultPasswordEncoder() can still be used for demos,
    //        you don't have to worry if that's what you're doing - even if
    //        it's deprecated - but in production, you shouldn't have a plain
    //        text password in your source code.
    //         */
    //        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
    //                .build();
    //
    //        return new InMemoryUserDetailsManager(user);
    //    }

    @Bean public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
