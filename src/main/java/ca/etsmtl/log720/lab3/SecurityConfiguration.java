package ca.etsmtl.log720.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(getUsersByUsernameQuery())
                .authoritiesByUsernameQuery(getAuthoritiesByUsernameQuery());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/dossiers/{\\d+}/infractions").access("hasAuthority('utilisateur')")
                .antMatchers("/dossiers/**").access("hasAuthority('utilisateur') or hasAuthority('administrateur')")
                .antMatchers("/infractions/**").access("hasAuthority('utilisateur') or hasAuthority('administrateur')")
                .and().formLogin().loginPage("/auth/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/auth/denied");
    }

    private String getUsersByUsernameQuery() {
        return "select username, pwd, enabled " +
                "from users " +
                "where username = ?";
    }

    private String getAuthoritiesByUsernameQuery() {
        return "select username, role " +
                "from users " +
                "inner join user_roles on users.id = user_roles.user_id " +
                "inner join roles on user_roles.role_id = roles.id " +
                "where username = ?";
    }
}
