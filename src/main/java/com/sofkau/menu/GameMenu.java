package com.sofkau.menu;

import com.sofkau.dao.CategoryDao;
import com.sofkau.dao.GameDao;
import com.sofkau.dao.impl.CategoryDaoImpl;
import com.sofkau.dao.impl.GameDaoImpl;
import com.sofkau.domain.Game;
import com.sofkau.domain.Level;
import com.sofkau.domain.Player;
import com.sofkau.exception.GenericException;

import java.util.List;
import java.util.Scanner;

public class GameMenu {
    private static GameDao gameDao = new GameDaoImpl();

    public static void startGame(Player player) throws GenericException {
        int totalPoints = 0;
        firstRound(totalPoints, player);
    }

    public static void showGameHistory(Player player) throws GenericException {
        System.out.println("\n:: HISTORIAL DE PARTIDAS: " + player.getName().toUpperCase()+"\n");
        List<Game> games = gameDao.getByPlayerId(player.getId());
        if (games.isEmpty()) {
            System.out.println("NO HAY REGISTROS, INICIAR NUEVA PARTIDA");
        } else {
            Game game = null;
            for (int i = 0; i < games.size(); i++) {
                game = games.get(i);
                System.out.println((i+1) + ". id: " + game.getId()
                        + ", Nivel Alcanzado: " + game.getIdCategoryReached()
                        + ", Puntos acomulado: " + game.getTotalScore()
                        + ", Partida ganada: " + (game.getDidWin()?"SI":"NO") );
            }
        }
    }

    private static void firstRound(int totalPoints, Player player) throws GenericException {
        int points = RoundMenu.newRound(Level.ONE);
        if (points == 0) {
            totalPoints = 0;
            saveGame(totalPoints, false, player, 1l);
        } else {
            totalPoints += points;
            int response = wishToContinue(totalPoints);
            switch (response) {
                case 1:
                    secondRound(totalPoints, player);
                    break;
                case 2:
                    saveGame(totalPoints, false, player, 1l);
                    break;
            }
        }
    }

    private static void secondRound(int totalPoints, Player player) throws GenericException {
        int points = RoundMenu.newRound(Level.TWO);
        long categoryId = 2l;
        if (points == 0) {
            totalPoints = 0;
            saveGame(totalPoints, false, player, categoryId);
        } else {
            totalPoints += points;
            int response = wishToContinue(totalPoints);
            switch (response) {
                case 1:
                    thirdRound(totalPoints, player);
                    break;
                case 2:
                    saveGame(totalPoints, false, player, categoryId);
                    break;
            }
        }
    }

    private static void thirdRound(int totalPoints, Player player) throws GenericException {
        int points = RoundMenu.newRound(Level.THREE);
        long categoryId = 3l;
        if (points == 0) {
            totalPoints = 0;
            saveGame(totalPoints, false, player, categoryId);
        } else {
            totalPoints += points;
            int response = wishToContinue(totalPoints);
            switch (response) {
                case 1:
                    fourthRound(totalPoints, player);
                    break;
                case 2:
                    saveGame(totalPoints, false, player, categoryId);
                    break;
            }
        }
    }

    private static void fourthRound(int totalPoints, Player player) throws GenericException {
        int points = RoundMenu.newRound(Level.FOUR);
        long categoryId = 4l;
        if (points == 0) {
            totalPoints = 0;
            saveGame(totalPoints, false, player, categoryId);
        } else {
            totalPoints += points;
            int response = wishToContinue(totalPoints);
            switch (response) {
                case 1:
                    fifthRound(totalPoints, player);
                    break;
                case 2:
                    saveGame(totalPoints, false, player,categoryId);
                    break;
            }
        }
    }

    private static void fifthRound(int totalPoints, Player player) throws GenericException {
        int points = RoundMenu.newRound(Level.FIVE);
        long categoryId = 5l;
        if (points == 0) {
            totalPoints = 0;
            saveGame(totalPoints, false, player, categoryId);
        } else {
            totalPoints += points;
            saveGame(totalPoints, true, player, categoryId);
            System.out.println("\nTotal de puntos obtenidos: " + totalPoints);
            System.out.println("FELICITACIONES " + player.getName() + "GANASTE EL JUEGO");
        }
    }

    private static int wishToContinue(int totaPoints) {
        Scanner sc = new Scanner(System.in);
        int response = 0;
        do {
            System.out.println("\nSu puntos acomulados son: " + totaPoints);
            System.out.println("Desea continuar a la siguiente ronda?");
            System.out.println("1. Si");
            System.out.println("2. No");
            response = sc.nextInt();
        } while (response != 1 && response != 2);
        return response;
    }

    private static void saveGame(int totalPoints, Boolean didWin, Player player, Long categoryId)
            throws GenericException {
        Game game = new Game(totalPoints, didWin, player.getId(), categoryId);
        gameDao.save(game);
    }
}
