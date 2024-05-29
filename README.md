# ScreenSound - Console Application

## Descrição do Projeto

ScreenSound é uma aplicação backend de console para obter dados de músicas e persisti-los em um banco de dados. A aplicação permite cadastrar artistas e músicas, listar músicas, buscar músicas por artista e pesquisar dados sobre um artista utilizando uma integração com IA (ChatGPT).

## Funcionalidades

1. **Cadastrar artistas**
2. **Cadastrar músicas**
3. **Listar músicas**
4. **Buscar músicas por artista**
5. **Pesquisar dados sobre um artista**
6. **Sair**

## Estrutura do Projeto

O projeto é organizado da seguinte forma:

- `br.com.alura.screensound.principal.Principal`:
  - Classe principal que contém o método `main` e o menu de opções.
  - Métodos para cadastrar artistas, cadastrar músicas, listar músicas, buscar músicas por artista e pesquisar dados sobre artistas.
  
- `br.com.alura.screensound.model.Artista`:
  - Classe modelo que representa um artista, contendo atributos como nome e tipo de artista (solo, dupla ou banda).

- `br.com.alura.screensound.model.Musica`:
  - Classe modelo que representa uma música, contendo atributos como nome da música e referência ao artista.

- `br.com.alura.screensound.model.TipoArtista`:
  - Enumeração que define os tipos de artistas (solo, dupla, banda).

- `br.com.alura.screensound.repository.ArtistaRepository`:
  - Interface que estende `JpaRepository` para operações de persistência com o banco de dados.
  - Métodos personalizados para encontrar artistas por nome e listar músicas de um artista específico.

- `br.com.alura.screensound.services.ConsultaChatGPT`:
  - Classe de serviço responsável por integrar com a API do ChatGPT para obter informações sobre artistas.

## Uso

1. **Cadastrar artistas: Insira o nome e o tipo de artista.**
2. **Cadastrar músicas: Insira o nome do artista e o nome da música.**
3. **Listar músicas: Exibe todas as músicas cadastradas.**
4. **Buscar músicas por artista: Insira o nome do artista para listar suas músicas.**
5. **Pesquisar dados sobre um artista: Insira o nome do artista para obter informações via ChatGPT.**
6. **Sair: Encerra a aplicação.**
