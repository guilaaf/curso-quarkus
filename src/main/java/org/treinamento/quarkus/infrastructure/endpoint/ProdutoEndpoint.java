package org.treinamento.quarkus.infrastructure.endpoint;

import org.treinamento.quarkus.application.ProdutoService;
import org.treinamento.quarkus.domain.Produto;
import org.treinamento.quarkus.infrastructure.endpoint.dto.CadastroProduto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoEndpoint {

    private ProdutoService produtoService;

    @Inject
    public ProdutoEndpoint(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GET
    public List<Produto> buscarTodosProdutos() {
        return produtoService.buscarProdutos();
    }

    @POST
    public void adicionarProduto(CadastroProduto cadastro) {
        Produto produto = new Produto(cadastro.nome, cadastro.valor);
        produtoService.adicionarProduto(produto);

    }

    @PUT
    @Path("/{id}")
    public void alterarProduto(@PathParam("id") Long id, CadastroProduto cadastro) {
        Produto produto = new Produto(cadastro.nome, cadastro.valor);
        produtoService.alterarProduto(id, produto);

    }

    @DELETE
    @Path("/{id}")
    public void apagarProduto(@PathParam("id") Long id) {
        produtoService.apagarProduto(id);

    }
}
