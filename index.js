const express = require('express');
const app = express();
const PORT = 8080;
const fs = require('fs')

const beerDB = JSON.parse(fs.readFileSync('open-beer-database.json'))
app.use(express.static('public'));

app.get('/api/beer', (req, res) => {
    const beer = beerDB[Math.floor(Math.random()* beerDB.length)]
    res.send(beer.fields)
});

app.listen(PORT, () => console.log(`Server listening on port: ${PORT}`));
