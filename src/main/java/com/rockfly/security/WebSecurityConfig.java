package com.rockfly.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// import com.aditi.SpringBlog.util.constants.Priviliges;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class WebSecurityConfig {

private static final String[] WHITELIST= {

"/",

"/login",

};
@Bean
public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
}

@SuppressWarnings({ "removal" })
@Bean

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // http.cors(AbstractHttpConfigurer::disable);
	    // http.csrf(AbstractHttpConfigurer::disable);

    http

            .authorizeHttpRequests((authz) -> authz

                            // .requestMatchers("/api/admin/**").hasRole("ADMIN")

                            .requestMatchers(WHITELIST)

                            .permitAll()
                            .requestMatchers("/profile/**").authenticated()
                            .requestMatchers("/admin/**").hasRole("ADMIN")
                            .requestMatchers("/editor/**").hasAnyRole("ADMIN","EDITOR")
                            .anyRequest()
                            .authenticated()
                            

            ).formLogin(form -> {
                try {
                    form.loginPage("/login").loginProcessingUrl("/login")
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/", true)
                            .failureUrl("/login?error")
                            .permitAll().and().logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                            .logoutSuccessUrl("/").deleteCookies("JSESSIONID")
                            .invalidateHttpSession(true)).rememberMe(me -> me.rememberMeParameter("remember-me"))
                            .httpBasic(withDefaults())
                        ;
                } catch (Exception e) {
                        e.printStackTrace();
                }
            });
            // .httpBasic(Customizer.withDefaults())
            // .csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/db-console/**")))
            // .headers(headers -> headers.frameOptions().disable());
        
        return http.build();

    }



}
