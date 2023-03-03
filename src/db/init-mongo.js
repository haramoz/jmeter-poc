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
  
  db.createCollection('orders');
  db.createCollection('menu');

  db.menu.insert({item: 'Food & Drinks'})
  db.menu.insert({item: 'Pommes & Beers'})
  db.menu.insert({item: 'Pasta & Limoncello'})


