package med.voll.api.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import med.voll.api.domain.topico.DatosActualizacionTopico;
import med.voll.api.domain.topico.DatosDetalleTopico;
import med.voll.api.domain.topico.DatosRegistroTopico;
import med.voll.api.domain.topico.Topico;
import med.voll.api.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder) {
        var topico = new Topico(datos);
        repository.save(topico);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri() ;
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico)); //devuelve el topico registrado con su URI
    }

    @GetMapping
    public ResponseEntity<Page<DatosDetalleTopico>> listar(@PageableDefault(size=10, sort = "titulo") Pageable paginacion) {
        var page = repository.findAllByStatusTrue(paginacion).map(DatosDetalleTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> detallar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody @Valid DatosActualizacionTopico datos) {
        var topico = repository.getReferenceById(id);
        topico.actualizarInformaciones(datos);

        return ResponseEntity.ok(new DatosDetalleTopico(topico)); //devuelve el topico actualizado
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id) {
        //repository.deleteById(id);              //eliminacion fisica
        var topico = repository.getReferenceById(id);
        topico.eliminar();
        return ResponseEntity.noContent().build();
    }

}
