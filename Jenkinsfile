pipeline {
    agent any

    environment {
        PYTHONDONTWRITEBYTECODE = '1'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        /*
        ============================================================
        SERENITY BDD
        ============================================================
        */
        stage('Build & Test Serenity') {
            steps {
                dir("${WORKSPACE}\\SauceDemo_Playwright_python") {
                    bat 'gradlew.bat clean test aggregate "-Dcucumber.filter.tags=@Purchase"'
                }
            }
        }

        stage('Validar reportes Serenity') {
            steps {
                dir("${WORKSPACE}\\SauceDemo_Playwright_python") {
                    bat 'dir target\\site\\serenity'
                    bat 'dir target\\site\\serenity\\*.json'
                }
            }
        }

        stage('Publicar Serenity') {
            steps {
                dir("${WORKSPACE}\\SauceDemo_Playwright_python") {
                    publishHTML([
                        reportDir: 'target/site/serenity',
                        reportFiles: 'index.html',
                        reportName: 'Reporte Serenity',
                        keepAll: true,
                        alwaysLinkToLastBuild: true,
                        allowMissing: false
                    ])
                }
            }
        }

        /*
        ============================================================
        PLAYWRIGHT PYTHON
        ============================================================
        */
        stage('Setup Playwright Python') {
            steps {
                dir("${WORKSPACE}\\SauceDemo_Playwright_python") {
                    bat '''
                    python -m venv venv
                    call venv\\Scripts\\activate.bat
                    python -m pip install --upgrade pip
                    pip install -r requirements.txt
                    playwright install chromium --with-deps
                    '''
                }
            }
        }

        stage('Execute Playwright Tests') {
            steps {
                dir("${WORKSPACE}\\SauceDemo_Playwright_python") {
                    catchError(buildResult: 'UNSTABLE', stageResult: 'FAILURE') {
                        bat '''
                        call venv\\Scripts\\activate.bat
                        pytest tests/ --alluredir=allure-results
                        '''
                    }
                }
            }
        }
    }

    post {
        always {
            // Archivos Serenity
            dir("${WORKSPACE}\\SauceDemo_Playwright_python") {
                archiveArtifacts artifacts: 'target/site/serenity/**', fingerprint: true, allowEmptyArchive: true
            }

            // Allure Playwright
            dir("${WORKSPACE}\\SauceDemo_Playwright_python") {
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
                archiveArtifacts artifacts: 'allure-results/**', fingerprint: true, allowEmptyArchive: true
            }
        }
    }
}