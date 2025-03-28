package Models;

import java.util.HashMap;

public class Agenda {
    private static HashMap<String, Contacto> Agenda;

    public Agenda() {
        Agenda = new HashMap<>();
    }

    public static boolean agregarContacto(Contacto c) {
        if (!Agenda.containsKey(c.getNombreCompleto())) {
            Agenda.put(c.getNombreCompleto(), c);
            return true;
        }
        return false;
    }

    public static boolean eliminarContacto(String nombreContacto) {
        return Agenda.values().removeIf(elemento -> elemento.getNombreCompleto().equalsIgnoreCase(nombreContacto));
    }

    public static Contacto buscarPorNombre(String nombreContacto) {
        if (Agenda.values().stream().anyMatch(elemento -> elemento.getNombreCompleto().equalsIgnoreCase(nombreContacto))) {
            return Agenda.get(nombreContacto);
        }
        return null;
    }

    public static boolean modificarNumero(String nombreContacto, String nuevoNumero) {
        if (buscarPorNombre(nombreContacto) != null) {
            Agenda.get(nombreContacto).setNroTelefono(nuevoNumero);
            return true;
        }
        return false;
    }

    public static boolean listarContactos() {
        if (!Agenda.isEmpty()) {
            Agenda.values().stream().forEach(System.out::println);
            return true;
        }
        return false;
    }
}
