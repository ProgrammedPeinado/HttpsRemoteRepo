//Remember to use nodemon server.js to start the connection
const express = require('express');
const bodyParser = require('body-parser');


//for api requests from angular app cors module needs to be installed and imported here.
const cors = require('cors')
const mongoose = require('./db.js')

// here mongoose is imported for database file and not package.json file

//need routes to be imported here.
const routes = require('./routes/routes.js');
//const router = require('./routes/routes.js');

const Food = require('./models/Food.js');
const Admin = require( './models/Admin.js');

const app = express();
const router = express.Router();

app.use(bodyParser.json());

app.use((req, res, next) =>
{
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept');
    res.header('Access-Control-Allow-Methods', 'OPTIONS, GET, POST, PUT,DELETE');
    if('OPTIONS' == req.method)
    {
        res.sendStatus(200);
    }
    else
    { 
        console.log(`${req.ip} ${req.method} ${req.url}`);
        next();
    }
});

mongoose.connect('mongodb://127.0.0.1:27017/kitchen_stories');

const connection = mongoose.connection;

connection.once('open', () => 
{ console.log('MongoDB database connection established successfully.')}
);

router.route('/foods').get((req,res) =>
{ 
    Food.find((err, food) => 
    {
    if (err)
        console.log(err);
    else
        res.json(food);
    });
});

router.route('/foods/:id').get((req,res) =>
{
    Food.findById(req.params.id, (err, food) =>
    {
        if (err)
            console.log(err);
        else
            res.json(food);
    });
});


router.route('/foods/add/').post((req, res) =>
{
    let food = new Food(req.body);
    food.save()
        .then(food => 
        {
                res.status(200).json({'food':'Added successfully'});
        })
        .catch(err =>
        {
            res.status(400).send('Failed to create'); 
        });
});

router.route('/foods/update/:id').post((req, res) =>
{
    Food.findById(req.params._id, (err, food) =>
    {
        if (!food)
            return next(new Error('Could not load document'));
        else
            food.name= req.body.name;
            food.category = req.body.category;
            food.tag = req.body.tag;

            food.save().then(food =>
                {
                    res.json('Update done');
                }).catch(err =>
                {
                    res.status(400).send('Update failed')
                });
                
    });
});

router.route('/foods/delete/').post((req, res) =>
{
    food.findByIdAndRemove({_id: req.params.id}, (err, food) =>
    {
        if(err)
            res.json(err);
        else
            res.json('Remove successful');
    })
})

// this is path of angular application
app.use(cors({origin: 'http://localhost:4200',
                credentials:true}));

app.use('/', router);

app.listen(4000, () => {
    console.log("Server started at port 4000")
});