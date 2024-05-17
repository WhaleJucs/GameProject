package NiceGame.Dominio;

// Classe Level define níveis do jogo e suas respectivas lógicas
public class Level 
{
    private Text textUtil;

    // Construtor inicializa um objeto Text
    public Level() 
    {
        this.textUtil = new Text();
    }

    // Método que implementa o primeiro nível do jogo
    public void level01(Player player) 
    {
        // Mostra o perfil do jogador
        Text.showMessage(textUtil.playerProfile(player));

        // Exibe a narrativa do nível 1
        Text.showMessage("Nível 1: O Distrito Poluído\n" +
                        "O Distrito Poluído é um labirinto de fábricas decadentes e rios enegrecidos. Criaturas mutantes vagam pelas ruas, alimentadas pelos resíduos tóxicos despejados pelas indústrias. " +
                        "Seu primeiro desafio é enfrentar essas abominações, usando suas habilidades e sua arma para abrir caminho pela sujeira e pela corrupção.\n" +
                        "Conforme você avança, encontra os trabalhadores locais, cujas vidas foram afetadas pela poluição desenfreada. Eles compartilham histórias de doenças causadas pelos poluentes " +
                        "e da perda de meios de subsistência devido à degradação ambiental.\n" +
                        "Suas palavras inflamam sua determinação, alimentando sua vontade de derrotar o Executivo Corporativo, o líder ganancioso das indústrias, " +
                        "cujos lucros vêm à custa do meio ambiente e da saúde da população.");

        // Opções de ação para o jogador
        String[] options = {"Atacar o Executivo Corporativo", "Se esconder"};
        String choice = Text.getValidSelection("Escolha sua ação", "O que você deseja fazer?", options);

        // Condicional verifica a escolha do jogador
        switch (choice) 
        {
            case "Atacar o Executivo Corporativo":
                // Cria o inimigo e exibe informações sobre ele
                Enemy boss = new Enemy("Executivo Corporativo", textUtil.randomInt(1, 6), 20);
                String enemyInfo = textUtil.enemyEncounter(boss);
                Text.showMessage(enemyInfo);

                // Inicia a batalha entre o jogador e o inimigo
                BattleSimulator battleSimulator = new BattleSimulator(player, boss);
                battleSimulator.startBattle();

                // Verifica se o jogador está vivo após a batalha
                if (player.isAlive()) 
                {
                    // Opções finais de decisão para o jogador
                    String finalChoice = Text.getValidSelection("Decisão final", "O Executivo Corporativo oferece riqueza e poder em troca de sua lealdade. O que você faz?", new String[]{"Sucumbir à ganância", "Atacar o inimigo"});
                    
                    switch (finalChoice) 
                    {
                        case "Atacar o inimigo":
                            // Mensagens de vitória e recompensas para o jogador
                            Text.showMessage("Você não se deixa ser seduzido pelas riquezas oferecidas pelo Executivo Corporativo, golpeando-o com sua arma assim que seu inimigo demonstrou ter abaixado a guarda. " +
                                            "Todas as suas criaturas mutantes, que dependiam de seu poder, sentem suas forças se esvaindo, morrendo logo em seguida.\n" +
                                            "Parabéns, você venceu o Boss 01 e agora os trabalhadores locais poderão voltar a viver suas vidas sem serem aterrorizados pela crueldade do Executivo Corporativo e de seus servos.");
                    
                            // Entrega as recompensas para o jogador
                            int xpEarned = 10;
                            BattleSimulator reward = new BattleSimulator(player, null);
                            reward.rewardBattle(xpEarned);
                        break;
                        
                        case "Sucumbir à ganância":
                            // Mensagem de morte caso o jogador escolha a opção errada
                            Text.showMessage("Você foi enganado pelas falácias do Executivo Corporativo para que ganhasse tempo. Seus servos, as criaturas mutantes, lhe cercam e o atacam com diversos golpes. > Você morreu.");
                            GameMenu.defeatMenu(player);
                        break;
                    }
                }

                else
                {
                    // Mensagem de morte caso o jogador esteja morto
                    Text.showMessage("Você corre para dentro de uma fábrica antiga e abandonada, para fugir do combate, mas é cercado por diversas criaturas mutantes e é atacado. > Você morreu.");
                    GameMenu.defeatMenu(player);
                }
            break;

            case "Se esconder":
                // Mensagem de morte caso o jogador esteja morto
                Text.showMessage("Você corre para dentro de uma fábrica antiga e abandonada, para fugir do combate, mas é cercado por diversas criaturas mutantes e é atacado. > Você morreu.");
                GameMenu.defeatMenu(player);
            break;
        }
    } 

