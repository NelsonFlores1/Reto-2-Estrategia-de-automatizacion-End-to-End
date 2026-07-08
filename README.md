# Repositorio de Automatización QA

Este repositorio contiene dos proyectos de automatización para la aplicación **SauceDemo**:

* **SauceDemo_Serenity_BDD_JAVA** → Framework de automatización con **Serenity BDD + Java + Gradle**
* **SauceDemo_Playwright_python** → Framework de automatización con **Playwright + Python + Pytest**

Cada proyecto puede ejecutarse de forma independiente y ambos están integrados en un pipeline de **Jenkins** mediante el archivo `Jenkinsfile`.

---

# Estructura del repositorio

```bash
.
├── Jenkinsfile
├── README.md
├── SauceDemo_Serenity_BDD_JAVA/
└── SauceDemo_Playwright_python/
```

---

# Proyecto 1: Playwright (Python)

## Ubicación

```bash
SauceDemo_Playwright_python/
```

## Descripción

Este proyecto implementa automatización de pruebas con **Playwright en Python**, utilizando **Pytest** como framework de ejecución y **pytest-bdd** para escenarios BDD.

---

## Requisitos del entorno

| Herramienta |                 Versión mínima | Descripción                   |
| ----------- | -----------------------------: | ----------------------------- |
| Python      |                          3.12+ | Intérprete de Python          |
| pip         |                 Última estable | Gestor de paquetes de Python  |
| Playwright  | Incluido en `requirements.txt` | Automatización de navegadores |

> **Nota:** No es necesario instalar Playwright manualmente desde el sistema si se siguen los pasos de instalación del proyecto.

---

## Instalación

### 1. Ingresar al proyecto

```bash
cd SauceDemo_Playwright_python
```

### 2. Crear el entorno virtual

```bash
python -m venv venv
```

Esto crea un directorio `venv/` con un intérprete Python aislado.

### 3. Activar el entorno virtual

```bash
# Windows (CMD)
venv\Scripts\activate.bat

# Windows (PowerShell)
venv\Scripts\Activate.ps1

# Linux / macOS
source venv/bin/activate
```

Cuando el entorno virtual esté activo, verás `(venv)` al inicio de la terminal.

### 4. Instalar dependencias

```bash
pip install -r requirements.txt
```

Este comando instala las dependencias del proyecto, incluyendo:

| Paquete             | Propósito                            |
| ------------------- | ------------------------------------ |
| `playwright`        | Automatización del navegador         |
| `pytest`            | Framework de testing                 |
| `pytest-bdd`        | Integración BDD con Gherkin          |
| `pytest-playwright` | Integración Playwright + Pytest      |
| `allure-pytest`     | Generación de resultados para Allure |
| `hypothesis`        | Testing basado en propiedades        |

### 5. Instalar el navegador Chromium

```bash
playwright install chromium
```

Este comando descarga el binario de Chromium que será utilizado por Playwright durante la ejecución de las pruebas.

---

## Ejecución de pruebas

### Ejecutar todos los tests en modo visible

```bash
pytest tests/ -v --headed
```

### Ejecutar un test específico

```bash
pytest tests/test_login_with_blocked_user.py -v --headed
```

```bash
pytest tests/test_sort_products.py -v --headed
```

---

## Desactivar el entorno virtual

Al finalizar la ejecución, puedes salir del entorno virtual con:

```bash
deactivate
```

---

# Proyecto 2: Serenity BDD (Java)

## Ubicación

```bash
SauceDemo_Serenity_BDD_JAVA/
```

## Descripción

Este proyecto implementa automatización de pruebas con **Serenity BDD en Java**, utilizando **Gradle** como herramienta de construcción y ejecución.
Las pruebas están organizadas bajo un enfoque **BDD**, con escenarios escritos en Gherkin y ejecución automatizada mediante Serenity.

---

## Requisitos del entorno

| Herramienta |                                         Versión mínima | Descripción                                    |
| ----------- | -----------------------------------------------------: | ---------------------------------------------- |
| Java (JDK)  |                                                    17+ | Requerido para compilar y ejecutar el proyecto |
| Gradle      | No requiere instalación global si se usa `gradlew.bat` | Wrapper incluido en el proyecto                |
| Git         |                                            Recomendado | Para clonar el repositorio                     |

> **Importante:** Este proyecto utiliza **Gradle Wrapper** (`gradlew.bat`), por lo que no es obligatorio tener Gradle instalado globalmente en el sistema.

---

## Instalación

### 1. Ingresar al proyecto

```bash
cd SauceDemo_Serenity_BDD_JAVA
```

### 2. Verificar que Java esté disponible

```bash
java -version
```

### 3. Verificar que el wrapper de Gradle exista en el proyecto

Dentro de la carpeta del proyecto deben existir archivos como:

```bash
gradlew.bat
gradlew
build.gradle
settings.gradle
```

No es necesario instalar dependencias manualmente, ya que Gradle descargará las requeridas durante la primera ejecución.

---

## Ejecución de pruebas

### Ejecutar todas las pruebas y generar el reporte Serenity

```bash
./gradlew.bat clean test aggregate
```

### Ejecutar escenarios filtrando por tags

Ejemplo con los tags utilizados en este proyecto:

```bash
./gradlew.bat clean test aggregate "-Dcucumber.filter.tags=@Purchase"
```

Este comando:

1. limpia artefactos previos,
2. ejecuta las pruebas automatizadas,
3. genera el reporte de Serenity.

---

## Reporte de Serenity

Después de la ejecución, el reporte HTML se genera en:

```bash
target/site/serenity/index.html
```

Si el proyecto genera el reporte en otra ruta según su configuración interna, revisar la carpeta de salida definida en el build.

---

# Ejecución desde Jenkins

El repositorio incluye un archivo `Jenkinsfile` que ejecuta ambos proyectos dentro del mismo pipeline:

1. **Serenity BDD (Java)**
2. **Playwright (Python)**

## Flujo del pipeline

* Checkout del repositorio
* Ejecución del proyecto **SauceDemo_Serenity_BDD_JAVA**
* Publicación del reporte Serenity
* Configuración del entorno para **SauceDemo_Playwright_python**
* Ejecución de pruebas Playwright
* Publicación de resultados Allure

---

# Requisitos del entorno para Jenkins

Para ejecutar el pipeline correctamente en Jenkins, la máquina o agente debe contar con:

| Herramienta                                            | Requerido para                                     |
| ------------------------------------------------------ | -------------------------------------------------- |
| Java JDK                                               | Serenity BDD                                       |
| Python                                                 | Playwright                                         |
| Git                                                    | Clonar el repositorio                              |
| Jenkins Plugins: Git, Pipeline, HTML Publisher, Allure | Integración del pipeline y publicación de reportes |

---

# Resumen de ejecución local

## Serenity BDD

```bash
cd SauceDemo_Serenity_BDD_JAVA
gradlew.bat clean test aggregate "-Dcucumber.filter.tags=@Purchase or @InvalidLogin"
```

## Playwright Python

```bash
cd SauceDemo_Playwright_python
python -m venv venv
venv\Scripts\activate.bat
pip install -r requirements.txt
playwright install chromium
pytest tests/ -v --headed
```
