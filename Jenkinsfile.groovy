pipeline {
    agent any
    tools {
        maven 'maven3'
        jdk 'JDK-17'
    }
    stages {
        stage('Copy-artifact from Build-java-pipline ') {
            steps {
               copyArtifacts filter: '**/*.war', fingerprintArtifacts: true, projectName: 'Build-java-pipeline', selector: lastSuccessful()
            }
        }
    

        stage('Deploy') {
            steps {
               copyArtifacts filter: '**/*.war', fingerprintArtifacts: true, projectName: 'Build-java-pipeline', selector: lastSuccessful()
            }
        }
   }
}

