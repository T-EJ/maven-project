pipeline {
    agent any
    tools {
        maven 'maven3'
        jdk 'java17'
    }
    stages {
        stage('Download from Git') {
            steps {
                git 'https://github.com/T-EJ/maven-project.git'
            }
        }
        stage('Build Java Project') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/*.war', followSymlinks: false
            }
        }
    }
}


