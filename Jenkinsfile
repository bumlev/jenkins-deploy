pipeline {
    agent any

    environment {
            MAVEN_HOME = 'C:\Users\LevyUbumwe\Downloads\apache-maven-3.9.8-bin\apache-maven-3.9.8'
    }
    stages {

         stage('Checkout') {
            steps {
                script {
                    git branch: 'main', url: 'https://github.com/bumlev/jenkins-deploy.git'
                }
            }
        }

        stage('Build') {
            steps {
                script{
                      sh '{MAVEN_HOME}/bin/mvn clean package'
                }

            }
            post{
                always {
                    archiveArtifacts artifacts:'**/target/*.jar'
                }
            }
        }
        stage('Test') {
            steps {
                script{
                    sh '${MAVEN_HOME}/bin/mvn test'
                }
            }
            post{
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

    }



     post {
            // Cleanup, notifications, or actions after the pipeline completes
            always {
                echo 'Pipeline completed!'
            }
            success {
                echo 'Pipeline succeeded!'
            }
            failure {
                echo 'Pipeline failed.'
            }
        }
}