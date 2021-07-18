package com.example

class Docker implements Serializable {
    def script
    Docker (script) {
        this.script = script
    }

    def dockerLogin () {
        script.withCredentials([
                script.usernamePassword(credentialsId: '3703ba37-a8bc-4d6e-8ab4-4bbbf4df5e8e', usernameVariable: 'USER', passwordVariable: 'PASS')
        ]) {
            script.sh 'echo $PASS | docker login -u $USER --password-stdin'
        }
    }

    def buildDockerImage (){
        script.echo "Building docker image"
        script.sh "docker build -t pankajdh/testrepo:java-maven-app-$script.imageVersion ."
        script.echo "Image built successfully"
    }

    def dockerPush () {
        script.echo "Pushing docker image"
        script.sh "docker push pankajdh/testrepo:java-maven-app-$script.imageVersion"
        script.echo "Docker image pushed successfully"
    }

}
