package org.koreait.controllers.commons;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/error")
@RequiredArgsConstructor
public class ErrorController {

    private final HttpServletResponse response;

    @GetMapping("/401")
    public String error401() throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "접근 권한이 없습니다.");

        return "error/401";
    }
}
