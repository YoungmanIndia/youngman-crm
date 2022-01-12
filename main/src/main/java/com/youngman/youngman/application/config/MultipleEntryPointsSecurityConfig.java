package com.youngman.youngman.application.config;

import com.youngman.youngman.admin.WebUserServices;
import com.youngman.youngman.security.ServicesAuthenticationSuccessHandler;
import com.youngman.youngman.security.UserAuthenticationSuccessHandler;
import com.youngman.youngman.services.CredentialsService;
import com.youngman.youngman.services.CredentialsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Main entry point for com.youngman.youngman.security - admin - customer - auth - private - services
 */
@Configuration
@EnableWebSecurity
public class MultipleEntryPointsSecurityConfig {

    private static final String API_VERSION = "/api";

//    @Bean
//    public AuthenticationTokenFilter authenticationTokenFilter() {
//        return new AuthenticationTokenFilter();
//    }

    @Bean
    public CredentialsService credentialsService() {
        return new CredentialsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserAuthenticationSuccessHandler userAuthenticationSuccessHandler() {
        return new UserAuthenticationSuccessHandler();
    }

    @Bean
    public ServicesAuthenticationSuccessHandler servicesAuthenticationSuccessHandler() {
        return new ServicesAuthenticationSuccessHandler();
    }

//    @Bean
//    public CustomerFacade customerFacade() {
//        return new com.Youngman.shop.store.controller.customer.facade.CustomerFacadeImpl();
//    }



    /**
     * shop / customer
     *
     * @author dur9213
     *
     */
//    @Configuration
//    @Order(1)
//    public static class UserConfigurationAdapter extends WebSecurityConfigurerAdapter {
//
//        @Bean("userAuthenticationManager")
//        @Override
//        public AuthenticationManager authenticationManagerBean() throws Exception {
//            return super.authenticationManagerBean();
//        }
//
//        @Autowired
//        private UserDetailsService customerDetailsService;
//
//        public UserConfigurationAdapter() {
//            super();
//        }
//
//        @Override
//        public void configure(WebSecurity web) {
//            web.ignoring().antMatchers("/");
//            web.ignoring().antMatchers("/crm");
//            web.ignoring().antMatchers("/customer");
//            web.ignoring().antMatchers("/admin");
//            web.ignoring().antMatchers("/error");
//            web.ignoring().antMatchers("/resources/**");
//            web.ignoring().antMatchers("/static/**");
//            web.ignoring().antMatchers("/WEB-INF/**");
//            web.ignoring().antMatchers("/services/public/**");
//        }
//
//
//        @Override
//        public void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(customerDetailsService);
//        }
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .antMatcher("/crm/**")
//                    .csrf().disable()
//                    .authorizeRequests()
//                    .antMatchers("/crm/").permitAll()
//                    .antMatchers("/crm/**").permitAll()
//                    .antMatchers("/crm/login*").permitAll()
//                    .antMatchers("/crm/logout*").permitAll()
//                    .antMatchers("/crm/login*").hasRole("AUTH_USER")
//                    .antMatchers("/crm/denied*").hasRole("AUTH_USER")
//                    .antMatchers("/crm/**").hasRole("AUTH_USER")
//                    .anyRequest().authenticated()
//                    .and()
//                    .httpBasic()
//                    .authenticationEntryPoint(shopAuthenticationEntryPoint())
//                    .and()
//                    .logout()
//                    .logoutUrl("/crm/logout")
//                    .logoutSuccessUrl("/crm/")
//                    .invalidateHttpSession(true)
//                    .deleteCookies("JSESSIONID")
//
//                    .invalidateHttpSession(false)
//                    .and()
//                    .exceptionHandling().accessDeniedPage("/crm/");
//
//        }
//
//        @Bean
//        public AuthenticationEntryPoint shopAuthenticationEntryPoint() {
//            BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
//            entryPoint.setRealmName("crm-realm");
//            return entryPoint;
//        }
//
//    }


//    @Configuration
//    @Order(2)
//    public static class CustomerConfigurationAdapter extends WebSecurityConfigurerAdapter {
//
//        @Bean("customerAuthenticationManager")
//        @Override
//        public AuthenticationManager authenticationManagerBean() throws Exception {
//            return super.authenticationManagerBean();
//        }
//
//        @Autowired
//        private UserDetailsService customerDetailsService;
//
//        public CustomerConfigurationAdapter() {
//            super();
//        }
//
//        @Override
//        public void configure(WebSecurity web) {
//            web.ignoring().antMatchers("/");
//            web.ignoring().antMatchers("/crm");
//            web.ignoring().antMatchers("/customer");
//            web.ignoring().antMatchers("/admin");
//            web.ignoring().antMatchers("/error");
//            web.ignoring().antMatchers("/resources/**");
//            web.ignoring().antMatchers("/static/**");
//            web.ignoring().antMatchers("/WEB-INF/**");
//            web.ignoring().antMatchers("/services/public/**");
//        }
//
//
//        @Override
//        public void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(customerDetailsService);
//        }
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .antMatcher("/customer/**")
//                    .csrf().disable()
//                    .authorizeRequests()
//                    .antMatchers("/customer/").permitAll()
//                    .antMatchers("/customer/**").permitAll()
//                    .antMatchers("/customer/login*").permitAll()
//                    .antMatchers("/customer/logout*").permitAll()
//                    .antMatchers("/customer/login*").hasRole("AUTH_CUSTOMER")
//                    .antMatchers("/customer/denied*").hasRole("AUTH_CUSTOMER")
//                    .antMatchers("/customer/**").hasRole("AUTH_CUSTOMER")
//                    .anyRequest().authenticated()
//                    .and()
//                    .httpBasic()
//                    .authenticationEntryPoint(shopAuthenticationEntryPoint())
//                    .and()
//                    .logout()
//                    .logoutUrl("/customer/logout")
//                    .logoutSuccessUrl("/customer/")
//                    .invalidateHttpSession(true)
//                    .deleteCookies("JSESSIONID")
//
//                    .invalidateHttpSession(false)
//                    .and()
//                    .exceptionHandling().accessDeniedPage("/customer/");
//
//        }
//
//        @Bean
//        public AuthenticationEntryPoint shopAuthenticationEntryPoint() {
//            BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
//            entryPoint.setRealmName("customer-realm");
//            return entryPoint;
//        }
//
//    }

    /**
     * services api v0
     * @deprecated
     *
     */
    @Configuration
    @Order(3)
    public static class ServicesApiConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        private WebUserServices userDetailsService;

        @Autowired
        private ServicesAuthenticationSuccessHandler servicesAuthenticationSuccessHandler;

        public ServicesApiConfigurationAdapter() {
            super();
        }

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/services/**")
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/services/public/**").permitAll()
                    .antMatchers("/services/private/**").hasRole("AUTH")
                    .anyRequest().authenticated()
                    .and().httpBasic().authenticationEntryPoint(servicesAuthenticationEntryPoint())
                    .and().formLogin()
                    .successHandler(servicesAuthenticationSuccessHandler);

        }

        @Bean
        public AuthenticationEntryPoint servicesAuthenticationEntryPoint() {
            BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
            entryPoint.setRealmName("rest-customer-realm");
            return entryPoint;
        }

    }


    @Configuration
    @Order(4)
    public static class AdminConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        private WebUserServices userDetailsService;

        @Autowired
        private UserAuthenticationSuccessHandler userAuthenticationSuccessHandler;

        public AdminConfigurationAdapter() {
            super();
        }

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService);
        }

        @Override
        public void configure(WebSecurity web) {
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/admin/**")
                    .authorizeRequests()
                    .antMatchers("/admin/login*").permitAll()
                    .antMatchers("/admin/resources/**").permitAll()
                    .antMatchers("/admin/layout/**").permitAll()
                    .antMatchers("/admin/denied*").permitAll()
                    .antMatchers("/admin/unauthorized*").permitAll()
                    .antMatchers("/admin/users/resetPassword*").permitAll()
                    .antMatchers("/admin/").hasRole("AUTH")
                    .antMatchers("/admin/**").hasRole("AUTH")
                    .antMatchers("/admin/**").hasRole("AUTH")
                    .antMatchers("/admin/users/resetPasswordSecurityQtn*").permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .httpBasic()
                    .authenticationEntryPoint(adminAuthenticationEntryPoint())
                    .and()
                    .formLogin().usernameParameter("username").passwordParameter("password")
                    .loginPage("/admin/login.html")
                    .loginProcessingUrl("/admin/performUserLogin")
                    .successHandler(userAuthenticationSuccessHandler)
                    .failureUrl("/admin/login.html?login_error=true")
                    .and()
                    .csrf().disable()
                    .logout().logoutUrl("/admin/logout").logoutSuccessUrl("/admin/home.html")
                    .invalidateHttpSession(true).and().exceptionHandling().accessDeniedPage("/admin/denied.html");


        }

        @Bean
        public AuthenticationEntryPoint adminAuthenticationEntryPoint() {
            BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
            entryPoint.setRealmName("admin-realm");
            return entryPoint;
        }

    }

    /**
     * api - private
     *
     * @author dur9213
     *
     */
//    @Configuration
//    @Order(5)
//    public static class UserApiConfigurationAdapter extends WebSecurityConfigurerAdapter {
//
//        @Autowired
//        private AuthenticationTokenFilter authenticationTokenFilter;
//
//        @Autowired
//        JWTAdminServicesImpl jwtUserDetailsService;
//
//        @Bean("jwtAdminAuthenticationManager")
//        @Override
//        public AuthenticationManager authenticationManagerBean() throws Exception {
//            AuthenticationManager mgr = super.authenticationManagerBean();
//            return mgr;
//        }
//
//
//
//        public UserApiConfigurationAdapter() {
//            super();
//        }
//
//        @Override
//        public void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(jwtUserDetailsService)
//                    .and()
//                    .authenticationProvider(authenticationProvider());
//        }
//
//        @Override
//        public void configure(WebSecurity web) {
//            web.ignoring().antMatchers("/swagger-ui.html");
//        }
//
//
//        /**
//         * Admin user api
//         */
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .antMatcher(API_VERSION + "/private/**")
//                    .authorizeRequests()
//                    .antMatchers(API_VERSION + "/private/login*").permitAll()
//                    .antMatchers(API_VERSION + "/private/refresh").permitAll()
//                    .antMatchers(HttpMethod.OPTIONS, API_VERSION + "/private/**").permitAll()
//                    .antMatchers(API_VERSION + "/private/**").hasRole("AUTH")
//                    .anyRequest().authenticated()
//                    .and()
//                    .httpBasic().authenticationEntryPoint(apiAdminAuthenticationEntryPoint())
//                    .and()
//                    .addFilterAfter(authenticationTokenFilter, BasicAuthenticationFilter.class)
//                    .csrf().disable();
//
//        }
//
//        @Bean
//        public AuthenticationProvider authenticationProvider() {
//            JWTAdminAuthenticationProvider provider = new JWTAdminAuthenticationProvider();
//            provider.setUserDetailsService(jwtUserDetailsService);
//            return provider;
//        }
//
//        @Bean
//        public AuthenticationEntryPoint apiAdminAuthenticationEntryPoint() {
//            BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
//            entryPoint.setRealmName("api-admin-realm");
//            return entryPoint;
//        }
//
//    }



    /**
     * customer api
     *
     * @author dur9213
     *
     */
//    @Configuration
//    @Order(6)
//    public static class CustomeApiConfigurationAdapter extends WebSecurityConfigurerAdapter {
//
//        @Autowired
//        private AuthenticationTokenFilter authenticationTokenFilter;
//
//        @Autowired
//        private UserDetailsService jwtCustomerDetailsService;
//
//        public CustomeApiConfigurationAdapter() {
//            super();
//        }
//
//        @Bean("jwtCustomerAuthenticationManager")
//        @Override
//        public AuthenticationManager authenticationManagerBean() throws Exception {
//            return super.authenticationManagerBean();
//        }
//
//        @Override
//        public void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(jwtCustomerDetailsService);
//        }
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//
//                    .antMatcher(API_VERSION + "/auth/**")
//                    .authorizeRequests()
//                    .antMatchers(API_VERSION + "/auth/refresh").permitAll()
//                    .antMatchers(API_VERSION + "/auth/login").permitAll()
//                    .antMatchers(API_VERSION + "/auth/register").permitAll()
//                    .antMatchers(HttpMethod.OPTIONS, API_VERSION + "/auth/**").permitAll()
//                    .antMatchers(API_VERSION + "/auth/**")
//                    .hasRole("AUTH_CUSTOMER").anyRequest().authenticated()
//                    .and()
//                    .httpBasic()
//                    .authenticationEntryPoint(apiCustomerAuthenticationEntryPoint()).and().csrf().disable()
//                    .addFilterAfter(authenticationTokenFilter, BasicAuthenticationFilter.class);
//
//        }
//
//        @Bean
//        public AuthenticationProvider authenticationProvider() {
//            JWTCustomerAuthenticationProvider provider = new JWTCustomerAuthenticationProvider();
//            provider.setUserDetailsService(jwtCustomerDetailsService);
//            return provider;
//        }
//
//        @Bean
//        public AuthenticationEntryPoint apiCustomerAuthenticationEntryPoint() {
//            BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
//            entryPoint.setRealmName("api-customer-realm");
//            return entryPoint;
//        }
//
//    }



}