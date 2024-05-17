package NiceGame.Dominio;

public class Player 
{
    private String name;
    private String age;
    private int attack;
    private String weapon;
    private int hp;
    private int xp;

    // Construtor padrão
    public Player() 
    {
    }

    // Construtor com parâmetros
    public Player(String name, String age, int attack, int hp, int xp, String weapon) 
    {
        this.name = name;
        this.age = age;
        this.attack = attack;
        this.hp = hp;
        this.xp = xp;
        this.weapon = weapon;
    }

    // Método para aplicar dano ao jogador
    public void takeDamage(int damage) 
    {
        this.hp -= damage;
    }

    // Método para verificar se o jogador está vivo
    public boolean isAlive() 
    {
        return this.hp > 0;
    }

    public void distributeXpPoints(int xpPoints) 
    {
        while (xpPoints > 0) 
        {
            Text.showMessage("Você tem " + xpPoints + " pontos de experiência para distribuir.");
            String[] options = {"Aumentar Vida", "Aumentar Força"};
            String choice = Text.getValidSelection("Distribuição de Pontos", "Como você quer distribuir seus pontos?", options);

            switch (choice) 
            {
                case "Aumentar Vida":
                    Text.showMessage("Quantos pontos de vida você quer adicionar?");
                    int hpPoints = Text.inputNumber("Insira a quantidade de pontos de vida");

                    if (hpPoints <= xpPoints && hpPoints > 0)
                    {
                        this.hp += hpPoints;
                        xpPoints -= hpPoints;
                        Text.showMessage(hpPoints + " pontos de vida adicionados.");
                    } 
                    
                    else 
                    {
                        Text.showMessage("Você não tem mais pontos de experiência suficientes.");
                    }
                break;
                
                case "Aumentar Força":
                    Text.showMessage("Quantos pontos de força você quer adicionar?");
                    int attackPoints = Text.inputNumber("Insira a quantidade de pontos de força");
                    
                    if (attackPoints <= xpPoints && attackPoints > 0) 
                    {
                        this.attack += attackPoints;
                        xpPoints -= attackPoints;
                        Text.showMessage(attackPoints + " pontos de força adicionados.");
                    } 
                    
                    else 
                    {
                        Text.showMessage("Você não tem pontos de experiência suficientes.");
                    }
                break;
                
                default:
                    Text.showMessage("Opção inválida. Tente novamente.");
                break;
            }
        }
    }

    // Métodos getter e setter para os atributos do jogador
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getAge() 
    {
        return age;
    }

    public void setAge(String age) 
    {
        this.age = age;
    }

    public int getAttack() 
    {
        return attack;
    }

    public void setAttack(int attack) 
    {
        this.attack = attack;
    }

    public String getWeapon() 
    {
        return weapon;
    }

    public void setWeapon(String weapon) 
    {
        this.weapon = weapon;
    }

    public int getHp() 
    {
        return hp;
    }

    public void setHp(int hp) 
    {
        this.hp = hp;
    }

    public int getXp() 
    {
        return xp;
    }

    public void setXp(int xp) 
    {
        this.xp = xp;
    }
}