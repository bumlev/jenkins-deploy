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
            post{
                archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            }
        }
        stage('Test') {
            steps {
                echo 'mvn test'
            }
            post{
                junit '**/target/surefire-reports/*.xml', allowEmptyArchive: true
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