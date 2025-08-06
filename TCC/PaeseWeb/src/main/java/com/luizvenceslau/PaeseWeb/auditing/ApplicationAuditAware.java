package com.luizvenceslau.PaeseWeb.auditing;

import com.luizvenceslau.PaeseWeb.model.entities.OrganizationalUnit;
import com.luizvenceslau.PaeseWeb.model.entities.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class ApplicationAuditAware implements AuditorAware<User> {

    @Override
    public Optional<User> getCurrentAuditor() {
        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();
        if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken
        ) {
            return Optional.empty();
        }

        User userPrincipal = (User) authentication.getPrincipal();

        if (userPrincipal instanceof User user) {
            return Optional.of(userPrincipal);
        }
        return Optional.empty();
    }
}
