public class Produto {

    private int id;
    private String nome;
    private double preco;
    private String descricao;
    private int quantidade;

    public Produto(){}

    public Produto(String nome, String descricao, int quantidade, double preco){

        this.setNome(nome);
        this.setDescricao(descricao);
        this.setQuantidade(quantidade);
        this.setPreco(preco);
    }

    // Getter e Setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para preco
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Getter e Setter para descricao
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Getter e Setter para quantidade
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /*
    create table produtos(
    id int PRIMARY KEY AUTO_INCREMENT,
    nome varchar(100),
    descricao varchar(255),
    quantidade int,
    preco decimal(10.2)
);
     */
}
