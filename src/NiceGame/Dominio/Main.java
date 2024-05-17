package NiceGame.Dominio;

public class Main {
    public static void main(String[] args) 
    {
            try 
            {
                // Inicializa o jogador como nulo
                Player player = null;

                // Exibe o menu do jogo
                GameMenu.showMenu(player); 
            } 
            
            catch (Exception e) 
            {
                // Tratamento de exceções com exibição de mensagens de erro
                e.printStackTrace();
                Text.showMessage("Erro: " + e.getMessage());
            } 
    }
}