    public void level02(Player player) 
    {
        Text.showMessage("Nível 2: As Ruínas Subterrâneas\n" +
                        "Descendo às profundezas da cidade, você se vê diante de um mundo subterrâneo de escuridão e desespero. " +
                        "As Ruínas Subterrâneas são um labirinto de túneis escuros e cavernas sinistras, onde resíduos tóxicos e criaturas aberrantes são comuns.\n" +
                        "Neste nível, você encontra os Refugiados das Profundezas, uma comunidade de pessoas marginalizadas que foram forçadas a viver nas entranhas da cidade devido à poluição acima. " +
                        "Eles compartilham histórias de perda e sofrimento, mas também de esperança e resiliência.\n" +
                        "Você se une aos refugiados, para fortalecer suas defesas, reparar equipamentos e treinar os refugiados em técnicas de combate enquanto busca pistas sobre a Engenheira Louca e suas atividades poluidoras.");

        String[] options = {"Desistir de enfrentá-la", "Enfrentar a Engenheira Louca"};
        String choice = Text.getValidSelection("Decisão", "O que você decide fazer?", options);

        switch (choice) 
        {
            case "Desistir de enfrentá-la":
                Text.showMessage("No caminho de volta para a comunidade dos refugiados, se depara com criaturas sombrias que o atacam até a sua morte. > Você morreu.");
                GameMenu.defeatMenu(player);
            break;
            
            case "Enfrentar a Engenheira Louca":
                Enemy boss = new Enemy("Engenheira Louca", textUtil.randomInt(6, 10), 30);
                String enemyInfo = textUtil.enemyEncounter(boss);
                Text.showMessage(enemyInfo);

                BattleSimulator battleSimulator = new BattleSimulator(player, boss);
                battleSimulator.startBattle();

                if (player.isAlive()) 
                {
                    Text.showMessage("Após uma batalha árdua, você derrota a Engenheira Louca e liberta as Ruínas Subterrâneas da opressão da tecnologia poluidora.\n" +
                                    "Sua jornada pela sustentabilidade continua...");

                    int xpEarned = 15;
                    BattleSimulator reward = new BattleSimulator(player, null);
                    reward.rewardBattle(xpEarned);
                } 
                
                else 
                {
                    Text.showMessage("Você foi derrotado pela Engenheira Louca. Os refugiados lamentam sua perda e continuam a lutar pela sobrevivência nas profundezas.");
                    GameMenu.defeatMenu(player);
                }
            break;
        }
    }

    public void level03(Player player) 
    {
       Text.showMessage("Nível 3: A Floresta Ancestral\n" +
                        "Na Floresta Ancestral, a atmosfera muda drasticamente. Aqui, a natureza é tanto sua aliada quanto sua inimiga. " +
                        "Você enfrenta animais selvagens, criaturas mágicas e armadilhas naturais enquanto navega pelas densas florestas e pântanos sombrios.\n" +
                        "Ao longo do caminho, você encontra os Guardiões da Floresta, ancestrais sábios que protegem a terra há gerações. " +
                        "Eles compartilham suas preocupações sobre o desmatamento desenfreado e a caça predatória que ameaçam a existência da floresta. " +
                        "Uma chama se incendeia em seu peito, e você sabe o que deve ser feito!" + 
                        "Você se depara com uma Lenhadora Desonesta, desmatando todo o meio ambiente!!!");

        String[] options = {"Desistir do embate", "Atacar a Lenhadora Desonesta"};
        String choice = Text.getValidSelection("Decisão", "O que você decide fazer?", options);

        switch (choice) 
        {
            case "Desistir do embate":
                Text.showMessage("Ao tentar fugir do embate, a Lenhadora Desonesta ouve seus passos e te ataca com seu enorme e poderoso machado. > Você morreu.");
                GameMenu.defeatMenu(player);
            break;
            
            case "Atacar a Lenhadora Desonesta":
                Enemy boss = new Enemy("Lenhadora Desonesta", textUtil.randomInt(11, 15), 45);
                String enemyInfo = textUtil.enemyEncounter(boss);
                Text.showMessage(enemyInfo);

                BattleSimulator battleSimulator = new BattleSimulator(player, boss);
                battleSimulator.startBattle();

                if (player.isAlive()) 
                {
                    Text.showMessage("Com um golpe final certeiro, você derrota a Lenhadora Desonesta, deixando-a incapaz de continuar sua destruição. " +
                                    "À medida que a luz do sol penetra pelas copas das árvores, você sente a Floresta Ancestral vibrar de gratidão, suas árvores cantando em harmonia enquanto a vida floresce mais uma vez sob sua proteção.\n" +
                                    "Você triunfou sobre a destruição ecológica neste capítulo de sua jornada...");

                    int xpEarned = 20;
                    BattleSimulator reward = new BattleSimulator(player, null);
                    reward.rewardBattle(xpEarned);
                } 
                
                else 
                {
                    Text.showMessage("Você foi derrotado pela Lenhadora Desonesta. A destruição continua na Floresta Ancestral.");
                    GameMenu.defeatMenu(player);
                }
            break;
        }
    }

