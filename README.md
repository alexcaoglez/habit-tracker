# Habit Tracker API

API REST para gestionar hábitos. Proyecto final de Ironhack.

## ¿Qué hace?

Puedes crear hábitos (diarios o semanales), registrar si los has completado cada día, y ver estadísticas con ayuda de IA.

## Tecnologías

![Java](https://img.shields.io/badge/Java-21-007396?logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.6-6DB33F?logo=spring-boot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-6DB33F?logo=spring-security&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0+-4479A1?logo=mysql&logoColor=white)
![Spring AI](https://img.shields.io/badge/Spring_AI-OpenAI-6DB33F?logo=spring&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-1.18.46-bc0000?logo=java&logoColor=white)

## Cómo ejecutarlo

1. Clona el repositorio
2. Crea una base de datos MySQL llamada `habit_tracker`
3. En `src/main/resources/application.properties` pon tu contraseña de MySQL y tu API key de OpenAI
4. Ejecuta `HabittrackerApplication.java`

## Endpoints principales

### Login
- POST `/api/login` - Te da un token JWT

### Hábitos
- GET `/api/habits` - Ver todos los hábitos
- POST `/api/habits` - Crear un hábito
- PUT `/api/habits/{id}` - Actualizar
- DELETE `/api/habits/{id}` - Borrar

### Registros
- POST `/api/records/habit/{habitId}` - Registrar que has completado un hábito
- GET `/api/records/habit/{habitId}` - Ver registros de un hábito

### IA
- POST `/api/ai/insights` - Análisis de hábitos con IA
- POST `/api/ai/weekly-report` - Reporte semanal con IA

## Datos de prueba

Cuando arranca la aplicación se crean automáticamente:
- Usuario: `alex` / contraseña: `1234`
- Usuario: `maria` / contraseña: `1234`
- Algunos hábitos de ejemplo

## Pendiente

- Mejorar la integración con IA
- Añadir más validaciones
- Tests unitarios