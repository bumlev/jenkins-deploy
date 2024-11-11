pipeline {
    agent any
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
                echo "Build package"
            }
        }
        stage('Test') {
            steps {
                echo 'mvn test'
            }
            post{
                always {
                    junit 'target/surefire-reports/*.xml'
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