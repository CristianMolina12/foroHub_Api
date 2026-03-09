package com.foroHub.foroHub.domain.topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(Long id,
                                 String titulo,
                                 String mensaje,
                                 LocalDateTime fechaCreacion,
                                 Boolean estado,
                                 Long autorId,
                                 Long cursoId) {
    public DatosDetalleTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado(),
                topico.getAutorId(), //
                topico.getCursoId());
    }
}
