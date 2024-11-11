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
        stage('Build Docker Image') {
            steps {
                bat 'docker build -t jenkins-deploy-jenkins-deploy:latest .'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying APP_NAME....'
                // Start the application in the background
                sh 'java -jar target/jenkins-deploy-0.0.1-SNAPSHOT.jar'

                // Give the app some time to start
                sleep 10

                // Run your tests or other deployment tasks here
                echo 'Running tests...'

                // Stop the application
                script {
                    def pid = bat(script: "jps | grep jenkins-deploy-0.0.1-SNAPSHOT | awk '{print \$1}'", returnStdout: true).trim()
                    if (pid) {
                        bat "kill -9 ${pid}"
                    }
                }
            }
        }
    }
}