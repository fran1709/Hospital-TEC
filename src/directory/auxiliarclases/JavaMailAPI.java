package directory.auxiliarclases;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

/**
 * Claser que implementa la API de correos de Java para enviar correos electronicos adjuntando archvios
 * @author Marco Reveiz
 * @version 1.0
 */

public class JavaMailAPI {
    /**
     *
     * @param nombreEstudiante nombre del estudiante
     * @param email mail del correo a enviar
     * @throws Exception si no puede enviar el correo
     */
    public static void enviarCorreo (String nombreEstudiante, String email, String texto) throws Exception{
        Properties properties = new Properties();
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.transport.protocl","smtp");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("eatsdeliveryapp@gmail.com","Reque2021");
            }
        });
        //Crea mensaje
        Message message = new MimeMessage(session);
        message.setSubject("Confirmación de cita del paciente " + nombreEstudiante);
        message.setText(texto);
        //Settea la direccion a la cual se va a enviar el correo
        Address address = new InternetAddress(email);
        message.setRecipient(Message.RecipientType.TO, address);


        //Envio de correo
        Transport.send(message);
        System.out.println("Correo enviado!");

    }




}
