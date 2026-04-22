package notificaciones.src;

import java.time.LocalDateTime;

public class NotificacionApp extends Notificacion {

    private final String tokenDispositivo;
    private final String plataforma; // "Android" or "iOS"
    private final String icono;

    public NotificacionApp(String codigo, String destinatario, String mensaje,
                           LocalDateTime fechaEnvio, TipoSituacion tipoSituacion,
                           String tokenDispositivo, String plataforma, String icono) {
        super(codigo, destinatario, mensaje, fechaEnvio, tipoSituacion);
        this.tokenDispositivo = tokenDispositivo;
        this.plataforma = plataforma;
        this.icono = icono;
    }

    @Override
    public void enviar() {
        String gateway = plataforma.equalsIgnoreCase("iOS") ? "APNs" : "FCM";
        System.out.println("=== [" + gateway + "] Enviando Push Notification ===");
        System.out.println("  Codigo       : " + getCodigo());
        System.out.println("  Destinatario : " + getDestinatario());
        System.out.println("  Plataforma   : " + plataforma);
        System.out.println("  Token        : " + tokenDispositivo);
        System.out.println("  Icono        : " + icono);
        System.out.println("  Mensaje      : " + getMensaje());
        System.out.println("  Situacion    : " + getTipoSituacion());
        System.out.println("  Fecha        : " + getFechaEnvio());
        System.out.println("  >> Push notification enviada exitosamente.");
        setEstado(Estado.ENVIADA);
    }

    @Override
    public String getTipoMedio() { return "APP_MOVIL"; }

    public String getTokenDispositivo() { return tokenDispositivo; }
    public String getPlataforma()       { return plataforma; }
    public String getIcono()            { return icono; }
}
