package NiceGame.Dominio;

public class GameMenu 
{
    // Método para exibir o menu do jogo
    public static void showMenu(Player player)
    {
        // Opções do menu
        String[] options = {"Novo Jogo","Continuar","Sair"};
        String choice = Text.select("Menu", "Escolha uma opção", options);

        // Switch-case para tratar as escolhas do jogador no menu
        switch (choice) 
        {
            case "Novo Jogo":
                // Inicia um novo jogo
                newGame();
            break;

            case "Continuar":
                // Continua um jogo salvo
                if (player != null)
                {
                    //continueGame();
                }
                
                else
                {
                    Text.showMessage("Não há jogo salvo encontrado.");
                    showMenu(player);
                }
            break;

            case "Sair":
                // Sai do jogo
                Text.showMessage("Obrigado por jogar!");
            break;

            default:
                // Tratamento de escolha inválida
                System.exit(0);
            break;
        }
    }

    public static void defeatMenu(Player player)
    {
       // Opções do menu
       String[] options = {"Jogar de novo","Sair"};
       String choice = Text.select("Menu", "Você perdeu!!", options); 

       // Switch-case para tratar as escolhas do jogador no menu
       switch (choice) 
       {
           case "Jogar de novo":
               // Inicia um novo jogo
               newGame();
           break;

           case "Sair":
               // Sai do jogo
               Text.showMessage("Obrigado por jogar!");
               System.exit(0);
           break;

           default:
                // Tratamento de escolha inválida
                System.exit(0);
            break;
       }
    }

/*  
    public static void winnerLevelMenu(Player player)
    {
       // Opções do menu
       String[] options = {"Salvar","Continuar o jogo"};
       String choice = Text.getValidSelection("Menu", "Deseja salvar o seu progresso?", options); 

       // Switch-case para tratar as escolhas do jogador no menu
       switch (choice) 
       {
           case "Salvar":
               // Salva o progresso do jogo
               saveGame(player);
           break;

           case "Continuar o jogo":
               continueGame();
            break;

           case "Sair":
               // Sai do jogo
               Text.showMessage("Obrigado por jogar!");
               System.exit(0);
           break;
       }
    }
*/

    // Método para iniciar um novo jogo
    private static void newGame()
    {
            // Cria um novo perfil de jogador
            Profile profile = new Profile();
            Player player = profile.createPlayer();
        
            // Cria um novo objeto Level e inicia os níveis do jogo
            Level level = new Level();

            // Executa níveis do jogo
            level.level01(player);
            level.level02(player);
            level.level03(player);
            level.level04(player);
            level.levelFinal(player);

            Text.showMessage("Jogo concluído");
    }

/*
    //Método para salvar o jogo
    private static void saveGame(Player player)
    {
        try 
        {
            FileOutputStream fileOut = new FileOutputStream("savedGame.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(player);
            objectOut.close();
            fileOut.close();
        } 
        
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
 */
 
 /*
    // Método para continuar um jogo salvo
    private static Player continueGame()
    {
        Player player = null;
        try 
        {
            FileInputStream fileIn = new FileInputStream("savedGame.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            player = (Player) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } 
        
        catch (IOException | ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
        return player;
    }
*/
}