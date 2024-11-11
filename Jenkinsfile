pipeline {
    agent any

    environment {
            // Define any environment variables here if needed
            APP_NAME = 'jenkins-deploy'
        }


    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'

              // Restart the application if it's already running
                bat ''
                if prep -f ${APP_NAME}; then
                    pkill -f ${APP_NAME}
            }
        }
    }
}