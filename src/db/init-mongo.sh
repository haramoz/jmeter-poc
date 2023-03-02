#!/bin/bash

echo "Creating user..."
mongosh admin --host localhost -u admin -p admin --eval "db.createUser({user: 'myuser', pwd: 'mypassword', roles: [{role: 'readWrite', db: 'mydb'}]});"
echo "User created!"
