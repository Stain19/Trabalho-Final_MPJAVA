import view.*;

public class Main {
    public static void main(String[] args) {
        TelaInicio t = new TelaInicio();
        t.controleProduto.registrarProduto(100,"carro","lindo carro","brinquedo",1);
        t.controleClientes.registrarCliente("Pedro de Morais","email.exemplo@email.com","12345678900",true,61,912345678,"Rua Avenida Casa");
        t.createAndShowGUI();
    }

}