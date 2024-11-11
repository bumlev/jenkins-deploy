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
                // Start application with trap to ensure cleanup
                bat ''

                trap "kill $(jps | grep jenkins-deploy-0.0.1-SNAPSHOT | awk \'{print \$1}\')" EXIT
                java -jar target/jenkins-deploy-0.0.1-SNAPSHOT.jar &
                sleep 10

                 // Your testing or deployment tasks here
                  echo 'Running tests...'
                  bat 'mvn test'
                  junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}