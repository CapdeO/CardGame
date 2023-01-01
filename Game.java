
package com.spicecap.cardgame;

import java.util.Random;

//Esta clase se encarga de administrar los juegos de los participantes y sumar los puntos de cada juego
public class Game {
    public int usedCard; //Acá guardamos las cartas elegidas por los jugadores
    public int attackSum; //Guardamos el total de ataque en una ronda de los jugadores
    public int defenseSum; //Lo mismo con la defensa
    public int roundsWon; //Total de rondas ganadas de cada juego
    //Esta variable almacena el número aleatorio para determinar si el jugador ataca o defiende
    static int turnAoD;
    //El método agregar el ataque y defensa de una carta utilizada a los totales del jugador
    public static void sumCard(int num) {
        switch (num) {
            case 1:
                gameUser.attackSum += Card.card1.attack;
                gameUser.defenseSum += Card.card1.defense;
                break;
            case 2:
                gameUser.attackSum += Card.card2.attack;
                gameUser.defenseSum += Card.card2.defense;
                break;
            case 3:
                gameUser.attackSum += Card.card3.attack;
                gameUser.defenseSum += Card.card3.defense;
                break;
            case 4:
                gameUser.attackSum += Card.card4.attack;
                gameUser.defenseSum += Card.card4.defense;
                break;
            case 5:
                gameUser.attackSum += Card.card5.attack;
                gameUser.defenseSum += Card.card5.defense;
                break;
            default:
                break;
        }
    }
    //El oponente elige una carta de forma aleatoria, se muestra y se suman sus valores totales
    public static void opponentResponse() {
        Random rnd = new Random();
        //Se elige el número de carta de forma aleatoria
        gameOpponent.usedCard = (rnd.nextInt(5)+1);
        //Se verifica que no haya sido utilizada la carta, se agrega como activada y se muestra la carta elegida del oponente 
        checkOpponentCard(gameOpponent.usedCard);
        //Se suman los valores de ataque y defensa
        sumOpponentCard(gameOpponent.usedCard);
    }
    
    public static void checkOpponentCard(int num) {
        switch (num) {
            case 1:
                //Se verifica que la carta no haya sido utilizada
                if (Card.card01.active == true) {
                    opponentResponse();
                }
                else {
                    //Se agrega la carta como activada
                    Card.card01.active = true;
                    System.out.print("     ");
                    //Se muestra la carta elegida por el oponente
                    Card.card01.showCard(1);
                }
                break;
            case 2:
                if (Card.card02.active == true) {
                    opponentResponse();
                }
                else {
                    Card.card02.active = true;
                    System.out.print("     ");
                    Card.card02.showCard(2);
                }
                break;
            case 3:
                if (Card.card03.active == true) {
                    opponentResponse();
                }
                else {
                    Card.card03.active = true;
                    System.out.print("     ");
                    Card.card03.showCard(3);
                }
                break;
            case 4:
                if (Card.card04.active == true) {
                    opponentResponse();
                }
                else {
                    Card.card04.active = true;
                    System.out.print("     ");
                    Card.card04.showCard(4);
                }
                break;
            case 5:
                if (Card.card05.active == true) {
                    opponentResponse();
                }
                else {
                    Card.card05.active = true;
                    System.out.print("     ");
                    Card.card05.showCard(5);
                }
                break;
        }   
    }
    
    //El método agrega el ataque y la defensa de una carta utilizada a los totales del oponente
    public static void sumOpponentCard(int num0) {
        switch (num0) {
            case 1:
                gameOpponent.attackSum += Card.card01.attack;
                gameOpponent.defenseSum += Card.card01.defense;
                break;
            case 2:
                gameOpponent.attackSum += Card.card02.attack;
                gameOpponent.defenseSum += Card.card02.defense;
                break;
            case 3:
                gameOpponent.attackSum += Card.card03.attack;
                gameOpponent.defenseSum += Card.card03.defense;
                break;
            case 4:
                gameOpponent.attackSum += Card.card04.attack;
                gameOpponent.defenseSum += Card.card04.defense;
                break;   
            case 5:
                gameOpponent.attackSum += Card.card05.attack;
                gameOpponent.defenseSum += Card.card05.defense;
                break;
            default:
                break;
        }
    }
    
    
    //El método define de forma aleatoria quien ataca y quien defiende
    public static void defineTurn() {
        Random rnd = new Random();
        turnAoD = (rnd.nextInt(2));
        //Si el número aleatorio es 0 entonces el jugador ataca, caso contrario defiende
        if (turnAoD == 0) 
            System.out.println("Te toca atacar");
        else 
            System.out.println("Te toca defender");
    }
    
    //El método define quien es el ganador de la ronda
    public static void compareCards(int turnoAoD) {
        //Si el jugador ataca, calculamos ganador 
        if (turnoAoD == 0) {
            //Mostramos los valores totales del jugador y oponente
            System.out.println("Ataque total: " + gameUser.attackSum);
            System.out.println("Defensa total oponente: " + gameOpponent.defenseSum);
            //Se comparan totales y se determina el ganador de la ronda, si gana se agrega una ronda ganada
            if (gameUser.attackSum > gameOpponent.defenseSum) {
                System.out.println("Has ganado la ronda!");
                gameUser.roundsWon++;
            }
            else if (gameUser.attackSum == gameOpponent.defenseSum) {
                System.out.println("Empate!");
            }
            else if (gameUser.attackSum < gameOpponent.defenseSum) {
                System.out.println("Has perdido la ronda!");
                gameOpponent.roundsWon++;
            }
        }
        //Si el jugador defiende
        else {
            System.out.println("Defensa total: " + gameUser.defenseSum);
            System.out.println("Ataque total oponente: " + gameOpponent.attackSum);
            if (gameUser.defenseSum > gameOpponent.attackSum) {
                System.out.println("Has ganado la ronda!");
                gameUser.roundsWon++;
            }
            else if (gameUser.defenseSum == gameOpponent.attackSum) {
                System.out.println("Empate!");
            }
            else if (gameUser.defenseSum < gameOpponent.attackSum) {
                System.out.println("Has perdido la ronda!");
                gameOpponent.roundsWon++;
            }
        }        
    }
    
    //Método que resetea las sumas totales de ataque y defensa del jugador y oponente
    public static void resetTotals() {
        gameUser.attackSum = 0;
        gameUser.defenseSum = 0;
        gameOpponent.attackSum = 0;
        gameOpponent.defenseSum = 0;
    }
    
    //Método que determina el ganador en base a las rondas ganadas
    public static void verifyWinner() {
        if (gameUser.roundsWon > gameOpponent.roundsWon) 
            System.out.println("HAS GANADO EL JUEGO!");
        else if (gameUser.roundsWon == gameOpponent.roundsWon) 
            System.out.println("EL JUEGO HA EMPATADO");
        else
            System.out.println("HAS PERDIDO EL JUEGO !");
    }
    
    //Resetea todos los valores del juego al final de una partida
    public static void resetGameValues() {
        resetTotals();
        gameOpponent.roundsWon = 0;
        gameUser.roundsWon = 0;
    }
    
    //Instanciamos los juegos del usuario y del oponente
    public static Game gameUser = new Game();
    public static Game gameOpponent = new Game();
    
    
    
    
    
}
