package web.config.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            if (role.getAuthority().equals("ADMIN")) {
                httpServletResponse.sendRedirect("/admin/all");
                return;
            } else if (role.getAuthority().equals("USER")) {
                httpServletResponse.sendRedirect("/user");
                return;
            } else {
                httpServletResponse.sendRedirect("/login");
                return;
            }
        }
    }

}