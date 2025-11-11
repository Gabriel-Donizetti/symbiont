# BNI Inovações - Backend

## Configuração do Ambiente

### Pré-requisitos
- Docker
- Docker Compose
- Java 17+
- Maven

### Configuração das Variáveis de Ambiente

1. **Copie o arquivo de exemplo:**
   ```bash
   cp .env.example .env
   ```

2. **Edite o arquivo `.env` com suas configurações:**
   ```bash
   # Configurações do Banco de Dados PostgreSQL
   POSTGRES_USER=root
   POSTGRES_PASSWORD=root
   POSTGRES_DB=symbiont
   POSTGRES_PORT=5433
   POSTGRES_HOST=localhost
   ```

### Executando o Projeto

1. **Inicie o banco de dados:**
   ```bash
   docker-compose up -d
   ```

2. **Execute a aplicação Java:**
   ```bash
   ./mvnw spring-boot:run
   ```

### Estrutura do Projeto

- **`src/main/java/`** - Código fonte Java
- **`src/main/resources/`** - Recursos da aplicação
- **`docker-compose.yml`** - Configuração do Docker
- **`.env`** - Variáveis de ambiente (não commitado)
- **`.env.example`** - Exemplo das variáveis necessárias

### Variáveis de Ambiente Disponíveis

| Variável | Descrição | Valor Padrão |
|----------|-----------|--------------|
| `POSTGRES_USER` | Usuário do banco de dados | `root` |
| `POSTGRES_PASSWORD` | Senha do banco de dados | `root` |
| `POSTGRES_DB` | Nome do banco de dados | `symbiiont` |
| `POSTGRES_PORT` | Porta externa do PostgreSQL | `5433` |
| `POSTGRES_HOST` | Host do banco de dados | `localhost` |

### Notas Importantes

- O arquivo `.env` não deve ser commitado no repositório
- Sempre use o `.env.example` como referência para criar seu arquivo `.env`
- As variáveis são automaticamente carregadas pelo Docker Compose
