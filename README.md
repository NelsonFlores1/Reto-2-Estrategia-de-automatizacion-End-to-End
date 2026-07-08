# Repositorio de Automatización QA

Este repositorio contiene dos proyectos de automatización para la aplicación **SauceDemo**:

* **SauceDemo_Serenity_BDD_JAVA** → Proyecto de automatización con **Serenity BDD + Java + Gradle**
* **SauceDemo_Playwright_python** → Proyecto de automatización con **Playwright + Python + Pytest**

Cada proyecto cubre escenarios distintos y ambos están integrados en un pipeline de **Jenkins** mediante el archivo `Jenkinsfile`.

---

# Estructura del repositorio

```bash id="xv9q0w"
.
├── Jenkinsfile
├── README.md
├── SauceDemo_Serenity_BDD_JAVA/
└── SauceDemo_Playwright_python/
```

---

# Cobertura de escenarios automatizados

La automatización de esta tarea se dividió entre ambos frameworks de la siguiente manera:

## Escenarios implementados en Serenity BDD (Java)

Ubicación: `SauceDemo_Serenity_BDD_JAVA`

* **Login → Agregar productos → Checkout**
* **Validación de precios en el carrito**

Archivo principal:

* `purchase.feature`

## Escenarios implementados en Playwright (Python)

Ubicación: `SauceDemo_Playwright_python`

* **Login con usuario bloqueado**
* **Ordenamiento de productos**

Archivos principales:

* `test_login_with_blocked_user.py`
* `test_sort_products.py`

---

# Proyecto 1: Serenity BDD (Java)

## Ubicación

```bash
SauceDemo_Serenity_BDD_JAVA/
```

## Descripción

Este proyecto implementa automatización de pruebas con **Serenity BDD en Java**, utilizando **Gradle** como herramienta de construcción y ejecución.

En este proyecto se automatizaron los escenarios de:

* **Login → Agregar productos → Checkout**
* **Validación de precios en el carrito**

Ambos escenarios están contenidos en el archivo:

```bash
purchase.feature
```

---

## Requisitos del entorno

| Herramienta   | Versión mínima recomendada | Descripción                                     |
| ------------- | -------------------------: | ----------------------------------------------- |
| Java (JDK)    |                        25+ | Requerido para compilar y ejecutar el proyecto  |
| Gradle        |                      9.5.1 | Herramienta de build utilizada en este proyecto |
| IntelliJ IDEA |                   Opcional | IDE usado para crear y trabajar con el proyecto |

> En este caso, el proyecto fue creado desde **IntelliJ IDEA** como un **proyecto Gradle**, y **Gradle 9.5.1** fue instalado manualmente en el entorno local para ejecutar el proyecto.

---

## Cómo fue creado este proyecto

Este proyecto de Serenity fue creado siguiendo este enfoque:

1. Se creó un **nuevo proyecto Gradle desde IntelliJ IDEA**.
2. Se configuró **Java** como lenguaje del proyecto.
3. Se instaló **Gradle 9.5.1** manualmente en el sistema.
4. Se agregaron las dependencias necesarias para **Serenity BDD**, **JUnit/Cucumber** y el resto del stack de automatización.

### Nota

Existen otras formas válidas de preparar un proyecto Serenity, por ejemplo:

* usar **Gradle Wrapper** (`gradlew.bat`) para evitar depender de una instalación global de Gradle,
* crear el proyecto manualmente desde consola,
* partir de un template base de Serenity.

Sin embargo, para este proyecto se utilizó **IntelliJ + proyecto Gradle + instalación manual de Gradle 9.5.1**.

---

## Instalación

### 1. Ingresar al proyecto

```bash
cd SauceDemo_Serenity_BDD_JAVA
```

### 2. Verificar Java

```bash
java -version
```

### 3. Verificar Gradle

Como este proyecto fue configurado usando una instalación local/manual de Gradle, validar que Gradle esté disponible en la terminal:

```bash
gradle -v
```

La salida debería mostrar una versión compatible, por ejemplo **Gradle 9.5.1**.

### 4. Descargar dependencias del proyecto

