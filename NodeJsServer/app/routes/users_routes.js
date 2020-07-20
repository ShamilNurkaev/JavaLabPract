const {Client} = require('pg');
const connectionString = 'postgres://postgres:9aw25pxj@localhost/resumeDB';

bodyParser = require('body-parser');
const urlencodedParser = bodyParser.urlencoded({extended: false});

module.exports = function (app) {
    app.get('/profile', (request, response) => {
        let result = [
            {
                "name": "Nurkaev Shamil Fidanovich",
                "age": "19",
                "education": "Higher Institute of Information Technology and Intelligent Systems",
                "academic degree": "Bachelor Degree Program 'SOFTWARE ENGINEERING', 2019 - 2023",
                "course": "2-nd year",
                "work experience": "professionally solve Matan",
                "phone": "+7 (999) 111-00-00",
                "email": "nurkaievs@mail.ru",
                "message": "I love JavaScript and I am the best person for this job!"
            }
        ];
        response.send(JSON.stringify(result));
    });

    app.post('/someURL', urlencodedParser, (request, response) => {
        if (!request.body) return response.sendStatus(400);
        const user = request.body;
        const client = new Client({connectionString: connectionString})
        client.connect();
        client.query("INSERT INTO users(name, email, message) VALUES($1, $2, $3)",
            [user.name, user.email, user.message], (err, res) => {
                if (err) {
                    console.log(err.stack);
                } else {
                    console.log(res.rows[0]);
                }
            });
        response.send('Successfully sent');
    });

    app.get('/userRequests', (request, response) => {
        if (!request.body) return response.sendStatus(400);
        const client = new Client({
            connectionString: connectionString,
        })
        client.connect();
        client.query('SELECT * FROM users;',
            [], (error, result) => {
                if (error) {
                    console.log(error.stack);
                } else {
                    console.log(result.rows[0]);
                }
                response.setHeader("Content-Type", "application/json");
                response.json(result.rows);
            });
    });
};