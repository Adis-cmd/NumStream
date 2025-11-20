# NumStream API

REST API для работы с числами на Spring Boot и PostgreSQL.

## Быстрый старт

### Требования
- Docker
- Docker Compose

### Запуск

```bash
# Запустить приложение
docker-compose up --build -d

# Проверить статус
docker-compose ps

# Посмотреть логи
docker-compose logs -f app
```

Приложение будет доступно по адресу: `http://localhost:9999`

### Остановка

```bash
# Остановить контейнеры
docker-compose down

# Остановить и удалить данные БД
docker-compose down -v
```

## API

### Сохранить число

**POST** `/api/numbers`

**Request:**
```json
{
  "value": 42
}
```

**Response:**
```json
[1, 5, 10, 42]
```

### Документация

Swagger UI: `http://localhost:9999/swagger-ui.html`

## Примеры

```bash
# cURL
curl -X POST http://localhost:9999/api/numbers \
  -H "Content-Type: application/json" \
  -d '{"value": 42}'
```

## Troubleshooting

```bash
# Проверить логи
docker-compose logs app

# Пересобрать без кэша
docker-compose down
docker-compose build --no-cache
docker-compose up -d
