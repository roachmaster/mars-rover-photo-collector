node {
    stage("build"){
        checkout scm
        sh "ls" 
        sh "./gradlew clean build --stacktrace --info"
    }
}
