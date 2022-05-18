package io.security.corespringsecurity.controller.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @GetMapping(value="/login")
    public String login() throws Exception {
        return "/login";
    }

    /**
     * GET 방식의 logout 을 생성할때
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @GetMapping(value="/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 인증 객체는 SecurityContextHolder 안에 있다.
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // 인증 객체 존재할 경우
        if (auth != null) {
            // 로그아웃 수행
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/login"; // 로그인 화면으로 리다이렉트
    }
}
