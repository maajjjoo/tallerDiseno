package notificaciones.src;

import java.time.LocalDateTime;

public abstract class Notificacion {

    private final String codigo;
    private final String destinatario;
    private final String mensaje;
    private final LocalDateTime fechaEnvio;
    private Estado estado;
    private final TipoSituacion tipoSituacion;

    public Notificacion(String codigo, String destinatario, String mensaje,
                        LocalDateTime fechaEnvio, TipoSituacion tipoSituacion) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
        this.estado = Estado.PENDIENTE;
        this.tipoSituacion = tipoSituacion;
    }

    public abstract void enviar();
    public abstract String getTipoMedio();

    // Getters
    public String getCodigo()             { return codigo; }
    public String getDestinatario()       { return destinatario; }
    public String getMensaje()            { return mensaje; }
    public LocalDateTime getFechaEnvio()  { return fechaEnvio; }
    public Estado getEstado()             { return estado; }
    public TipoSituacion getTipoSituacion() { return tipoSituacion; }

    // Protected setter for estado (only subclasses can update it)
    protected void setEstado(Estado estado) { this.estado = estado; }

    @Override
    public String toString() {
        return String.format("[%s] %s | Medio: %-10s | Destinatario: %-20s | Situacion: %-35s | Estado: %s",
                fechaEnvio.toLocalDate(), codigo, getTipoMedio(),
                destinatario, tipoSituacion, estado);
    }
}
