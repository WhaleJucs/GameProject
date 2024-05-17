package NiceGame.Dominio;
import javax.swing.JOptionPane;

public class Text 
{
    // Método para exibir uma seleção com opções e retornar a opção selecionada pelo usuário
    public static String select(String title, String msg, String[] options) 
    {
        Object selectedOption = JOptionPane.showInputDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (selectedOption != null) 
        {
            return selectedOption.toString();
        } 
        
        else 
        {
            return ""; // Retorna uma string vazia se o usuário cancelar a seleção
        }
    }

    // Método para obter uma seleção válida
    public static String getValidSelection(String title, String msg, String[] options) 
    {
        String selectedOption;
        do 
        {
            selectedOption = select(title, msg, options);
            
            if(selectedOption.isEmpty()) 
            {
                Text.showMessage("Seleção inválida. Por favor, escolha uma opção.");
            }
        } 
        
        while (selectedOption.isEmpty());

        return selectedOption;
    }

    // Método para exibir uma mensagem simples
    public static void showMessage(String message) 
    {
        JOptionPane.showMessageDialog(null, message);
    }

    // Método para solicitar uma entrada de texto do usuário
    public static String showInput(String message) 
    {
        return JOptionPane.showInputDialog(message);
    }

    // Método para solicitar uma entrada de número do usuário
    public static int inputNumber(String message) 
    {
        int number = -1;
        boolean validInput = false;

        while (!validInput) 
        {
            String input = JOptionPane.showInputDialog(message);
            
            try
            {
                number = Integer.parseInt(input);
                validInput = true;
            }

            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        return number;
    }

    // Método para exibir o perfil do jogador
    public String playerProfile(Player player) 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Ficha do jogador:\n\n");
        sb.append("Nome: ").append(player.getName()).append("\n");
        sb.append("Idade: ").append(player.getAge()).append("\n");
        sb.append("Força: ").append(player.getAttack()).append("\n");
        sb.append("Vida: ").append(player.getHp()).append("\n");
        sb.append("Experiência: ").append(player.getXp()).append("\n");
        sb.append("Arma: ").append(player.getWeapon()).append("\n");
        return sb.toString();
    }

    // Método para exibir detalhes do encontro com o inimigo
    public String enemyEncounter(Enemy enemy) 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Você encontrou um inimigo!\n\n");
        sb.append("Nome: ").append(enemy.getName()).append("\n");
        sb.append("Força: ").append(enemy.getAttack()).append("\n");
        sb.append("Vida: ").append(enemy.getHp()).append("\n");
        return sb.toString();
    }

    // Método para gerar um número aleatório dentro de um intervalo
    public int randomInt(int min, int max) 
    {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}