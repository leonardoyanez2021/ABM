package cl.metlife.abm.business.managers.sftp;

import com.jcraft.jsch.HostKey;
import com.jcraft.jsch.HostKeyRepository;
import com.jcraft.jsch.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.util.Base64;

/**
 * Repositorio personalizado de host keys para validar fingerprints SHA256
 */
public class CustomHostKeyRepository implements HostKeyRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomHostKeyRepository.class);

    private final String expectedHost;
    private final String expectedFingerprint;

    public CustomHostKeyRepository(String host, String fingerprint) {
        this.expectedHost = host;
        this.expectedFingerprint = fingerprint;
    }

    @Override
    public int check(String host, byte[] key) {
        try {
            // Verificar que el host coincida
            if (!expectedHost.equals(host)) {
                LOGGER.warn("Host no coincide. Esperado: {}, Recibido: {}", expectedHost, host);
                return NOT_INCLUDED;
            }

            // Calcular fingerprint SHA256 de la clave recibida
            String actualFingerprint = calculateSHA256Fingerprint(key);

            LOGGER.debug("Fingerprint esperado: {}", expectedFingerprint);
            LOGGER.debug("Fingerprint recibido: {}", actualFingerprint);

            // Comparar fingerprints
            if (expectedFingerprint.equals(actualFingerprint)) {
                LOGGER.info("Host key verificado exitosamente para {}", host);
                return OK;
            } else {
                LOGGER.error("Host key NO válido para {}. Fingerprint no coincide.", host);
                return NOT_INCLUDED;
            }

        } catch (Exception e) {
            LOGGER.error("Error verificando host key: {}", e.getMessage());
            return NOT_INCLUDED;
        }
    }

    @Override
    public void add(HostKey hostkey, UserInfo ui) {
        LOGGER.debug("add() llamado - no implementado");
    }

    @Override
    public void remove(String host, String type) {
        LOGGER.debug("remove() llamado - no implementado");
    }

    @Override
    public void remove(String host, String type, byte[] key) {
        LOGGER.debug("remove() llamado con key - no implementado");
    }

    @Override
    public String getKnownHostsRepositoryID() {
        return "CustomHostKeyRepository";
    }

    @Override
    public HostKey[] getHostKey() {
        return new HostKey[0];
    }

    @Override
    public HostKey[] getHostKey(String host, String type) {
        return new HostKey[0];
    }

    /**
     * Calcula el fingerprint SHA256 de una clave pública usando el método nativo de JSch
     * para garantizar compatibilidad con ssh-keygen
     */
    private String calculateSHA256Fingerprint(byte[] key) throws Exception {
        try {
            // Crear un HostKey temporal para usar el algoritmo de JSch
            // que es compatible con el estándar SSH
            HostKey hostKey = new HostKey("temp", key);

            // Obtener el fingerprint usando JSch
            com.jcraft.jsch.JSch jsch = new com.jcraft.jsch.JSch();
            String fingerprint = hostKey.getFingerPrint(jsch);

            LOGGER.debug("Fingerprint calculado por JSch: {}", fingerprint);

            // Verificar que el formato sea SHA256
            if (fingerprint != null && fingerprint.startsWith("SHA256:")) {
                return fingerprint;
            }

            // Si no es SHA256, intentar forzar el algoritmo
            LOGGER.warn("JSch no retornó fingerprint SHA256, usando algoritmo manual");

        } catch (Exception e) {
            LOGGER.warn("Error al calcular fingerprint con JSch: {}", e.getMessage());
        }

        // Cálculo manual del SHA256
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(key);
        String fallbackFingerprint = "SHA256:" + Base64.getEncoder()
                .encodeToString(digest)
                .replaceAll("=+$", ""); // Remover padding de Base64

        LOGGER.debug("Fingerprint calculado manualmente (fallback): {}", fallbackFingerprint);
        return fallbackFingerprint;
    }
}
