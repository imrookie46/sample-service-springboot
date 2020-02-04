# Sample-Service

This is sample of springboot application template I usually use.
Use Intellij or STS to open/edit this project if You don't want to waste extra energy just for IDE configuration.

This project is ready for Eureka service registry, using gradle, and ready using rabbitMQ.
If You don't have rabbitMQ server ready, comment rabbitMQ config in gradle.build and application.properties. If not, this will cause looping searching rabbitMQ server connection.
