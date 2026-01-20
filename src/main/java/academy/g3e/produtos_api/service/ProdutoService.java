package academy.g3e.produtos_api.service;

import academy.g3e.produtos_api.domain.Produto;
import academy.g3e.produtos_api.repository.ProdutoRepository;
import academy.g3e.produtos_api.requests.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorIdOuLancaExcecaoBadRequest(String id) {
       return produtoRepository.findById(id).
               orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "produto not found"));
    }

    public Produto salvarProduto(ProdutoPostRequestBody produtoPostRequestBody) {
        return produtoRepository.save(Produto.builder()
                .nome(produtoPostRequestBody.getNome())
                .preco(produtoPostRequestBody.getPreco())
                .descricao(produtoPostRequestBody.getDescricao())
                .categoria(produtoPostRequestBody.getCategoria())
                .build());
    }

    public void deletarProdutoPorId(String id) {
        produtoRepository.delete(buscarProdutoPorIdOuLancaExcecaoBadRequest(id));
    }

    public void atualizarProduto(ProdutoPutRequestBody produtoPutRequestBody) {
        Produto produtoSalvo = buscarProdutoPorIdOuLancaExcecaoBadRequest(produtoPutRequestBody.getId());
        Produto produtoAtualizado = Produto.builder()
                .id(produtoSalvo.getId())
                .nome(produtoPutRequestBody.getNome())
                .preco(produtoPutRequestBody.getPreco())
                .quantidadeEstoque(produtoPutRequestBody.getQuantidadeEstoque())
                .descricao(produtoPutRequestBody.getDescricao())
                .categoria(produtoPutRequestBody.getCategoria())
                .build();

        produtoRepository.save(produtoAtualizado);
    }

}
