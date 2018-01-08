package application.service.security;

import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AppFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest req = (HttpServletRequest) request;
            String researchId = req.getHeader("current_research"); //获取当前课题ID
            if (StringUtils.hasText(researchId))
                req.getSession().setAttribute("RESEARCH_ID", researchId);
            chain.doFilter(request, response);
        }
    }
}
