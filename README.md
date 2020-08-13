## Getting Started

    # Run the application on port 8080
    ./gradlew bootRun
     
    # Build to jar
    ./gradlew build

With the application running,

    # Create a short link
    POST /
    body: http://www.a-rather-long-link.com
    
    # Visit a short link (redirects) 
    GET /?id=123
