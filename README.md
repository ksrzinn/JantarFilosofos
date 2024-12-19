# Jantar dos Filósofos

## 📚 Descrição
Implementação do problema clássico do Jantar dos Filósofos de forma paralela e distribuida utilizando `Socket` e `Threads`, onde filósofos tentam pensar e comer compartilhando recursos limitados (garfos).

## 🍴 Jantar dos Filósofos

Este projeto é uma implementação do problema clássico do **Jantar dos Filósofos** em Java. Ele simula a interação de filósofos compartilhando recursos limitados (garfos), garantindo sincronização e evitando condições de corrida ou deadlocks.

---

## 🛠️ Requisitos
- **Java 8+**
- **Editor de Texto ou IDE** (como IntelliJ ou Eclipse)

---

## 📂 Estrutura do Projeto

```plaintext
projeto-jantar-dos-filosofos/
├── src/
│   ├── Client.java             # Cliente que representa um filósofo
│   ├── Server.java             # Servidor que gerencia conexões e sincronização
│   ├── Main.java               # Ponto de entrada para execução
│   ├── Philosopher.java        # Modelo de filósofo
│   ├── PhilosopherHelper.java  # Classe auxiliar para comunicação cliente-servidor
│   ├── Fork.java               # Modelo de garfo compartilhado
├── PROTOCOL.md                 # Documento descrevendo o protocolo de comunicação
├── README.md                   # Instruções para executar o projeto
├── ARCHITECTURE.drawio         # Diagrama de arquitetura e classes
```

---

## 🔍 Funcionamento do Sistema

### Servidor
- **Funções principais:**
  - Aguarda conexões de múltiplos clientes (filósofos).
  - Gera IDs exclusivos para cada cliente conectado.
  - Gerencia recursos compartilhados, como os garfos, garantindo sincronização entre os filósofos.
  - Evita **deadlocks** e condições de corrida durante a utilização dos garfos.


### Clientes (Filósofos)
- **Comandos enviados ao servidor:**
  1. **`HELLO`**  
     - Inicia a conexão do filósofo com o servidor e recebe um ID exclusivo.
  2. **`THINK`**  
     - Simula o filósofo pensando por um intervalo aleatório de tempo.
  3. **`PICK_FORKS`**  
     - Solicita permissão para pegar os garfos necessários para comer.
  4. **`PICKDOWN_FORKS`**  
     - Devolve os garfos ao servidor após terminar de comer.

- **Interação:**
  - Os clientes recebem respostas do servidor indicando o status de cada operação realizada.


### Recursos Compartilhados
- **Gerenciamento dos garfos:**
  - Cada garfo só pode ser usado por um filósofo por vez.
  - O servidor controla o acesso aos garfos para garantir sincronização.
  - Implementação utiliza técnicas de **exclusão mútua** para prevenir conflitos.



### Suporte a Múltiplos Clientes
- **Conexões simultâneas:**
  - Cada conexão cria um novo filósofo no sistema.
  - Todos os clientes podem interagir com o servidor ao mesmo tempo.
  - Cada filósofo opera de forma independente, mas respeitando as regras de uso compartilhado dos recursos.

---
## 🧩 Principais Componentes

### 1. `Server.java`
- **Descrição:**
  - Gerencia conexões de múltiplos filósofos.
  - Implementa o protocolo de comunicação entre clientes (filósofos) e o servidor.
  - Sincroniza os recursos compartilhados (garfos) para evitar conflitos.

---

### 2. `Client.java`
- **Descrição:**
  - Representa um filósofo conectado ao servidor.
  - Envia comandos para o servidor e exibe as respostas recebidas.
  - Simula o comportamento de um filósofo no Jantar dos Filósofos.

---

### 3. `PhilosopherHelper.java`
- **Descrição:**
  - Classe auxiliar que gerencia as ações de um filósofo conectado ao servidor.
  - Associa cada filósofo a um ID único.
  - Processa comandos enviados pelo cliente e executa as ações solicitadas:
    - Pensar (`THINK`)
    - Pegar garfos (`PICK_FORKS`)
    - Devolver garfos (`PICKDOWN_FORKS`)

---

### 4. `Philosopher.java`
- **Descrição:**
  - Modelo que representa um filósofo.
  - **Atributos e Métodos:**
    - Gerencia o ID exclusivo do filósofo.
    - Conta o número de refeições feitas.
    - Conta os pensamentos realizados.
    - Simula as ações de:
      - **Pensar (`think`)**
      - **Comer (`eat`)**

---

### 5. `Fork.java`
- **Descrição:**
  - Modelo que representa um garfo no Jantar dos Filósofos.
  - Utiliza sincronização para garantir que cada garfo seja usado por apenas um filósofo de cada vez.
  - Implementa métodos para pegar (`pickup`) e devolver (`pickdown`) os garfos.

---

## 🚀 Executando o Projeto
### 1. Compile o código
Navegue até o diretório `src/` e execute:
```
javac *.java
```

### 2. Rode o servidor
Ainda no diretório `src/`, execute:
```
java Main server
```

### 3. Conecte os filósofos
Ainda no diretório `src/`, execute: 
```
java Main
```
Ou, ainda em um diretório `src/`, em um **cmd** ou **Prompt de Comando**
```
telnet localhost 12345
```
