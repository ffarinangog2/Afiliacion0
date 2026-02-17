pipeline {
    agent any

    stages {

        stage('Checkout') {
                    steps {
                        checkout scm
                    }
                }


        stage('Build Maven') {
            steps {
                sh 'mvn -B package -DskipTests'

            }
        }





        stage('Build Docker Image') {
            steps {
                sh 'docker build -t fredvlad/pruebafred:latest .'
            }
        }

        stage('Login Docker Hub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                }
            }
        }

        stage('Push Image') {
            steps {
                sh 'docker push fredvlad/pruebafred:latest'
            }
        }
    }
}
