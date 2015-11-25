package ca.etsmtl.log720.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

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

    private String getUsersByUsernameQuery() {
        return "select username, pwd as password" +
                "from users" +
                "where username = ?";
    }

    private String getAuthoritiesByUsernameQuery() {
        return "select username, role as authority" +
                "from users" +
                "inner join user_roles on users.id = user_roles.user_id" +
                "inner join roles on user_roles.role_id = roles.id" +
                "where username = ?";
    }
}
