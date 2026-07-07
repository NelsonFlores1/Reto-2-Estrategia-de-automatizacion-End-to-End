# Reto-2-Estrategia-de-automatizacion-End-to-End
Este repositorio contiene los proyectos: Serenity BDD (Java) y Playwright (Python). 


## Instrucciones de instalacion - Playwright (Python)

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
| `playwright` | >=1.40.0 | Motor de automatización del navegador |
| `pytest` | >=7.4.0 | Framework de testing |
| `pytest-bdd` | >=7.0.0 | Integración BDD con Gherkin |
| `pytest-playwright` | >=0.4.0 | Plugin Playwright para pytest |
| `allure-pytest` | >=2.13.0 | Generación de reportes Allure |
| `hypothesis` | >=6.90.0 | Testing basado en propiedades |

#### 4. Instalar navegador Chromium

```bash
playwright install chromium
```

Descarga el binario de Chromium que Playwright usará para ejecutar las pruebas.



## Instrucciones de instalacion - Serenity BDD (Java)

## Ejecucion de pruebas

## Requisitos del entorno

| Herramienta | Versión mínima | Descripción |
|---|---|---|
| Python | 3.12+ | Intérprete de Python |
| Java (JDK) | 25+ | Requerido para Gradle |
| Gradle | 9.5+ | Orquestador de tareas |
| Allure CLI | 2.42.x | Generación de reportes visuales |
