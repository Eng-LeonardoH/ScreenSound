package br.com.alura.screensound.principal;


import br.com.alura.screensound.model.Artista;
import br.com.alura.screensound.model.Musica;
import br.com.alura.screensound.model.TipoArtista;
import br.com.alura.screensound.repository.ArtistaRepository;
import br.com.alura.screensound.services.ConsultaChatGPT;

import java.util.*;

public class Principal {

    private final Scanner leitura = new Scanner(System.in);
    private final ArtistaRepository repositorio;

    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

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
        var cadastrarNovo = "S";
        String nome, tipo;

        while (cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.println("Qual o nome do artista?");
            nome = leitura.nextLine();
            System.out.println("Informe o tipo desse artista (solo, dupla ou banda):");
            tipo = leitura.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtista);
            repositorio.save(artista);
            System.out.println("Cadastrar novo artista? (S/N): ");
            cadastrarNovo = leitura.nextLine();
        }
    }
    private void cadastraMusica() {
        var cadastrarNovo = "S";
        String nomeArtista, tipo, nomeMusica;

        while (cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.println("Qual o nome do artista?");
            nomeArtista = leitura.nextLine();
            Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nomeArtista);

            if (artista.isPresent()){
                System.out.println("Qual o nome da música?");
                nomeMusica = leitura.nextLine();
                Musica musica = new Musica(nomeMusica);

                musica.setArtista(artista.get());
                artista.get().getMusicas().add(musica);

                repositorio.save(artista.get());
            } else {
                System.out.println("Artista não encontrado...");
            }

            System.out.println("Deseja cadastrar outra música? (s/n)");
            cadastrarNovo = leitura.nextLine();
        }
    }

    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));

    }

    private void buscarMusicaPorArtista() {
        System.out.println("Buscar músicas de qual artista?");
        var nomeArtista = leitura.nextLine();
        List<Musica> musicasPorArtista = repositorio.musicasPorArtista(nomeArtista);
        musicasPorArtista.forEach(System.out::println);
    }

    private void PesquisaDadosArtista() {
        var opcao = "s";

        while (opcao.equalsIgnoreCase("s")) {
            System.out.println("Sobre qual artista deseja informações?");
            var nome = leitura.nextLine();
            var resposta = ConsultaChatGPT.obterResposta(nome);
            System.out.println(resposta.trim());
            System.out.println("Deseja receber informações sobre outro artista? (s/n)");
            opcao = leitura.nextLine();
        }
    }
}