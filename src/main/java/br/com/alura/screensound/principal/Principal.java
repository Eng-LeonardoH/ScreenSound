package br.com.alura.screensound.principal;


import java.util.*;

public class Principal {

    private final Scanner leitura = new Scanner(System.in);

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 9) {
            var menu = """
                    1 - Cadastrar artistas
                    2 - Cadastrar músicas
                    3 - Listar músicas
                    4 - Buscar musicas por artista
                    5 - Pesquisar dados sobre um artista

                    9 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastraArtista();
                    break;
                case 2:
                    cadastraMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 5:
                    PesquisaDadosArtista();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void cadastraArtista() {
    }

    private void cadastraMusica() {
    }

    private void listarMusicas() {
    }

    private void buscarMusicaPorArtista() {
    }

    private void PesquisaDadosArtista() {
    }

}