package com.test.spring;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SecSecurityConfig.class, WebConfig.class);
        registerProxyFilter(servletContext, AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME);
        servletContext.addListener(new ContextLoaderListener(context));
        context.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet(AbstractDispatcherServletInitializer.DEFAULT_SERVLET_NAME,
                new DispatcherServlet(context));
        servlet.addMapping("/api/*");
        servlet.setLoadOnStartup(1);
    }

    private void registerProxyFilter(ServletContext servletContext, String name) {
        FilterRegistration.Dynamic securityFilter = servletContext.addFilter(name, DelegatingFilterProxy.class);
        securityFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}