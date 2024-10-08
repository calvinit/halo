package run.halo.app.core.user.service;

import reactor.core.publisher.Mono;
import run.halo.app.infra.exception.EmailVerificationFailed;

/**
 * Email verification service to handle email verification.
 *
 * @author guqing
 * @since 2.11.0
 */
public interface EmailVerificationService {

    /**
     * Send verification code by given username.
     *
     * @param username username to verify email must not be blank
     * @param email email to send must not be blank
     */
    Mono<Void> sendVerificationCode(String username, String email);

    /**
     * Verify email by given username and code.
     *
     * @param username username to verify email must not be blank
     * @param code code to verify email must not be blank
     * @throws EmailVerificationFailed if send failed
     */
    Mono<Void> verify(String username, String code);

    /**
     * Send verification code.
     * The only difference is use email as username.
     *
     * @param email email to send must not be blank
     */
    Mono<Void> sendRegisterVerificationCode(String email);

    /**
     * Verify email by given code.
     *
     * @param email email as username to verify email must not be blank
     * @param code code to verify email must not be blank
     * @throws EmailVerificationFailed if send failed
     */
    Mono<Boolean> verifyRegisterVerificationCode(String email, String code);
}
