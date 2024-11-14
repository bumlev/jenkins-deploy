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
                echo 'Deploying your application....'
                bat 'java -jar target/jenkins-deploy-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}

// To run this jenkinsFile you run : java -jar jenkins.war --httpPort=8094