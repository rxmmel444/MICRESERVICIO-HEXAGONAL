pipeline {
    agent any


    stages {
        stage('Clonar código') {
            steps {
                git 'https://github.com/rxmmel444/MICRESERVICIO-HEXAGONAL.git'
            }
        }

        stage('Levantar servicios') {
            steps {
                sh 'docker-compose down || true'
                sh 'docker-compose up -d --build'
            }
        }

        stage('Esperar servicio') {
            steps {
                sh 'sleep 15'
            }
        }

        stage('Verificar salud del microservicio') {
            steps {
                sh 'curl -f http://localhost:8080/actuator/health || true'
            }
        }
        stage('Build Maven') {
            steps {
        sh 'docker-compose exec -T microservicio.usuarios mvn clean install'
            }
        }



        stage('Finalizar') {
            steps {
                sh 'docker-compose down'
            }
        }
    }
}
