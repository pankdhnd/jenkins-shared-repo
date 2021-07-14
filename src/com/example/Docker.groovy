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
            script.sh 'echo $script.PASS | docker login -u $script.USER --password-stdin'
        }
    }

    def buildDockerImage (){
        script.echo "Building docker image"
        script.sh "docker build -t pankajdh/testrepo:java-maven-app-$imageVersion ."
    }

    def dockerPush () {
        script.sh "docker push pankajdh/testrepo:java-maven-app-$imageVersion"
    }

}
