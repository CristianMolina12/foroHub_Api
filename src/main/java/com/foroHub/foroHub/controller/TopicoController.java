package com.foroHub.foroHub.controller;

import com.foroHub.foroHub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public ResponseEntity<?> registroTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        var topico = new Topico(datos);
        repository.save(topico);

        return ResponseEntity.ok().body("Tópico creado correctamente");
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaTopicos>> listar(
            @PageableDefault(size = 10, sort = "fechaCreacion") Pageable paginacion) {

        return ResponseEntity.ok(
                repository.findAll(paginacion)
                        .map(DatosListaTopicos::new)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTopico(
            @PathVariable Long id,
            @RequestBody @Valid DatosActualizacionTopico datos) {

        return repository.findById(id)
                .map(topico -> {
                    topico.actualizarInfomacion(datos);
                    return ResponseEntity.ok("Tópico actualizado con éxito");
                })
                .orElse(ResponseEntity
                        .badRequest()
                        .body("Tópico no encontrado en la base de datos"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTopico(@PathVariable Long id){

        return repository.findById(id)
                .map(topico -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok("Tópico eliminado correctamente");
                })
                .orElse(ResponseEntity
                        .badRequest()
                        .body("No se puede eliminar: el tópico no existe"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> detallarTopico(@PathVariable Long id) {
        return repository.findById(id)
                .map(topico -> ResponseEntity.ok((Object) new DatosDetalleTopico(topico)))
                .orElse(ResponseEntity
                        .badRequest()
                        .body((Object) ("El tópico con ID " + id + " no fue encontrado")));
    }
}