package academy.g3e.produtos_api.repository;

import academy.g3e.produtos_api.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

}
