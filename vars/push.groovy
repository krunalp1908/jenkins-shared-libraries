def call(String Project, String ImageTag, String dockerhubuser) {
    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
        echo "Logging in to Docker Hub as ${dockerHubUser}..."
        sh "echo ${dockerHubPass} | docker login -u ${dockerHubUser} --password-stdin"
    }
    
    echo "Pushing Docker image: ${dockerhubuser}/${Project}:${ImageTag}..."
    sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"

    echo "Docker image pushed successfully!"
}
