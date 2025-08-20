package med.voll.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.domain.topico.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findAllByStatusTrue(Pageable paginacion);

}
