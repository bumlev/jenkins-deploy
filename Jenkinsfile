pipeline {
    agent any
    stages {

         stage('Checkout') {
            steps {
                script {
                    checkout scm
                }
            }
        }

        stage('Build') {
            steps {
                script{
                    sh 'mvn clean package'
                }

            }
        }
        stage('Test') {
            steps {
                script{
                    sh 'mvn test'
                }
            }
             post {
                always {
                    junit '**/target/surefire-reports/*.xml' // Collect test results in Jenkins
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