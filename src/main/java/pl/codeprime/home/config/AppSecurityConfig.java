/**
 * 
 */
package pl.codeprime.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author MOwsians
 *
 */
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	 

	    // roles admin allow to access /admin/**
	    // roles user allow to access /user/**
	    // custom 403 access denied handler
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http.csrf().disable()
	                .authorizeRequests()
						.antMatchers("/", "/home", "/about", "/test", "/test/*", "/login", "/api/**").permitAll()
						.antMatchers("/admin/**").hasAnyRole("ADMIN")
						.antMatchers("/user/**").hasAnyRole("USER")
						.anyRequest().authenticated()
	                .and()
	                .formLogin().loginPage("/index.html").permitAll()
					.and().logout().permitAll()
					.and() .exceptionHandling();
	    }

	    // create two users, admin and user
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

	        auth.inMemoryAuthentication()
	                .withUser("user").password("password").roles("USER")
	                .and()
	                .withUser("admin").password("password").roles("ADMIN")
	                .and()
	                .withUser("as").password("password").roles("ADMIN")
			        .and()
		            .withUser("mat").password("password").roles("ADMIN");
	    }
	

}
