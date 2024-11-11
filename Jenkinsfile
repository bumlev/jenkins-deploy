pipeline {
    agent none
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
                    sh 'mvn -B -DskipTests clean package'
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