const sqlite3 = require("sqlite3").verbose();
const db = new sqlite3.Database("./database/bakery.db");

db.serialize(() => {
  db.run(`CREATE TABLE IF NOT EXISTS categories (
    id   INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL UNIQUE
  )`);

  db.run(`CREATE TABLE IF NOT EXISTS desserts (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    name        TEXT    NOT NULL,
    flavor      TEXT    NOT NULL,
    price       REAL    NOT NULL,
    gluten_free INTEGER NOT NULL DEFAULT 0,
    low_fat     INTEGER NOT NULL DEFAULT 0,
    category_id INTEGER NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories(id)
  )`);

  const categories = [
    "Cake","Pastry","Muffin","Cupcake","Tart","Cheesecake",
    "Bread","Brownie","Donut","Macaroon","Cookie","Dessert Cup","Bar Dessert","Scone"
  ];
  categories.forEach(name => {
    db.run("INSERT OR IGNORE INTO categories (name) VALUES (?)", [name]);
  });

  const desserts = [
    ["Strawberry Shortcake","Cake","Strawberry",5.99,0,0],
    ["Chocolate Croissant","Pastry","Chocolate",3.49,0,0],
    ["Blueberry Muffin","Muffin","Blueberry",2.99,0,0],
    ["Vanilla Cupcake","Cupcake","Vanilla",3.25,0,0],
    ["Lemon Tart","Tart","Lemon",4.75,0,0],
    ["Cinnamon Roll","Pastry","Cinnamon",4.25,0,0],
    ["Raspberry Danish","Pastry","Raspberry",3.95,0,0],
    ["Cheesecake","Cheesecake","Cheese",6.50,0,0],
    ["Red Velvet Cake","Cake","Red Velvet",5.75,0,0],
    ["Banana Bread","Bread","Banana",4.50,0,0],
    ["Peach Turnover","Pastry","Peach",3.85,0,0],
    ["Caramel Brownie","Brownie","Caramel",3.50,0,0],
    ["Cookies and Cream Donut","Donut","Cookies and Cream",3.15,0,0],
    ["Strawberry Macaroon","Macaroon","Strawberry",2.75,1,0],
    ["Blueberry Macaroon","Macaroon","Blueberry",2.75,1,0],
    ["Gluten-Free Lemon Cookie","Cookie","Lemon",2.75,1,1],
    ["Almond Bisscotti","Cookie","Almond",2.95,0,1],
    ["Angel Cake Slice","Cake","Vanilla",4.25,0,1],
    ["Blueberry Yogurt Muffin","Muffin","Blueberry",3.10,0,1],
    ["Oatmeal Raisin Cookie","Cookie","Cinnamon/Raisin",2.35,0,1],
    ["Sugar-Free Vanilla Pudding","Dessert Cup","Vanilla",3.50,1,1],
    ["Gluten-Free Banana Muffin","Muffin","Banana",3.40,1,1],
    ["Mango Sorbet Cup","Dessert Cup","Mango",3.99,1,1],
    ["Apple Cinnamon Oat Bar","Bar Dessert","Apple",3.20,0,1],
    ["Tiramisu Slice","Cake","Coffee",5.80,0,1],
    ["Orange Cream Scone","Scone","Orange",3.60,0,1],
    ["Peanut Butter Cookie","Cookie","Peanut Butter",2.65,0,1],
  ];

  desserts.forEach(([name, cat, flavor, price, gf, lf]) => {
    db.get("SELECT id FROM categories WHERE name = ?", [cat], (err, row) => {
      db.run(
        "INSERT INTO desserts (name, flavor, price, gluten_free, low_fat, category_id) VALUES (?,?,?,?,?,?)",
        [name, flavor, price, gf, lf, row.id]
      );
    });
  });

  console.log("✅ Database created! Tables: categories + desserts");
});

setTimeout(() => { db.close(); }, 1000);
