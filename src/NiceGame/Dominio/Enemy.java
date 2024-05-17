package NiceGame.Dominio;

public class Enemy extends Player 
{
    // Construtor que inicializa um inimigo com nome, ataque e vida
    public Enemy(String name, int attack, int hp) 
    {
        super(name, null, attack, hp, 0, null); // Passa null para idade, xp e arma
    }
}
