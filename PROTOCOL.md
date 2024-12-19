# Protocolo de Comunicação - Jantar dos Filósofos

## 💻 Comandos Suportados

### 1. HELLO
- **Descrição:** Identifica um filósofo e retorna um ID único.
- **Cliente:** `HELLO`
- **Servidor:** `HELLO <ID>`

### 2. THINK
- **Descrição:** Filósofo informa que está pensando.
- **Cliente:** `THINK`
- **Servidor:** `Philo <ID> THINKING`

### 3. PICK_FORKS
- **Descrição:** Solicita permissão para pegar os garfos.
- **Cliente:** `PICK_FORKS`
- **Servidor:** `Philo <ID> EATING`

### 4. PICKDOWN_FORKS
- **Descrição:** Solta os garfos após comer.
- **Cliente:** `PICKDOWN_FORKS`
- **Servidor:** `PHILO <ID> PICKED DOWN FORKS`

### 5. STATUS
- **Descrição:** Solicita o status atual do filósofo.
- **Cliente:** `STATUS`
- **Servidor:** `PHILO <ID>: Meals <X>, Thoughts <Y>`

### 6. Comando Inválido
- **Descrição:** Retorna uma mensagem de erro para comandos desconhecidos.
- **Cliente:** Qualquer Comando desconhecido
- **Servidor:** `Unknown Command`
