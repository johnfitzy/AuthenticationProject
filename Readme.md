# Project Info

### About
 
To provision the environment run 'vagrant up' from within the platform directory (Note this will only work at Datacom)

The project 'api-admin' is a service to register you application with the api service. You will receive a randomly generated client is and client secret. You must use this to call the rest api. 
 
The project 'webservice' is a basic webservice that requires the previously mentioned step to call. 

See api.postman_collection.json for an example Postman request.

### Purpose / Goal

The purpose of this project is to learn about the common Java EE related technologies, best practices and design patterns. Also provisioning Java environments with Ansible. 

The end goal is to implement OAuth.
 
 
### TODO

- Ansible: make the environment come up on GCSC or AWS
- Authentication: implement the SSL part of 'basic auth'
- Move toward OAuth
- Make Vagrant environment build-able from anywhere


### Technologies / dependencies 
 
- Java 8
- Java EE 7
- Maven
- RestEasy
- MariaDb
- Apache
- Ansible
- Virtual Box
