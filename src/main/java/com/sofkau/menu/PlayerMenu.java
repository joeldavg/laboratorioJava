package com.sofkau.menu;

import com.sofkau.dao.PlayerDao;
import com.sofkau.dao.impl.PlayerDaoImpl;
import com.sofkau.domain.Player;
import com.sofkau.exception.GenericException;

import java.util.Scanner;

public class PlayerMenu {

    private static PlayerDao playerDao = new PlayerDaoImpl();

    public static void createPlayer() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("\n:: CREAR JUGADOR");
            System.out.println("\nIngrese email:");
            String email = sc.nextLine().toLowerCase();
            if (playerDao.emailExist(email)) {
                throw new GenericException("Email se encuentra registrado: " + email.toLowerCase());
            }
            System.out.println("\nIngrese nombre:");
            String name = sc.nextLine().toLowerCase();
            System.out.println("\nIngrese apellido:");
            String lastname = sc.nextLine().toLowerCase();

            Player player = new Player(name, lastname, email);
            playerDao.save(player);
            System.out.println("\n" + name.toUpperCase() + ", su registro fue exitoso!");
        } catch (GenericException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void findPlayer() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("\nBUSCAR JUGADOR");
            System.out.println("\nIngrese email:");
            String email = sc.nextLine().toLowerCase();
            if (!playerDao.emailExist(email)) {
                throw new GenericException("Email: " + email + " no se encuentra en base de datos, "
                        + "ingresar email correcto o crear nuevo jugador.");
            }
            Player player = playerDao.getByEmail(email);
            showPlayerMenu(player);
        } catch (GenericException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void showPlayerMenu(Player player) throws GenericException {
        Scanner sc = new Scanner(System.in);
        int response = 0;
        do {
            System.out.println("\n:: BIENVENIDO: " + player.getName().toUpperCase());
            System.out.println("\nSeleccione una opcion:");
            System.out.println("1. Iniciar partida");
            System.out.println("2. Ver historial de partidas");
            System.out.println("0. Volver al Menu \n");

            response = sc.nextInt();
            switch (response) {
                case 1:
                    GameMenu.startGame(player);
                    break;
                case 2:
                    GameMenu.showGameHistory(player);;
                    break;
                case 0:
                    System.out.println("Gracias, vuelve pronto "+ player.getName().toUpperCase() +"!");
                    break;
                default:
                    System.err.println("Ingrese opcion correcta:");
                    break;
            }
        } while (response  != 0);
    }

}
