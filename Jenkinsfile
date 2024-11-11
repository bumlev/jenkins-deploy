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