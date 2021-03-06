package com.aktarulahsan.erp.core.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * Password encoder.
	 * @author Mindbowser | md.aktarulahsan@gmail.com
     * @since Apr 28, 2020
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	/**
	 * Authication manager bean.
	 * @author Mindbowser | md.aktarulahsan@gmail.com
     * @since Apr 28, 2020
	 */
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	
	/**
	 * CROS configuration.
	 * @author Mindbowser | md.aktarulahsan@gmail.com
     * @since Apr 28, 2020
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.cors().and()
		.csrf().disable().exceptionHandling()
				.authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
				.and().authorizeRequests()
				.antMatchers("/api/**")
				.authenticated()
				.and()
				.httpBasic().and().headers().frameOptions().disable()
		.and().cors().configurationSource(configurationSource());
	}

	/**
	 * Authenticator manager builder.
	 * @author Mindbowser | md.aktarulahsan@gmail.comantMatchers
     * @since Apr 28, 2020
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
//	@Bean
//	CorsConfigurationSource corsConfigurationSource()
//	{
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins("*");
//		configuration.setAllowedMethods(Arrays.asList("GET","POST"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}

	private CorsConfigurationSource configurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("*");
		config.setAllowCredentials(true);
		config.addAllowedHeader("X-Requested-With");
		config.addAllowedHeader("Content-Type");
		config.addAllowedMethod(HttpMethod.POST);
		source.registerCorsConfiguration("/**", config);
		return source;
	}


}
