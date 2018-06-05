# Summary:
The plan is to create a small webapp ex: A single field screen with type ahead search. The tech Stack to contain 4 main components:

1. Web component for Presentation
2. Middleware to handle web calls
3. Database to store searchable data
4. A Dataseeder to push data to DB before the Web/Middleware boots-up

*So the approach is to create 3 docker images - One each for Web/Middleware, Dataseeder and DB. The env will be stood up using docker-compose. These images can also be hooked up as a pod for deployment on Kubernetes/minikube or Openshift/minishift.*

**Tasks for Web:**
1. Choose a simple web framework
2. Create a simple screen

**Tasks for Middleware:**
1. Orchestrate i.e handle web requests and get data from backend

**Tasks for DB:**
1. Select a backend db
2. Workout the details for DB and User creation on boot-up 
3. Use a default root password for the DB creation

**Tasks for Dataseeder:**
1. Create a table
2. Insert records into the table

**Platform:**
1. Will be doing this peice of work on a Linux based platform

## Execution
```
docker-compose -f docker-compose.yml up -d
```