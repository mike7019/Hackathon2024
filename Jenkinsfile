#!groovy
import java.text.SimpleDateFormat

def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def date = new Date()
def timestamp = dateFormat.format(date).toString()

pipeline {
    agent any
    stages {
        stage('Get Sources') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: "develop"]],
                          wdoGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: "GitPerson", url: "https://github.com/mike7019/Hackathon2024.git"]]])
            }
        }

        stage('Execute Tests') {
            steps {
                script {
                    try {
                        //bat ("gradle clean test -DRunner=\"${Runner}\" aggregate") //Ejecución en agente Windows con parametro jenkins
                        //sh ("gradle clean test -DRunner=\"${Runner}\" aggregate") //Ejecución en agente Linux con parametro jenkins
                        bat("gradle clean test aggregate") //Ejecución en agente windows sin parametro jenkins
                        echo 'Test executed successfully'
                        currentBuild.result = 'SUCCESS'
                    } catch (ex) {
                        echo 'Test executed with failures'
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }

        stage('Generate Reports') {
            steps {
                script {
                    try {
                        bat " rename \"${WORKSPACE}\\target\" serenity_${timestamp}"
                        echo 'evidences backed up successfully'

                        publishHTML([allowMissing         : false,
                                     alwaysLinkToLastBuild: true,
                                     keepAll              : true,
                                     reportDir            : "${WORKSPACE}//serenity_${timestamp}/site/serenity",
                                     reportFiles          : 'index.html',
                                     reportName           : 'Evidences Hackaton ',
                                     reportTitles         : 'Project Hackaton Screenplay'])
                        echo 'HTML report generated successfully'
                    } catch (e) {
                        echo 'could not backup the evidences'
                        publishHTML([allowMissing         : false,
                                     alwaysLinkToLastBuild: true,
                                     keepAll              : true,
                                     reportDir            : "${WORKSPACE}//target/serenity_${timestamp}",
                                     reportFiles          : 'index.html',
                                     reportName           : 'Evidences Hackaton ',
                                     reportTitles         : 'Project Hackaton Screenplay'])
                        echo 'HTML report generated successfully'
                        currentBuild.result = 'SUCCESS'
                    }
                }
            }
        }

    }
}