La primera vez que se ejecute el proyecto, Gradle descargará automáticamente las dependencias declaradas en el archivo de build.

---

## Ejecución de pruebas

### Ejecutar las pruebas del proyecto

```bash
gradle clean test aggregate "-Dcucumber.filter.tags=@Purchase"
```

Este comando:

1. limpia artefactos previos,
2. ejecuta las pruebas automatizadas,
3. genera el reporte de Serenity.

---

## Escenarios cubiertos en Serenity

Los escenarios implementados en este proyecto son:

* **Login → Agregar productos → Checkout**
* **Validación de precios en el carrito**

Estos escenarios se encuentran definidos en el feature:

```bash
purchase.feature
```

---

## Reporte de Serenity

Después de la ejecución, el reporte HTML de Serenity se genera en la ruta:

```bash
target/site/serenity/index.html
```

---

# Proyecto 2: Playwright (Python)

## Ubicación

```bash
SauceDemo_Playwright_python/
```

## Descripción

Este proyecto implementa automatización de pruebas con **Playwright en Python**, utilizando **Pytest** como framework de ejecución y `pytest-bdd` para la integración con escenarios BDD.

En este proyecto se automatizaron los escenarios de:

* **Login con usuario bloqueado**
* **Ordenamiento de productos**

---

## Requisitos del entorno

| Herramienta | Versión mínima recomendada | Descripción                  |
| ----------- | -------------------------: | ---------------------------- |
| Python      |                      3.12+ | Intérprete de Python         |
| Java (JDK)  |                        25+ | Requerido para Gradle        |
| Gradle      |                      9.5.1 | Orquestador de tareas        |
| Allure CLI  |                        2.x | Generacion de reportes visuales |

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

Este comando instala las dependencias necesarias para el proyecto, incluyendo Playwright, Pytest y reportería Allure.

### 5. Instalar el navegador Chromium

```bash id="4m1jyu"
playwright install chromium
```

Este comando descarga el binario de Chromium que será utilizado por Playwright durante la ejecución de las pruebas.

---

## Ejecución de pruebas

### Ejecutar todos los tests

```bash id="ft84r2"
pytest tests/ -v --headed
```

### Ejecutar el escenario de login con usuario bloqueado

```bash
pytest tests/test_login_with_blocked_user.py -v --headed
```

### Ejecutar el escenario de ordenamiento de productos

```bash
pytest tests/test_sort_products.py -v --headed
```

---

## Escenarios cubiertos en Playwright

Los escenarios implementados en este proyecto son:

* **Login con usuario bloqueado**
* **Ordenamiento de productos**

Archivos asociados:

* `test_login_with_blocked_user.py`
* `test_sort_products.py`

---

## Desactivar el entorno virtual

Al finalizar la ejecución, puedes salir del entorno virtual con:

```bash
deactivate
```

---

# Ejecución desde Jenkins

El repositorio incluye un archivo `Jenkinsfile` que ejecuta ambos proyectos dentro del mismo pipeline:

1. **SauceDemo_Serenity_BDD_JAVA**
2. **SauceDemo_Playwright_python**

## Flujo general del pipeline

* Checkout del repositorio
* Ejecución del proyecto **Serenity BDD (Java)**
* Publicación del reporte Serenity
* Configuración del entorno para **Playwright (Python)**
* Ejecución de pruebas Playwright
* Publicación de resultados Allure

---

# Requisitos del entorno para Jenkins

Para ejecutar el pipeline correctamente en Jenkins, la máquina o agente debe contar con:

| Herramienta                                            | Requerido para                                     |
| ------------------------------------------------------ | -------------------------------------------------- |
| Java JDK                                               | Serenity BDD                                       |
| Gradle                                                 | Serenity BDD                                       |
| Python                                                 | Playwright                                         |
| Git                                                    | Clonar el repositorio                              |
| Jenkins Plugins: Git, Pipeline, HTML Publisher, Allure | Integración del pipeline y publicación de reportes |

---

# Resumen de ejecución local

## Serenity BDD

```bash
cd SauceDemo_Serenity_BDD_JAVA
gradle clean test aggregate
o
./gradlew.bat clean test aggregate
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