    public void level04(Player player) 
    {
       Text.showMessage("Nível 4: O Céu Enegrecido\n" +
                        "À medida que você escala uma enorme montanha em busca de novos desafios, você encontra uma entrada aos céus. " +
                        "Uma paisagem sombria se revela diante de seus olhos. O Céu Enegrecido é um mar de nuvens negras e fumaça tóxica, " +
                        "onde a vida luta para sobreviver sob a sombra da poluição.\n" +
                        "Você é saudado pelos Pássaros da Resistência, uma aliança improvável de criaturas voadoras determinadas a lutar pela preservação " +
                        "do céu claro que um dia dominou o horizonte. Eles compartilham contos de voos interrompidos, ninhos destruídos e companheiros perdidos " +
                        "devido à poluição atmosférica, clamando por sua ajuda para confrontar o sinistro Barão da Poluição.\n" +
                        "Montado no líder dos Pássaros da Resistência, você voa pelos céus negros em busca do Barão da Poluição, " +
                        "e o encontra usando máquinas poluentes para atacar famílias de passarinhos, que voavam em busca de um abrigo para seus filhotes.\n" +
                        "Diante desta situação, você decide:");

        String[] options = {"Abandonar o desafio e ir embora", "Enfrentar o Barão da Poluição"};
        String choice = Text.getValidSelection("Decisão", "O que você decide fazer?", options);

        switch (choice) 
        {
            case "Abandonar o desafio e ir embora":
                Text.showMessage("O líder dos pássaros se decepciona com sua atitude covarde e o joga das alturas como forma de vingança em nome de todos os pássaros. > Você morreu.");
                GameMenu.defeatMenu(player);
            break;
            
            case "Enfrentar o Barão da Poluição":
                Enemy boss = new Enemy("Barão da Poluição", textUtil.randomInt(16, 20), 70);
                String enemyInfo = textUtil.enemyEncounter(boss);
                Text.showMessage(enemyInfo);

                BattleSimulator battleSimulator = new BattleSimulator(player, boss);
                battleSimulator.startBattle();

                if (player.isAlive()) 
                {
                    Text.showMessage("Com um esforço final e um golpe certeiro, você derrota o Barão da Poluição, enviando-o de volta às sombras de onde veio. " +
                                    "A luz do sol rompe finalmente as nuvens, iluminando os céus enegrecidos da EcoMetrópole com sua radiância dourada, " +
                                    "trazendo esperança e renovação para todas as criaturas ameaçadas pela sua crueldade.");

                    int xpEarned = 20;
                    BattleSimulator reward = new BattleSimulator(player, null);
                    reward.rewardBattle(xpEarned);
                } 
                
                else 
                {
                    Text.showMessage("Você foi derrotado pelo Barão da Poluição. Os céus continuam enegrecidos pela poluição.");
                    GameMenu.defeatMenu(player);
                }
            break;
        }
    }

