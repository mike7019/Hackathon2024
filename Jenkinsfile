#!groovy
import java.text.SimpleDateFormat

def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def date = new Date()
def timestamp = dateFormat.format(date).toString()
def CORREOS = "micorreo@gmail.com"

pipeline {
    agent any
    stages {
        stage('Obtener Fuentes') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: "develop"]],
                          wdoGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: "GitPerson", url: "https://github.com/mike7019/Hackathon2024.git"]]])
            }
        }

        stage('Build Docker Image') {
            steps {
                // Construye la imagen Docker utilizando el archivo docker-compose.yml existente
                script {
                    // El comando sh ejecuta comandos de shell dentro del contenedor Docker
                    sh 'docker-compose -f docker-compose-video.yml build'
                }
            }
        }
        stage('Run Test') {
            steps {
                script {
                    try {
                        bat("gradle clean test aggregate") //Ejecución en agente windows sin parametro jenkins
                        echo 'Test Ejecutados sin Fallo'
                        currentBuild.result = 'SUCCESS'
                    } catch (ex) {
                        echo 'Test Ejecutados con Fallo'
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }

        stage('Generar evidencia') {
            steps {
                script {
                    try {
                        bat " rename \"${WORKSPACE}\\target\" serenity_${timestamp}"
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
    }
}