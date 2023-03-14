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

db.menu.insert([
  {
    item: 'Spicy Tacos',
    description: 'Tacos with a kick of spice',
    ingredients: ['pork', 'lettuce', 'tomatoes', 'cheese', 'spicy salsa'],
    spicyLevel: 'hot'
  },
  {
    item: 'Margherita Pizza',
    description: 'Classic Italian pizza with fresh mozzarella and basil',
    ingredients: ['mozzarella cheese', 'tomato sauce', 'fresh basil', 'olive oil'],
    spicyLevel: 'mild'
  },
  {
    item: 'Spicy Chicken Curry',
    description: 'Creamy chicken curry with a spicy kick',
    ingredients: ['chicken', 'coconut milk', 'curry powder', 'chili peppers', 'onions', 'garlic'],
    spicyLevel: 'very hot'
  }
]);