    public void levelFinal(Player player) 
    {
        Text.showMessage("Nível 5: O Santuário da Vida\n" +
                        "Após uma batalha árdua com o Barão da Poluição, você é conduzido pelo líder das aves ao Santuário da Vida, " +
                        "um oásis verdejante no coração da EcoMetrópole. Aqui, a natureza floresce em toda a sua glória, " +
                        "alimentada pela energia da esperança e da renovação.\n" +
                        "No Santuário da Vida, você se reúne com os Guardiões da Terra, os Guardiões da Floresta, os Refugiados das Profundezas " +
                        "e os Pássaros da Resistência, unindo forças para enfrentar a Rainha das Trevas, a encarnação da destruição ambiental " +
                        "que acabara de iniciar sua devastação.\n" +
                        "Unindo os conhecimentos ancestrais sobre a terra e as energias dos Guardiões da Terra, a sabedoria e poderes mágicos " +
                        "dos Guardiões da Floresta, as estratégias de defesa e resistência dos Refugiados das Profundezas e as táticas de combate " +
                        "aéreo dos Pássaros da Resistência, vocês se sentem prontos para a batalha final.\n" +
                        "Antes de prosseguir, a pergunta ecoa em sua mente: você está pronto para enfrentar os desafios que aguardam no Santuário da Vida " +
                        "e levar a EcoMetrópole de volta à luz da esperança?");

        String[] options = {"Não, abandonar a batalha", "Sim, enfrentar o meu inimigo"};
        String choice = Text.getValidSelection("Decisão", "O que você decide fazer?", options);

        switch (choice) 
        {
            case "Não, abandonar a batalha":
                Text.showMessage("Seus companheiros não podem vencer o mal sem a sua ajuda. Ao abandoná-los, eles lutaram corajosamente contra o inimigo, " +
                                "mas não foram páreos para a Rainha das Trevas. A destruição ambiental tomou conta de todo o reino, contaminando todos os seres vivos. " +
                                "A mãe natureza morreu, assim como você.");
                GameMenu.defeatMenu(player);
            break;
            
            case "Sim, enfrentar o meu inimigo":
                Enemy finalBoss = new Enemy("Rainha das Trevas", textUtil.randomInt(20, 30), 100);
                String enemyInfo = textUtil.enemyEncounter(finalBoss);
                Text.showMessage(enemyInfo);

                BattleSimulator battleSimulator = new BattleSimulator(player, finalBoss);
                battleSimulator.startBattle();

                if (player.isAlive()) 
                {
                    Text.showMessage("Com coragem inabalável, você lança seu último ataque contra a escuridão, " +
                                    "canalizando todas as suas habilidades e poderes de seus aliados para superar as defesas da Rainha das Trevas. " +
                                    "E, finalmente, com um golpe decisivo, a Rainha das Trevas é derrotada, dissipando-se em uma nuvem de sombras.\n" +
                                    "Com a derrota da Rainha das Trevas, a EcoMetrópole floresce mais uma vez. " +
                                    "Os rios correm límpidos, refletindo os raios do sol que brilham sobre as florestas exuberantes. " +
                                    "Os céus, antes enegrecidos pela poluição, agora são tão azuis quanto em tempos antigos, " +
                                    "e os pássaros voam livremente entre as nuvens brancas e fofas.\n" +
                                    "Seu heroísmo e dedicação à causa ambiental são celebrados em toda a cidade. " +
                                    "Você se torna um símbolo de esperança e inspiração para todos os que lutaram ao seu lado. " +
                                    "As pessoas se unem em gratidão, prometendo proteger e preservar a EcoMetrópole para as gerações futuras, " +
                                    "honrando o legado daqueles que dedicaram suas vidas à causa da sustentabilidade e da vida em harmonia com a natureza.\n" +
                                    "Parabéns, " + player.getName() + ", você salvou a EcoMetrópole da destruição ecológica e trouxe luz " +
                                    "e renovação para todos os seus habitantes.\n[fim de jogo]");

                    Text.showMessage("Recompensas Finais: ");
                    int xpEarned = 25;
                    player.setXp(player.getXp() + xpEarned);

                    Text.showMessage("Você ganhou " + xpEarned +" pontos de experiência");
                    player.distributeXpPoints(xpEarned);

                    // Exibe o perfil atualizado do jogador
                    Text.showMessage("Score final do Jogador: \n" + textUtil.playerProfile(player));
                } 
                
                else 
                {
                    Text.showMessage("Você foi derrotado pela Rainha das Trevas. A EcoMetrópole permanece nas trevas.");
                    GameMenu.defeatMenu(player);
                }
            break;
        }
    }
}
