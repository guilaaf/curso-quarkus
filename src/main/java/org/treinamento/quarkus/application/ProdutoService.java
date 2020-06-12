package org.treinamento.quarkus.application;

import org.treinamento.quarkus.domain.Produto;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProdutoService {

    @Transactional
    public List<Produto> buscarProdutos() {
        return Produto.listAll();
    }

    @Transactional
    public void adicionarProduto(Produto produto) {
        produto.persist();
    }

    @Transactional
    public void alterarProduto(Long id, Produto dados) {
        Optional<Produto> produto = Produto.findByIdOptional(id);
        produto.ifPresentOrElse(
            p -> produto.get().setValor(dados.getValor()),
            () -> { throw new NotFoundException(); }
        );
    }

    @Transactional
    public void apagarProduto(Long id) {
        Optional<Produto> produto = Produto.findByIdOptional(id);
        produto.ifPresentOrElse(
            Produto::delete,
            () -> { throw new NotFoundException(); }
        );
    }
}
