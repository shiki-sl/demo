package com.shiki.config;

import com.shiki.shiro.AdminRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @author 孙磊
 */
@Configuration
public class ShiroConfig {


    /**
     * 权限管理，配置Realm的管理认证
     */
    @Bean("securityManager")
//    @DependsOn("adminRealm")
    public DefaultWebSecurityManager securityManager(@Qualifier("adminRealm") AdminRealm realms) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realms);
        return securityManager;
    }


    /**
     * filter工厂，设置对应的过滤条件和跳转条件
     */
    @Bean
//    @DependsOn("securityManager")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
//        设置安全管理器
        shiroFilter.setSecurityManager(securityManager);
//        配置登录url
        shiroFilter.setLoginUrl("/login.html");
        shiroFilter.setUnauthorizedUrl("/index.html");
        shiroFilter.setSuccessUrl("/Article management.html");

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>(16);


        filterChainDefinitionMap.put("/user/hello", "anon");
        filterChainDefinitionMap.put("/user/login", "anon");
        filterChainDefinitionMap.put("/layui/**", "anon");

        filterChainDefinitionMap.put("/logout", "authc");
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilter;
    }


    /**
     * 在容器中注册自己的验证方式
     */
    @Bean
    public AdminRealm getRealm() {
        return new AdminRealm();
    }


    @Bean
//    @DependsOn("securityManager")
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
