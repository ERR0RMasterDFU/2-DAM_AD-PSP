package com.salesianostriana.dam.jwt.security.user.service;

import com.salesianostriana.dam.jwt.security.security.jwt.verification.VerificationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.salesianostriana.dam.jwt.security.user.model.User;

@Service
@RequiredArgsConstructor
public class EmailService {

    // API desarrollada en Java que permite a las aplicaciones enviar y recibir correos electrónicos.
    // Sender (EN) = Remitente (ES)
    private final JavaMailSender sender;

    // Método que envía el correo al usuario
    public void sendVerificationEmail(User user, VerificationToken token) {

        // Genera un enlace con un token único, en el que el usuario deberá hacer clic para activar su cuenta.
        String url = "http://localhost:8080/auth/verify?token=" + token.getVerificationToken();

        // Crea un objeto "SimpleMailMessage", que representa un correo sencillo.
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Verifica tu cuenta");
        message.setText("Haz clic en el siguiente enlace para verificar tu cuenta:\n" + url);

        // Se envía el correo a través del servidor SMTP configurado en el application.properties.
        sender.send(message);
    }

}
