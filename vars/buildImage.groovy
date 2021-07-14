#!/usr/bin/env groovy

def call () {
    echo "Building docker image"
    withCredentials([
            usernamePassword(credentialsId: '3703ba37-a8bc-4d6e-8ab4-4bbbf4df5e8e', usernameVariable: 'USER', passwordVariable: 'PASS')
    ])

            {
                sh "docker build -t pankajdh/testrepo:java-maven-app-$imageVersion ."
                sh 'echo $PASS | docker login -u $USER --password-stdin'
                sh "docker push pankajdh/testrepo:java-maven-app-$imageVersion"
            }
}