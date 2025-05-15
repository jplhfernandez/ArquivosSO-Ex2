package view;

import controller.ISteamController;
import controller.SteamController;
import java.io.IOException;

public class SteamPrincipal {

	    public static void main(String[] args) throws IOException {
	        ISteamController cont = new SteamController();
	        cont.readDir("C:/Users/JP/Downloads/SteamCharts.csv");
	        cont.readFile("2019", "March", 50.5);
	        cont.createFile("D:/ex2_arquivos", "titulo", "2019", "March");
	    }
}
