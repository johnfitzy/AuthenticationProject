# Project Info

### About
 
To provision the environment run 'vagrant up' from within the platform directory.

The project 'api-admin' is a service to register you application with the api service. You will receive a randomly generated client id and client secret. You must use this to call the rest api. 
 
The project 'webservice' is a basic webservice that requires the previously mentioned step to call. 

See api.postman_collection.json for an example Postman request.

### Purpose / Goal

The purpose of this project is to learn about the common Java EE related technologies, best practices and design patterns. Also provisioning Java environments with Ansible. 

The end goal is to implement OAuth.


### Users 

##### Default Api Admin user

- username -> ray@gmail.com
- password -> password

 
### TODO

- Ansible: make the environment come up on GCSC or AWS
- Properly store client cert CN in db (next thing to do)
- Move toward OAuth
- Fix up the database, for example I'm not sure if having one db is right, refactor the database module


### Technologies / dependencies 
 
- Java 8
- Java EE 7
- Maven
- RestEasy
- MariaDb
- Apache
- Ansible
- Virtual Box
- Flyway
- Mutual SSl
