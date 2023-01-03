

package com.spicecap.cardgame;

import java.util.Scanner;


public class cardgame {
    
    //Indica el número de turnos que han pasado
    static int numTurno;
    

    public static void main(String[] args) {
        
        //Presentación del juego
        Scanner sc = new Scanner(System.in);
        System.out.println("Juego de cartas");
        System.out.println("¿Querés jugar una partidita? 1-Si / 2-No");
        int response = sc.nextInt();
        
        //Entramos al juego
        while (response == 1) {
            
            //Primera ronda
            System.out.println("Primera ronda:");
            startRound(3);
            System.out.println("Presiona 1 para inicar la siguiente ronda:");
            sc.nextInt();
            
            //Segunda ronda
            System.out.println("Segunda ronda:");
            startRound(6);
            System.out.println("Presiona 1 para inicar la siguiente ronda:");
            sc.nextInt();
            
            //Tercer ronda
            System.out.println("Tercer ronda:");
            startRound(9);
            
            //Termina el juego
            Game.verifyWinner();
            
            //Se resetean los valores del juego
            numTurno = 0;
            Game.resetGameValues();
            System.out.println();
            System.out.println("¿Gustas jugar otra partida?");
            response = sc.nextInt();    
        }
        //Despedida del juego
        System.out.println("Adiós"); 
    }
    
    public static void startRound(int num) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Aquí están tus cartas");
        //Generamos tipo, ataque y defensa de las cartas del usuario
        Card.generateCards();
        //Mostramos 
        Card.showCards();
        //Generamos las del oponente
        Card.generateCardsOpponent();
        System.out.println();
        //Mostramos las cartas del oponente para pruebas
        Card.showCards0();
        System.out.println();
        
        //Le indicamos al usuario que debe elegir 3 cartas y si ataca o defiende
        Game.defineTurn();
        System.out.println("Elige 3 cartas: 1-9 / 10-Pasar");
        System.out.println();
        //Fijamos el tablero del juego
        System.out.println("Tus cartas" + "        |        " + " Cartas oponente");
        
        //Ronda (3 turnos)
        while (numTurno < num) {
            //Leemos el número de carta que eligió el usuario
            Game.gameUser.usedCard = sc.nextInt();
            //Usuario y oponente ficticio eligen cartas
            chooseCardsProcess(Game.gameUser.usedCard);
        }
        
        System.out.println();
        Game.compareCards(Game.turnAoD);
        Game.resetTotals();
        Card.resetActives();
    }
    
    //Se muestran las cartas elegidas y se suma al ataque y defensa totales de cada uno
    public static void chooseCardsProcess(int num) {
        switch (num) {
            case 1:
                //Verificamos que la carta no hay sido utilizada antes
                if (Card.card1.active == true) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Ya has elegido esta carta, prueba eligiendo otra");
                    //Leemos el número de la nueva carta que eligió el usuario
                    Game.gameUser.usedCard = sc.nextInt();
                    //Volvemos a ejecutar el método
                    chooseCardsProcess(Game.gameUser.usedCard);
                }
                else {
                    //Mostramos la carta que eligió el usuario
                    Card.card1.showCard(1);
                    //Sumamos el ataque y la defensa totales de los valores de la carta
                    Game.sumCard(1);
                    //Agregamos a la carta usada como activa
                    Card.card1.active = true;
                    //Mostramos, sumamos valores y agregamos la carta como activa del oponente
                    Game.opponentResponse();
                    numTurno++;    
                }
                break;
            case 2:
                //Verificamos que la carta no hay sido utilizada antes
                if (Card.card2.active == true) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Ya has elegido esta carta, prueba eligiendo otra");
                    //Leemos el número de la nueva carta que eligió el usuario
                    Game.gameUser.usedCard = sc.nextInt();
                    //Volvemos a ejecutar el método
                    chooseCardsProcess(Game.gameUser.usedCard);
                }
                else {
                    //Mostramos la carta que eligió el usuario
                    Card.card2.showCard(2);
                    //Sumamos el ataque y la defensa totales de los valores de la carta
                    Game.sumCard(2);
                    //Agregamos a la carta usada como activa
                    Card.card2.active = true;
                    //Mostramos, sumamos valores y agregamos la carta como activa del oponente
                    Game.opponentResponse();
                    numTurno++;    
                }
                break;
            case 3:
                //Verificamos que la carta no hay sido utilizada antes
                if (Card.card3.active == true) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Ya has elegido esta carta, prueba eligiendo otra");
                    //Leemos el número de la nueva carta que eligió el usuario
                    Game.gameUser.usedCard = sc.nextInt();
                    //Volvemos a ejecutar el método
                    chooseCardsProcess(Game.gameUser.usedCard);
                }
                else {
                    //Mostramos la carta que eligió el usuario
                    Card.card3.showCard(3);
                    //Sumamos el ataque y la defensa totales de los valores de la carta
                    Game.sumCard(3);
                    //Agregamos a la carta usada como activa
                    Card.card3.active = true;
                    //Mostramos, sumamos valores y agregamos la carta como activa del oponente
                    Game.opponentResponse();
                    numTurno++;    
                }
                break;
            case 4:
                //Verificamos que la carta no hay sido utilizada antes
                if (Card.card4.active == true) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Ya has elegido esta carta, prueba eligiendo otra");
                    //Leemos el número de la nueva carta que eligió el usuario
                    Game.gameUser.usedCard = sc.nextInt();
                    //Volvemos a ejecutar el método
                    chooseCardsProcess(Game.gameUser.usedCard);
                }
                else {
                    //Mostramos la carta que eligió el usuario
                    Card.card4.showCard(4);
                    //Sumamos el ataque y la defensa totales de los valores de la carta
                    Game.sumCard(4);
                    //Agregamos a la carta usada como activa
                    Card.card4.active = true;
                    //Mostramos, sumamos valores y agregamos la carta como activa del oponente
                    Game.opponentResponse();
                    numTurno++;    
                }
                break;
            case 5:
                //Verificamos que la carta no hay sido utilizada antes
                if (Card.card5.active == true) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Ya has elegido esta carta, prueba eligiendo otra");
                    //Leemos el número de la nueva carta que eligió el usuario
                    Game.gameUser.usedCard = sc.nextInt();
                    //Volvemos a ejecutar el método
                    chooseCardsProcess(Game.gameUser.usedCard);
                }
                else {
                    //Mostramos la carta que eligió el usuario
                    Card.card5.showCard(5);
                    //Sumamos el ataque y la defensa totales de los valores de la carta
                    Game.sumCard(5);
                    //Agregamos a la carta usada como activa
                    Card.card5.active = true;
                    //Mostramos, sumamos valores y agregamos la carta como activa del oponente
                    Game.opponentResponse();
                    numTurno++;    
                }
                break;
            default:
                System.out.println("Has elegido pasar  ");
                Game.opponentResponse();
                numTurno++;
                break;
        }
    }
    
    
    
}
