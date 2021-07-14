#!/usr/bin/env groovy

def call () {
    echo "Building jarfile"
    //cleaning the package first to delete old files form target folder
    sh 'mvn clean package'
    sh 'mvn package'
}