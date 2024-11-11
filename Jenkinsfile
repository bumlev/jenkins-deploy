pipeline {
    agent any
    stages {

         stage('Checkout') {
            steps {
                script {
                    git branch: 'main', url: 'https://github.com/bumlev/jenkins-deploy.git'
                    checkout scm
                }
            }
        }

        stage('Build') {
            steps {
                script{
                    sh 'mvn -B -DskipTests clean package'
                }

            }
        }
        stage('Test') {
            steps {
                script{
                    sh 'mvn test'
                }
            }
        }
    }

     post {
            // Cleanup, notifications, or actions after the pipeline completes
            always {
                echo 'Pipeline completed!'
                cleanWs()
            }
            success {
                echo 'Pipeline succeeded!'
            }
            failure {
                echo 'Pipeline failed.'
            }
        }
}