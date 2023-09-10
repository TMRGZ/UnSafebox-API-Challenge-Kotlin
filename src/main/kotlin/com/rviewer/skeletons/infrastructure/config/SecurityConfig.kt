package com.rviewer.skeletons.infrastructure.config

import com.rviewer.skeletons.domain.service.SafeboxService
import kotlinx.coroutines.reactor.mono
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
open class SecurityConfig {

    @Bean
    open fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain =
        http.csrf(ServerHttpSecurity.CsrfSpec::disable)
            .authorizeExchange {
                it.pathMatchers(HttpMethod.POST, "/safebox").permitAll()
                it.pathMatchers("/v3/api-docs/**", "/swagger-ui.html", "/webjars/swagger-ui/**").permitAll()
                it.anyExchange().authenticated()
            }
            .httpBasic(Customizer.withDefaults())
            .build()


    @Bean
    open fun userDetailsService(safeboxService: SafeboxService): ReactiveUserDetailsService =
        ReactiveUserDetailsService {
            mono {
                safeboxService.getSafebox(it)?.let { safebox ->
                    User(safebox.name, safebox.password, emptyList())
                }
            }
        }
}