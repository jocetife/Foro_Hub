package med.voll.api.domain.topico;

public record DatosActualizacionTopico(
    Long id,
    String titulo,
    String mensaje,
    Boolean status,
    String autor,
    String curso
) {}
