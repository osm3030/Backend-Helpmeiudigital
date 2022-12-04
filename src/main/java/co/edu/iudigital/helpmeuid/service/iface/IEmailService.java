package co.edu.iudigital.helpmeuid.service.iface;

public interface IEmailService {

    public boolean sendEmail(String mensaje, String email, String asunto);

}
