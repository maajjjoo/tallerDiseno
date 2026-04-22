package notificaciones.src;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SistemaNotificaciones sistema = new SistemaNotificaciones();
        LocalDateTime ahora = LocalDateTime.now();

        // 1. Publicacion de calificaciones — Email
        NotificacionEmail emailCalif = new NotificacionEmail(
                "NTF-001",
                "Ana Torres",
                "Tus calificaciones del semestre han sido publicadas. Ingresa al portal para consultarlas.",
                ahora,
                TipoSituacion.PUBLICACION_CALIFICACIONES,
                "ana.torres@universidad.edu",
                "Calificaciones publicadas - Semestre 2026-1"
        );

        // 2. Recordatorio de pago de matricula — SMS
        NotificacionSMS smsPago = new NotificacionSMS(
                "NTF-002",
                "Carlos Mendez",
                "Recuerda que el plazo para el pago de matricula vence el 30 de abril. Evita recargos.",
                ahora,
                TipoSituacion.RECORDATORIO_PAGO_MATRICULA,
                "+573001234567",
                "Claro"
        );

        // 3. Aviso de cancelacion de clase — App (Android)
        NotificacionApp appCancelacion = new NotificacionApp(
                "NTF-003",
                "Laura Gomez",
                "La clase de Calculo III del dia de hoy ha sido cancelada. Se reprogramara proximamente.",
                ahora,
                TipoSituacion.AVISO_CANCELACION_CLASE,
                "fcm_token_abc123xyz",
                "Android",
                "ic_cancel_class"
        );

        // 4. Confirmacion de inscripcion a evento — App (iOS)
        NotificacionApp appEvento = new NotificacionApp(
                "NTF-004",
                "Miguel Rios",
                "Tu inscripcion al evento 'Feria de Ciencias 2026' ha sido confirmada. Te esperamos el 5 de mayo.",
                ahora,
                TipoSituacion.CONFIRMACION_INSCRIPCION_EVENTO,
                "apns_token_def456uvw",
                "iOS",
                "ic_event_confirmed"
        );

        // 5. Recordatorio de pago — Email (segundo canal para el mismo tipo)
        NotificacionEmail emailPago = new NotificacionEmail(
                "NTF-005",
                "Sofia Vargas",
                "Este es un recordatorio de que tu pago de matricula esta pendiente. Fecha limite: 30 de abril.",
                ahora,
                TipoSituacion.RECORDATORIO_PAGO_MATRICULA,
                "sofia.vargas@universidad.edu",
                "Recordatorio: Pago de Matricula Pendiente"
        );

        // 6. Publicacion de calificaciones — SMS
        NotificacionSMS smsCalif = new NotificacionSMS(
                "NTF-006",
                "Pedro Castillo",
                "Tus notas del semestre ya estan disponibles en el portal universitario.",
                ahora,
                TipoSituacion.PUBLICACION_CALIFICACIONES,
                "+573109876543",
                "Movistar"
        );

        // Enviar todas las notificaciones
        sistema.enviarNotificacion(emailCalif);
        sistema.enviarNotificacion(smsPago);
        sistema.enviarNotificacion(appCancelacion);
        sistema.enviarNotificacion(appEvento);
        sistema.enviarNotificacion(emailPago);
        sistema.enviarNotificacion(smsCalif);

        // Mostrar historial completo
        sistema.mostrarHistorial();

        // Filtrar por situacion
        System.out.println(">>> Filtro: RECORDATORIO_PAGO_MATRICULA");
        List<Notificacion> pagos = sistema.filtrarPorSituacion(TipoSituacion.RECORDATORIO_PAGO_MATRICULA);
        pagos.forEach(System.out::println);

        System.out.println();
        System.out.println(">>> Filtro: PUBLICACION_CALIFICACIONES");
        List<Notificacion> calificaciones = sistema.filtrarPorSituacion(TipoSituacion.PUBLICACION_CALIFICACIONES);
        calificaciones.forEach(System.out::println);
    }
}
