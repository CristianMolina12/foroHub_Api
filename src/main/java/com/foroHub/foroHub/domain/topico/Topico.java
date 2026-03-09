package com.foroHub.foroHub.domain.topico;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter //forma de forma automatica todos los get
@NoArgsConstructor // forma un constructor vacio
@AllArgsConstructor // forma un constructor con todos los atributos
@EqualsAndHashCode(of = "id") // identifica dos objetos iguales si el id es igual
@Entity
@Table(name = "topicos")
public class Topico  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    private  Boolean estado;

    @Column(name = "autor_id")
    private Long autorId;

    @Column(name = "curso_id")
    private Long cursoId;


//    public Topico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, Boolean estado, Long autorId, Long cursoId)
//    {
//        this.id = id;
//        this.titulo = titulo;
//        this.mensaje = mensaje;
//        this.fechaCreacion = fechaCreacion;
//        this.estado = estado;
//        this.autorId = autorId;
//        this.cursoId = cursoId;
//    }

    public Topico(DatosRegistroTopico datos) {
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.estado = true;
        this.autorId = datos.autorId();
        this.cursoId = datos.cursoId();
    }

    public void actualizarInfomacion(@Valid DatosActualizacionTopico datos) {
        if (datos.titulo() != null){
            this.titulo=datos.titulo();
        }if (datos.mensaje() != null){
            this.mensaje=datos.mensaje();
        }if (datos.autorId() != null){
            this.autorId= datos.autorId();
        }if (datos.cursoId() != null){
            this.cursoId= datos.cursoId();
        }
    }
}
