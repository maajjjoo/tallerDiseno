package notificaciones.src;

import java.time.LocalDateTime;

public class NotificacionEmail extends Notificacion {

    private final String emailDestinatario;
    private final String asunto;

    public NotificacionEmail(String codigo, String destinatario, String mensaje,
                             LocalDateTime fechaEnvio, TipoSituacion tipoSituacion,
                             String emailDestinatario, String asunto) {
        super(codigo, destinatario, mensaje, fechaEnvio, tipoSituacion);
        this.emailDestinatario = emailDestinatario;
        this.asunto = asunto;
    }

    @Override
    public void enviar() {
        System.out.println("=== [SMTP] Enviando Email ===");
        System.out.println("  Codigo       : " + getCodigo());
        System.out.println("  Para         : " + emailDestinatario);
        System.out.println("  Asunto       : " + asunto);
        System.out.println("  Destinatario : " + getDestinatario());
        System.out.println("  Mensaje      : " + getMensaje());
        System.out.println("  Situacion    : " + getTipoSituacion());
        System.out.println("  Fecha        : " + getFechaEnvio());
        System.out.println("  >> Email enviado exitosamente.");
        setEstado(Estado.ENVIADA);
    }

    @Override
    public String getTipoMedio() { return "EMAIL"; }

    public String getEmailDestinatario() { return emailDestinatario; }
    public String getAsunto()            { return asunto; }
}
