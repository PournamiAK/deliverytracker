pipeline {
    agent any

    environment {
        IMAGE_NAME = 'deliverytracker'
    }

    tools {
        maven 'Maven 3'       // Jenkins must have a tool named "Maven 3"
        jdk 'jdk21'           // Jenkins must have a JDK install named "jdk21"
    }

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/PournamiAK/deliverytracker.git'
            }
        }

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
        sh 'cp target/deliverytracker-0.0.1-SNAPSHOT.jar app.jar'
        sh 'docker build -t $IMAGE_NAME .'
    }
}

        // Optional: Push to DockerHub (Uncomment if needed)
        // stage('Push to DockerHub') {
        //     steps {
        //         withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        //             sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
        //             sh 'docker tag $IMAGE_NAME $DOCKER_USER/$IMAGE_NAME'
        //             sh 'docker push $DOCKER_USER/$IMAGE_NAME'
        //         }
        //     }
        // }
    }

    post {
        success {
            echo '✅ Build and Test Passed!'
        }
        failure {
            echo '❌ Build or Test Failed!'
        }
    }
}
