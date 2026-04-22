package notificaciones.src;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaNotificaciones {

    private final List<Notificacion> historial = new ArrayList<>();

    public void enviarNotificacion(Notificacion notificacion) {
        notificacion.enviar();
        historial.add(notificacion);
        System.out.println();
    }

    public void mostrarHistorial() {
        System.out.println("========== HISTORIAL DE NOTIFICACIONES ==========");
        if (historial.isEmpty()) {
            System.out.println("  (sin notificaciones)");
        } else {
            historial.forEach(System.out::println);
        }
        System.out.println("=================================================\n");
    }

    public List<Notificacion> filtrarPorSituacion(TipoSituacion tipo) {
        return historial.stream()
                .filter(n -> n.getTipoSituacion() == tipo)
                .collect(Collectors.toList());
    }
}
