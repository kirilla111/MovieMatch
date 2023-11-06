def scmUrl = "https://github.com/kirilla111/MovieMatch.git"
def infraFolderName = "infra"

pipeline {
    agent any

    stages {
        stage("Получить исходный код") {
            steps {
                script {
                   checkout scmGit(
                    branches: [[name: '*/main']], 
                    extensions: [], 
                    userRemoteConfigs: [[credentialsId: 'ed596ff2-951e-4fad-9018-20741c763036', url: "${scmUrl}"]])
                }
            }
        }
    }
}