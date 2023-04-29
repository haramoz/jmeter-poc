db.auth('admin', 'admin')

db = db.getSiblingDB('mydb')

db.createUser({
    user: 'myuser',
    pwd: 'mypassword',
    roles: [
        {
            role: 'dbOwner',
            db: 'mydb',
        },
    ],
});

db.createCollection('device');

db.device.insert([
    {
        name: 'OLT 1',
        description: 'OLT from our lab',
        properties: [],
        type: 'openolt'
    }
]);