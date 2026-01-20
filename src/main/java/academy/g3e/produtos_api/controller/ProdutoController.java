package academy.g3e.produtos_api.controller;

import academy.g3e.produtos_api.domain.Produto;
import academy.g3e.produtos_api.requests.*;
import academy.g3e.produtos_api.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor

public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarProdutos() {
        return  produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable String id) {
        return ResponseEntity.ok(produtoService.buscarProdutoPorIdOuLancaExcecaoBadRequest(id));
    }

    @PostMapping
    public ResponseEntity<Produto> adicionarProduto(@RequestBody ProdutoPostRequestBody produtoPostRequestBody) {
        return new ResponseEntity<>(produtoService.salvarProduto(produtoPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> removerProduto(@PathVariable String id) {
        produtoService.deletarProdutoPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> atualizarProduto(@RequestBody ProdutoPutRequestBody produtoPutRequestBody) {
        produtoService.atualizarProduto(produtoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
