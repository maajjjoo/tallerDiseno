package notificaciones.src;

import java.time.LocalDateTime;

public class NotificacionSMS extends Notificacion {

    private final String numeroTelefono;
    private final String operadora;

    public NotificacionSMS(String codigo, String destinatario, String mensaje,
                           LocalDateTime fechaEnvio, TipoSituacion tipoSituacion,
                           String numeroTelefono, String operadora) {
        super(codigo, destinatario, mensaje, fechaEnvio, tipoSituacion);
        this.numeroTelefono = numeroTelefono;
        this.operadora = operadora;
    }

    @Override
    public void enviar() {
        System.out.println("=== [SMS Gateway] Enviando SMS ===");
        System.out.println("  Codigo       : " + getCodigo());
        System.out.println("  Destinatario : " + getDestinatario());
        System.out.println("  Telefono     : " + numeroTelefono);
        System.out.println("  Operadora    : " + operadora);
        System.out.println("  Mensaje      : " + getMensaje());
        System.out.println("  Situacion    : " + getTipoSituacion());
        System.out.println("  Fecha        : " + getFechaEnvio());
        System.out.println("  >> SMS enviado exitosamente.");
        setEstado(Estado.ENVIADA);
    }

    @Override
    public String getTipoMedio() { return "SMS"; }

    public String getNumeroTelefono() { return numeroTelefono; }
    public String getOperadora()      { return operadora; }
}
