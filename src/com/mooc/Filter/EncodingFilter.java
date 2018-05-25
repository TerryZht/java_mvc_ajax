package com.mooc.Filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter{
    private String config=null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig.getInitParameter("encoding");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            servletRequest.setCharacterEncoding(this.config);

            filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
