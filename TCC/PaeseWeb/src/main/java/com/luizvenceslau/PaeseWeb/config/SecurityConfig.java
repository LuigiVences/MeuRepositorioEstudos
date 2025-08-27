package com.luizvenceslau.PaeseWeb.config;

import com.luizvenceslau.PaeseWeb.exception.CustomAuthenticationFailureHandler;
import com.luizvenceslau.PaeseWeb.exception.CustomLogoutSucessHandler;
import com.luizvenceslau.PaeseWeb.security.UserAuthenticatedService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Value("${application.security.jwt.public-key-path}")
    private RSAPublicKey key;

    @Value("${application.security.jwt.private-key-path}")
    private RSAPrivateKey priv;

    private final UserAuthenticatedService userAuthenticatedService;
    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    private final CustomLogoutSucessHandler customLogoutSucessHandler;

    public SecurityConfig(UserAuthenticatedService userAuthenticatedService,
                          CustomAuthenticationFailureHandler customAuthenticationFailureHandler,
                          CustomLogoutSucessHandler customLogoutSucessHandler) {
        this.userAuthenticatedService = userAuthenticatedService;
        this.customAuthenticationFailureHandler = customAuthenticationFailureHandler;
        this.customLogoutSucessHandler = customLogoutSucessHandler;

    }

    /*

    Bean para o caso de transformar a aplicação em uma API Rest, com autenticação via JWT

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        auth ->
                                auth.requestMatchers("/authenticate").permitAll()
                                        .anyRequest().authenticated()
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS ))
                .httpBasic(Customizer.withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
        return http.build();
    }
     */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/password", "/css/**", "/js/**", "/assets/**")
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .failureHandler(customAuthenticationFailureHandler)
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessHandler(customLogoutSucessHandler)
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                )
                .userDetailsService(userAuthenticatedService);
        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*

    Os Beans abaixo só serão usados caso o sistema venha utilizar JWT

    @Bean
    JwtDecoder jwtDecoder(){
        return NimbusJwtDecoder.withPublicKey(key).build();
    }

    @Bean
    JwtEncoder jwtEncoder(){
        var jwk = new RSAKey.Builder(key).privateKey(priv).build();
        var jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwks);
    }

     */

}
