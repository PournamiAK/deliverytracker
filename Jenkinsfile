pipeline {
    agent any

    environment {
        IMAGE_NAME = "deliverytracker"
    }

    tools {
        jdk 'jdk21'
        maven 'Maven 3'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'mkdir -p docker-build'
                sh 'cp target/deliverytracker-0.0.1-SNAPSHOT.jar docker-build/app.jar'
                sh 'cp Dockerfile docker-build/'
                sh 'docker build -t $IMAGE_NAME docker-build'
            }
        }
    }

    post {
        success {
            echo '✅ Build and Docker image creation succeeded!'
        }
        failure {
            echo '❌ Build or Test Failed!'
        }
    }
}
