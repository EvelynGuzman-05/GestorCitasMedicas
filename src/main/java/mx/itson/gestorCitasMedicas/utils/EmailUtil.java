/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.gestorCitasMedicas.utils;

import com.sendgrid.*;
import java.io.IOException;



/**
 *
 * @author Evelyn Guzman
 */
public class EmailUtil {
   // Método para enviar un correo
    public static void enviarCorreo(String email, String nombre) throws IOException {
        // Aquí va tu API Key de SendGrid
        String apiKey = "Colocar SendGrid Key";
        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        
        // Configura los detalles del correo
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody("{\n" +
                            "  \"personalizations\": [\n" +
                            "    {\n" +
                            "      \"to\": [\n" +
                            "        {\"email\": \"" + email + "\"}\n" +
                            "      ],\n" +
                            "      \"subject\": \"Registro exitoso\"\n" +
                            "    }\n" +
                            "  ],\n" +
                            "  \"from\": {\n" +
                            "    \"email\": \"evelin21guzace@gmail.com\"\n" +
                            "  },\n" +
                            "  \"content\": [\n" +
                            "    {\n" +
                            "      \"type\": \"text/plain\",\n" +
                            "      \"value\": \"Hola " + nombre + ",\\n\\nTe has registrado exitosamente en nuestro sistema.\\n\\n¡Gracias!\"\n" +
                            "    }\n" +
                            "  ]\n" +
                            "}");
            Response response = sg.api(request);
            System.out.println("Correo enviado: " + response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            System.out.println("Error al enviar el correo: " + ex.getMessage());
        }
    }
}
