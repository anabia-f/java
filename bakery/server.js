var express = require("express");
var sqlite3 = require("sqlite3").verbose();
var path = require("path");
var app = express();
var PORT = 3000;
const db = new sqlite3.Database("./database/bakery.db");

app.use(express.static(path.join(__dirname, "public")));

app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "public", "index.html"));
});

app.get("/api/desserts", (req, res) => {
  var sql = `
    SELECT desserts.id, desserts.name, desserts.flavor, desserts.price,
           desserts.gluten_free, desserts.low_fat, categories.name AS category
    FROM desserts
    INNER JOIN categories ON desserts.category_id = categories.id
    ORDER BY desserts.name
  `;
  db.all(sql, [], (err, rows) => {
    if (err) return res.status(500).json({ error: err.message });
    res.json(rows);
  });
;

app.get("/api/desserts/gluten-free", (req, res) => {
  const sql = `
    SELECT desserts.id, desserts.name, desserts.flavor, desserts.price,
           desserts.gluten_free, desserts.low_fat, categories.name AS category
    FROM desserts
    INNER JOIN categories ON desserts.category_id = categories.id
    WHERE desserts.gluten_free = 1
    ORDER BY desserts.name
  `;
  db.all(sql, [], (err, rows) => {
    if (err) return res.status(500).json({ error: err.message });
    res.json(rows);
  });
});

app.get("/api/desserts/low-fat", (req, res) => {
  const sql = `
    SELECT desserts.id, desserts.name, desserts.flavor, desserts.price,
           desserts.gluten_free, desserts.low_fat, categories.name AS category
    FROM desserts
    INNER JOIN categories ON desserts.category_id = categories.id
    WHERE desserts.low_fat = 1
    ORDER BY desserts.name
  `;
  db.all(sql, [], (err, rows) => {
    if (err) return res.status(500).json({ error: err.message });
    res.json(rows);
  });
});

app.get("/api/categories"), (req, res) => {
  db.all("SELECT * FROM categories ORDER BY name", );
};})
