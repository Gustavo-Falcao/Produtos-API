package academy.g3e.produtos_api.requests;


import lombok.Data;

@Data
public class ProdutoPostRequestBody {
    private String nome;
    private double preco;
    private int quantidadeEstoque;
    private String descricao;
    private String categoria;
}
