# Trivadis Docker Workshop - Spring Boot Example

A simple Spring-boot CRUD application with mongoDB. The application will be deployed to openshift, by the help of the
_fabric8-maven-plugin_ using custom service/deployment and Dockerfile descriptors. You can place your custom configuration
in *src/main/fabric8* & your Dockerfile in *src/main/docker*

## Deploy a Docker Image Manually

As an example deploy the required mongo db first...

1. Login to Openshift: *oc login -u developer -p developer*
2. Create mongodb service: *oc create -f kube/mongoservice.yml*
3. Start a mongodb: *oc create -f kube/mongodeployment.yml*

You can check the deployment by opening the Openshift console using
`minishift console`. Login with the same user as above.

## Build and Deploy the Application Image Manually

Ensure the mongo instance is running as described in the previous step, then

1. Login to Openshift (if not already done): *oc login -u developer -p developer*
2. Setup your Docker environment: *eval $(minishift docker-env)*

5. Build and deploy your project: *mvn clean install* **fabric8:deploy**

After a few seconds you can access the application running in Openshift:

* Get service $ROUTE-URL: *minishift openshift service list -n myproject*
* Open *$ROUTE-URL/index.html*  (example: http://spring-boot-example-myproject.192.168.99.100.nip.io ).


## Build and Deploy the Application Image Using the Fabric8 Maven Plugin

1. Login to Openshift (if not already done): *oc login -u developer -p developer*
2. Setup your Docker environment (if not already done): *eval $(minishift docker-env)*
3. Build and deploy your project: *mvn clean install* **fabric8:deploy**

After a few seconds you can access the application running in Openshift:

* Get service $ROUTE-URL: *minishift openshift service list -n myproject*
* Open *$ROUTE-URL/index.html*  (example: http://spring-boot-example-myproject.192.168.99.100.nip.io ).
