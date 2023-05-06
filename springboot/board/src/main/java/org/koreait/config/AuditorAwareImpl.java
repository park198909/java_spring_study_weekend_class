package org.koreait.config;

import org.koreait.models.user.UserInfo;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        Long userNo = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UserInfo) {
            UserInfo userInfo = (UserInfo)auth.getPrincipal();
            userNo = userInfo.getUserNo();
        }
        
        return Optional.ofNullable(userNo); // null을 허용하는 userNo를 반환
    }
}
