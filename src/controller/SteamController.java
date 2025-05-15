package controller;

import java.io.*;

public class SteamController implements ISteamController{

    @Override
    public void readDir(String path) throws IOException {
        File dir = new File(path);
        if (dir.exists() && dir.isDirectory())
        {
            System.out.println("arquivo validado");
        }
    }

    @Override
    public void readFile(String ano, String mes, double media) throws IOException {
        File arq = new File("C:/Users/João/Downloads/SteamCharts.csv");

        if (arq.isFile() && arq.exists())
        {
            InputStreamReader fluxo = new InputStreamReader(new FileInputStream(arq));
            BufferedReader leitor = new BufferedReader(fluxo);


            String linha = leitor.readLine();
            while (linha != null)
            {
                String[] jogos = linha.split(",");

                if ((jogos[1].contains(ano)) && (jogos[2].contains(mes)) && (Double.parseDouble(jogos[6].replace("%", "").trim())>=media))
                {
                    System.out.println("nome do jogo: " + jogos[0]);
                    System.out.println("média do jogo: " + jogos[6]);
                }
                linha = leitor.readLine();
            }
            leitor.close();
            fluxo.close();
        }
        else
        {
            throw new IOException("arquivo invalidado");
        }
    }

    @Override
    public void createFile(String path, String name, String ano, String mes) throws IOException {
        File arq = new File("C:/Users/João/Downloads/SteamCharts.csv");
        File arq_criado = new File(path, name + ".csv");
        if (arq_criado.exists())
        {
            throw new IOException("arquivo existente");
        }
        else
        {
            if (arq.isFile() && arq.exists())
            {
                InputStreamReader fluxo = new InputStreamReader(new FileInputStream(arq));
                BufferedReader leitor = new BufferedReader(fluxo);
                BufferedWriter escreve = new BufferedWriter(new FileWriter(arq_criado));

                String linha = leitor.readLine();
                while (linha != null)
                {

                    String[] jogos = linha.split(",");

                    if ((jogos[1].contains(ano)) && (jogos[2].contains(mes)))
                    {
                        escreve.write(jogos[0]);
                        escreve.write(jogos[6]);
                        escreve.newLine();
                    }
                }
                escreve.close();
                leitor.close();
                fluxo.close();
            }
            else
            {
                throw new IOException("arquivo invalidado");
            }
        }


    }
}
