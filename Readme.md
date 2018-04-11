# Project Info

### About
 
To provision the environment run 'vagrant up' from with in the platform directory (Note this will only work at Datacom)

The project 'api-admin' is a service to register you application with the api service. You will receive a randomly generated client is and client secret. You must use the to call the rest api. 
 
The project 'webservice' is a basic webservice that requires the previously mentioned step to call. 

### Purpose / Goal

The purpose of this project is to learn about the common Java EE related technologies, best practices and design patterns. Also provisioning Java environments with Ansible. 

The end goal is to implement OAuth.
 
 
### TODO

- Ansible: make the environment come up on GCSC or AWS
- Authentication: implement SSL part of basic auth
- Move toward OAuth


### Technologies
 
- Java 8
- Java EE
- Maven
- RestEasy
- MariaDb
- Apache
- Ansible
- Virtual Box
