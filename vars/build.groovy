def call(String ProjectName, String ImageTag, String DockerHubUser) {
    if (!ProjectName?.trim() || !ImageTag?.trim() || !DockerHubUser?.trim()) {
        error "ERROR: Missing parameters! Ensure ProjectName, ImageTag, and DockerHubUser are provided."
    }

    echo "Building Docker image: ${DockerHubUser}/${ProjectName}:${ImageTag}..."
    
    try {
        sh "docker build -t ${DockerHubUser}/${ProjectName}:${ImageTag} ."
        echo "Docker build successful!"
    } catch (Exception e) {
        error "Docker build failed: ${e.message}"
    }
}
