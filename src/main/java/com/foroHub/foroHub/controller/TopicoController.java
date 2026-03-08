package com.foroHub.foroHub.controller;



import com.foroHub.foroHub.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Transactional
    @PostMapping
    public void registroTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        repository.save(new Topico(datos));
    }

    @Transactional
    @GetMapping
    public Page<DatosListaTopicos> listar(@PageableDefault(size = 10, sort = "fechaCreacion")Pageable paginacion){
        return repository.findAll(paginacion)
                .map(DatosListaTopicos::new);

    }

    @Transactional
    @PutMapping("/{id}")
    public void actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizacionTopico datos) {

        var topicoOptional = repository.findById(id);

        if (topicoOptional.isPresent()) {
            var topico = topicoOptional.get();

            topico.actualizarInfomacion(datos);

            System.out.println("Tópico actualizado con éxito: " + id);
        } else {
            throw new RuntimeException("Tópico no encontrado en la base de datos.");
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void eliminarTopico(@PathVariable Long id){
        var topicoOpcional = repository.findById(id);

        if(topicoOpcional.isPresent()){
            repository.deleteById(id);
            System.out.println("Tópico con ID " + id + " eliminado correctamente.");
        } else {
            // 4. Si no existe, lanzamos la excepción para informar al cliente
            throw new RuntimeException("No se puede eliminar: El tópico no existe.");
        }
    }

}
