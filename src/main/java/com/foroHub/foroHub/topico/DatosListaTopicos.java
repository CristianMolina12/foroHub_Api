package com.foroHub.foroHub.topico;

import java.time.LocalDateTime;

public record DatosListaTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime  fechaCreacion,
        Boolean estado,
        Long autorId,
        Long cursoId
) {
    public DatosListaTopicos(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado(),
                topico.getAutorId(),
                topico.getCursoId()
        );
    }
}
