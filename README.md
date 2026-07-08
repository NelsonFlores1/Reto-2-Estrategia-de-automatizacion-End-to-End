# Reto-2-Estrategia-de-automatizacion-End-to-End
Este repositorio contiene los proyectos: Serenity BDD (Java) y Playwright (Python). 

# Instrucciones para el proyecto Playwright (Python)

## Instrucciones de instalacion

### 1 Crear el entorno virtual (venv)
```bash
python -m venv venv
```
Esto crea un directorio `venv/` con un intérprete Python aislado.

#### 2. Activar el entorno virtual

```bash
# Windows (CMD)
venv\Scripts\activate.bat

# Windows (PowerShell)
venv\Scripts\Activate.ps1

# Linux / macOS
source venv/bin/activate
```

> Cuando el venv está activo, verás `(venv)` al inicio del prompt.

#### 3. Instalar dependencias Python

```bash
pip install -r requirements.txt
```

Esto instala los siguientes componentes:

| Paquete | Versión | Propósito |
|---|---|---|
| `playwright` | >=1.60.0 | Motor de automatización del navegador |
| `pytest` | >=9.1.1 | Framework de testing |
| `pytest-bdd` | >=8.1.0 | Integración BDD con Gherkin |
| `pytest-playwright` | >=0.8.0 | Plugin Playwright para pytest |
| `allure-pytest` | >=2.16.0 | Generación de reportes Allure |
| `hypothesis` | >=6.155.7 | Testing basado en propiedades |

#### 4. Instalar navegador Chromium

```bash
playwright install chromium
```

Descarga el binario de Chromium que Playwright usará para ejecutar las pruebas.

## Ejecucion de pruebas

```bash
# Ejecutar todos los features en modo visible (ver el navegador)
pytest tests/ -v --headed

# Ejecutar cada feature específico en modo visible:
pytest tests/test_login_with_blocked_user.py -v
pytest tests/test_sort_products.py -v 

# Desactivar el entorno virtual al terminar
deactivate
```

## Requisitos del entorno

| Herramienta | Versión mínima | Descripción |
|---|---|---|
| Python | 3.12+ | Intérprete de Python |
| Java (JDK) | 25+ | Requerido para Gradle |
| Gradle | 9.5+ | Orquestador de tareas |
| Allure CLI | 2.42.x | Generación de reportes visuales |


# Instrucciones para el proyecto Serenity BDD (Java)

## Instrucciones de instalacio

## Ejecucion de pruebas

## Requisitos del entorno

### Playwright (Python)
| Herramienta | Versión mínima | Descripción |
|---|---|---|
| Python | 3.12+ | Intérprete de Python |
| Java (JDK) | 25+ | Requerido para Gradle |
| Gradle | 9.5+ | Orquestador de tareas |
| Allure CLI | 2.42.x | Generación de reportes visuales |

### Serenity BDD (Java)
