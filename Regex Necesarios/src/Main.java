import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main{
        // 1. Teléfono Español (Móvil o Fijo)
        // Empieza por 6, 7, 8 o 9, seguido de 8 dígitos numéricos.
        private static final Pattern TELEFONO_PATTERN = Pattern.compile("^[6789]\\d{8}$");

        // Si quieres permitir el prefijo internacional (+34 o 0034) opcional:
        // private static final Pattern TELEFONO_INT_PATTERN = Pattern.compile("^(?:(?:\\+34|0034|34)\\s?)?[6789]\\d{8}$");

        // 2. DNI (Documento Nacional de Identidad - España)
        // 8 números exactos seguidos de una letra (mayúscula o minúscula).
        private static final Pattern DNI_PATTERN = Pattern.compile("^\\d{8}[a-zA-Z]$");

        // 3. NIE (Número de Identidad de Extranjero - España)
        // Empieza por X, Y o Z, seguido de 7 números y termina en una letra.
        private static final Pattern NIE_PATTERN = Pattern.compile("^[xyzXYZ]\\d{7}[a-zA-Z]$");

        // 4. DNI o NIE combinado (Ideal para un campo genérico de "Documento")
        private static final Pattern DOCUMENTO_ES_PATTERN = Pattern.compile("^[xyzXYZ]?\\d{7,8}[a-zA-Z]$");

        // 5. Correo Electrónico (Email)
        // Validación estándar RFC 5322 simplificada para emails comunes.
        private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");

        // 6. Fecha formato DD-MM-YYYY o DD/MM/YYYY
        // Valida días del 01 al 31, meses del 01 al 12, y años que empiecen por 19 o 20.
        private static final Pattern FECHA_PATTERN = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[-/](0[1-9]|1[012])[-/](19|20)\\d\\d$");

        // 7. Código Postal (España)
        // 5 dígitos. Los dos primeros van del 01 al 52 (provincias españolas).
        private static final Pattern CP_PATTERN = Pattern.compile("^(0[1-9]|[1-4]\\d|5[0-2])\\d{3}$");

        // 8. Nombre/Apellidos simples (Solo letras, espacios y tildes)
        private static final Pattern NOMBRE_PATTERN = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+$");


        // --- MÉTODOS DE VALIDACIÓN ---

        public static boolean validarTelefono(String telefono) {
            if (telefono == null) return false;
            return TELEFONO_PATTERN.matcher(telefono).matches();
        }

        public static boolean validarDNI(String dni) {
            if (dni == null) return false;
            return DNI_PATTERN.matcher(dni).matches();
        /* Nota: Esto solo valida el formato.
           Para una validación real, habría que calcular que la letra coincida con los números
           usando el módulo 23. */
        }

        public static boolean validarDocumento(String documento) {
            if (documento == null) return false;
            return DOCUMENTO_ES_PATTERN.matcher(documento).matches();
        }

        public static boolean validarEmail(String email) {
            if (email == null) return false;
            return EMAIL_PATTERN.matcher(email).matches();
        }

        public static boolean validarFecha(String fecha) {
            if (fecha == null) return false;
            return FECHA_PATTERN.matcher(fecha).matches();
        }

        public static boolean validarNombre(String nombre) {
            if (nombre == null) return false;
            return NOMBRE_PATTERN.matcher(nombre).matches();
        }
    }
