package controller;

import java.io.IOException;

public interface ISteamController {
    public void readFile(String ano, String mes, double media) throws IOException;
    public void createFile(String path, String name, String ano, String mes) throws IOException;
    public void readDir(String path) throws IOException;
}