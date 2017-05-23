package isteklifsistemi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import isteklifsistemi.model.User;
import isteklifsistemi.repository.UserRepository;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userServiceBean;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/herkeseacik").permitAll()
                .antMatchers("/api/v1/users/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().httpBasic()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                User user = userServiceBean.findOneByEmail(email);

                if (user == null) {
                    throw new UsernameNotFoundException("user not found");
                }

//                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole());
                GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
                return new AuthenticatedUser(
                        user.getEmail(),
                        user.getPasswordHashed(),
                        Collections.singletonList(authority),
                        user);
            }
        }).passwordEncoder(new BCryptPasswordEncoder());
    }

    public class AuthenticatedUser extends org.springframework.security.core.userdetails.User {
        private User user;

        public AuthenticatedUser(String username, String password, Collection<? extends GrantedAuthority> authorities, User user) {
            super(username, password, authorities);
            this.user = user;
        }

        public AuthenticatedUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
            super(username, password, authorities);
        }

        public AuthenticatedUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
            super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        }

        public User getUser() {
            return user;
        }
    }

}
