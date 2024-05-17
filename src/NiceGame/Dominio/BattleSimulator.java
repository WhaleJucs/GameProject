package NiceGame.Dominio;

public class BattleSimulator 
{
    private Player player;
    private Enemy enemy;
    private boolean canUseSpecialAttack;
    private Text textUtil;

    // Construtor inicializa os atributos do simulador de batalha
    public BattleSimulator(Player player, Enemy enemy) 
    {
        this.player = player;
        this.enemy = enemy;
        this.canUseSpecialAttack = true;
        this.textUtil = new Text();
    }

    // Método que inicia a batalha
    public void startBattle() 
    {
        Text.showMessage("Início da Batalha!\nVocê está enfrentando: " + enemy.getName());

        // Loop até que o jogador ou o inimigo morra
        while (player.isAlive() && enemy.isAlive()) 
        {
            // Define as opções de ataque
            String[] attackOptions = canUseSpecialAttack ? new String[]{"Ataque Normal", "Ataque Especial", "Curar"} : new String[]{"Ataque Normal", "Curar"};
            String selectedAttack = Text.getValidSelection("Escolha seu ataque", "Escolha uma ação:", attackOptions);

            // Switch-case para realizar a ação escolhida pelo jogador
            switch (selectedAttack) 
            {
                case "Ataque Normal":
                    performNormalAttack();
                break;

                case "Ataque Especial":
                    if (canUseSpecialAttack) 
                    {
                        performSpecialAttack();
                        canUseSpecialAttack = false; // Desabilita o ataque especial
                    } 
                    
                    else 
                    {
                        Text.showMessage("Você não pode usar o Ataque Especial nesta rodada.");
                    }
                break;

                case "Curar":
                    healing();
                break;
                
                default:
                    Text.showMessage("Ação inválida. Tente novamente.");
            }

            // Verifica se o inimigo foi derrotado
            if (!enemy.isAlive()) 
            {
                Text.showMessage("Você derrotou o inimigo!");
                break;
            }

            // Simula o ataque do inimigo
            simulateEnemyAttack();

            // Verifica se o jogador foi derrotado
            if (!player.isAlive()) 
            {
                Text.showMessage("Você foi derrotado pelo inimigo!");
                break;
            }
        }
    }

    public void rewardBattle(int xpEarned)
    {
        Text.showMessage("Recompensas do Nível: ");
        player.setXp(player.getXp() + xpEarned);

        Text.showMessage("Você ganhou " + xpEarned +" pontos de experiência");
        player.distributeXpPoints(xpEarned);

        // Exibe o perfil atualizado do jogador
        Text.showMessage(textUtil.playerProfile(player));
    }

    // Método para realizar um ataque normal
    private void performNormalAttack() 
    {
        int damage = player.getAttack(); // Ataque normal causa dano igual ao valor de ataque do jogador
        enemy.takeDamage(damage);
        Text.showMessage("Você realizou um ataque normal!\nCausou " + damage + " de dano.");
    }

    // Método para realizar um ataque especial
    private void performSpecialAttack() 
    {
        int damage = player.getAttack() * textUtil.randomInt(1, 3); // Exemplo: ataque especial causa o triplo de dano
        enemy.takeDamage(damage);
        Text.showMessage("Você realizou um ataque especial!\nCausou " + damage + " de dano.");
    }

    // Método para curar o jogador
    private void healing() 
    {
        player.setHp(player.getHp() + textUtil.randomInt(5, 20)); // Recupera pontos de vida
        Text.showMessage("Você se curou!\nVocê tem " + player.getHp() + " pontos de vida.");
    }

    // Método para simular o ataque do inimigo
    private void simulateEnemyAttack() 
    {
        int damage = enemy.getAttack(); // Ataque do inimigo
        player.takeDamage(damage);
        Text.showMessage("O " + enemy.getName() + " atacou você!\nCausou " + damage + " de dano.");
    }
}
