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

            when{
                 expression {
                    currentBuild.result == null || currentBuild.result == 'SUCCESS'
                    }
            }
            steps {
                echo 'Deploying APP_NAME....'

               script {
                          def pid = bat(script: "pgrep -f ${APP_NAME}.jar", returnStatus: true)
                          if (pid == 0) {
                              echo "Stopping running instance of ${APP_NAME}..."
                              bat "pkill -f ${APP_NAME}.jar"
                          } else {
                              echo "${APP_NAME} is not running, no need to stop."
                          }
              }
            }
        }
    }
}