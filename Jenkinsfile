import java.text.SimpleDateFormat

def dateFormat = new SimpleDateFormat('yyyyMMddHHmm')
def date = new Date()
def timestamp = dateFormat.format(date).toString()
def time = "60"


pipeline {
    agent {
        label "${agente}"
    }
    stages {
        stage('Obtener Fuentes') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: 'develop']],
                          wdoGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'GitPerson', url: 'https://github.com/mike7019/Hackathon2024.git']]])
            }
        }
        stage('Start Containers'){
            steps{
                sh ('docker-compose -f docker-compose-video.yml up -d')
            }
        }
        stage ("wait") {
            steps{
                echo "Waiting 60 seconds for deployment to complete "
                sleep time.toInteger() // seconds
            }
        }
        stage('Run Test') {
            steps {
                script {
                    try {
                        sh './gradlew clean test -Dtags="${tags}" -Denvironment=${ambiente}'
                        echo 'Test Ejecutados sin Fallo'
                        currentBuild.result = 'SUCCESS'
                    } catch (ex) {
                        echo 'Test Ejecutados con Fallo'
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }

        stage('Publish Results') {
            steps {
                script {
                    try {
                        sh " rename \"${WORKSPACE}\\target\" serenity_${timestamp}"
                        echo 'Backup de evidencias realizado con exito'

                        publishHTML([allowMissing         : false,
                                     alwaysLinkToLastBuild: true,
                                     keepAll              : true,
                                     reportDir            : "${WORKSPACE}//serenity_${timestamp}/site/serenity",
                                     reportFiles          : 'index.html',
                                     reportName           : 'Evidencias Serenity Demo ',
                                     reportTitles         : 'Proyecto Serenity Demo SCREEMPLAY'])
                        echo 'Reporte Html realizado con exito'
                    } catch (e) {
                        echo 'No se realizo el Backup de evidencias'
                        publishHTML([allowMissing         : false,
                                     alwaysLinkToLastBuild: true,
                                     keepAll              : true,
                                     reportDir            : "${WORKSPACE}//target/serenity_${timestamp}",
                                     reportFiles          : 'index.html',
                                     reportName           : 'Evidencias Serenity Demo ',
                                     reportTitles         : 'Proyecto Serenity Demo SCREEMPLAY'])
                        echo 'Reporte Html realizado con exito'
                        currentBuild.result = 'SUCCESS'
                    }
                }
            }
        }
        stage('Cleanup') {
                    steps {
                        // Limpia los recursos, elimina el contenedor después de las pruebas
                        script {
                            sh 'docker-compose -f docker-compose.yml down'
                        }
                    }
        }
    }
}
