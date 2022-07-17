pipeline {
    agent any

    environment {

    }

    stages {
        stage {
            checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '52ec876e-fc7c-460d-ba54-89c024ea7dc5', url: 'https://github.com/PaulZgy/jenkins.git']]])
        }
        stage {
            sh '/root/docker/jenkins/data/maven/bin/mvn clean package -DskipTests'
        }
        stage {
            sshPublisher(publishers: [sshPublisherDesc(configName: 'ali', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '''cd /root/jenkins/docker
            mv ../target/*jar ./
            docker-compose down
            docker-compose up -d --build''', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'target/*.jar  docker/*')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
        }
    }
}