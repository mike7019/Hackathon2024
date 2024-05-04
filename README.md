# Web Automation with Healenium, Screenplay, SerenityBDD, Java, and Docker

## Description

This project offers a comprehensive solution for web automation testing, combining several leading tools and technologies in the industry. The integration of Healenium, Screenplay Pattern, SerenityBDD, Java, and Docker provides an efficient and scalable approach to executing automated tests in web environments.

## Key Features

- **Healenium**: Utilizes real-time machine learning to self-heal automated tests, enhancing the stability and reliability of test cases.

- **Screenplay Pattern**: Provides a behavior-driven approach to writing tests, resulting in more readable and maintainable scripts.

- **SerenityBDD**: Offers detailed and readable reports on test execution, facilitating understanding of results and issue identification.

- **Java**: Robust and widely-used programming language for enterprise application development and test automation.

- **Docker**: Enables the creation of consistent and isolated execution environments, facilitating portability and scalability of test cases.

## Usage

To use this solution, follow these steps:

1. **Clone this repository to your local machine:**
  ```
    https://github.com/mike7019/Hackathon2024.git
   ```

2. **Install Docker and Docker Compose:**
- [Docker Installation Guide](https://docs.docker.com/get-docker/)
- [Docker Compose Installation Guide](https://docs.docker.com/compose/install/)

3. **Navigate to the `/healenium` folder and run the following command to start Docker containers:**

4. **Install Jenkins and Configure:**
- Install Jenkins on your machine following the instructions from [Jenkins Installation Guide](https://www.jenkins.io/doc/book/installing/)
- Configure Jenkins and create a pipeline job. Set up Jenkins to use a pipeline script.

5. **Execute your tests using Docker to provide a consistent execution environment:**
- Make sure your tests are configured to run in a Docker container.
- Use Docker to execute your tests:
  ```
  docker run <test_image>
  ```

6. **Utilize SerenityBDD to generate detailed reports on test execution:**
- Make sure SerenityBDD is integrated into your testing framework.
- After test execution, view the generated reports for detailed insights into test results.

7. **Observe how Healenium improves the stability of your tests by adjusting web element selectors in real-time:**
- While tests are running, monitor how Healenium dynamically adjusts web element selectors to improve test stability and reliability.


## Contributions
1. https://github.com/mike7019
2. https://github.com/JoseElver
3. https://github.com/mimarumo25
4. https://github.com/Andresmaus

Contributions are welcome. If you have suggestions for improvements, issues, or new features, feel free to open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).