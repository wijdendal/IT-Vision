package com.Velo.EmailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMailSender {

    public static void main(String[] args) {
        String host="amineuteri@gmail.com";  //← my email address
        final String user="amineuteri@gmail.com";//← my email address
        final String password="aminesmooth1";//change accordingly   //← my email password

        String to="mohamedamine.bentaieb@esprit.tn";//→ the EMAIL i want to send TO →

        // session object
        Properties props = new Properties();
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });

        //My message :
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("NOTIFICATION APPOINTEMENTT !!! ");
            //message.setText("  → Text message for Velo Appointement ← ");
            //Html code in email :
            message.setContent(
                    "<h1 style =\"color:red\" >DON'T MISS YOUR APPOINTEMENT !! </h1> <br/> <img width=\"50%\" height=\"50%\" src=https://i.imgur.com/iYcBkOf.png>",
                    "text/html");

            //send the message
            Transport.send(message);

            System.out.println("message sent successfully via mail ... !!! ");

        } catch (MessagingException e) {e.printStackTrace();}

    }

}
