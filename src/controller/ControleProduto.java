package controller;

import java.util.ArrayList;

import model.Produto;

public class ControleProduto {
    /**
     * */
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private int numProdutos;

    public ControleProduto() {
    }

    public void setNumProdutos(int num) {
        this.numProdutos = num;
    }

    public int getNumProdutos() {
        return numProdutos;
    }

    public boolean registrarProduto(double preco, String nome, String descricao, String tipo, int qtd) {
        try {
            Produto o = new Produto(preco, nome, descricao, tipo, qtd);
            produtos.add(o);
            numProdutos++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String listarProdutos() {
        String s = "";
        int i = 1;
        for (Produto o : produtos) {
            s += "------------------------------------------"+"Produto "+(i)+"-----------------------------------------\n"+ o.toString() + "\n";
            i++;
        }
        return s;
    }

    public boolean editarProduto(int indexProduto,Double novoPrecoProduto, String novoNomeProduto, String novaDescricaoProduto, String novoTipoProduto, int novaQuantidadeProduto) {
        produtos.get(indexProduto).setPreco(novoPrecoProduto);
        produtos.get(indexProduto).setNome(novoNomeProduto);
        produtos.get(indexProduto).setDescricao(novaDescricaoProduto);
        produtos.get(indexProduto).setTipo(novoTipoProduto);
        produtos.get(indexProduto).setQuantidade(novaQuantidadeProduto);
        return true;
    }

    public void deletarProduto(int indexProduto) {
        produtos.remove(indexProduto);
    }

    public ArrayList<Produto> getProdutos(){
        return produtos;
    }

    public Produto retornarProduto(int index) {
        return produtos.get(index);
    }

    public int getProdutoIndex(String name){
        for (Produto produto : produtos) {
            if (produto.getNome().equals(name)) {
                return produtos.indexOf(produto);
            }
        }

        return 0;
    }
    
    public ArrayList<String> toStringNomeProdutos() {
        ArrayList<String> nomesProdutos= new ArrayList<String>();
        for (Produto produto : produtos) {
            nomesProdutos.add(produto.getNome());
        }
        return nomesProdutos;
    }
}
