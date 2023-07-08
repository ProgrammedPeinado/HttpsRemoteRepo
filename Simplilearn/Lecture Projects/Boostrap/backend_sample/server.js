const express = require('express')
const bodyParser = require('body-parser')
const cors = require('cors')
const { application } = require('express')
application.use(bodyParser.json())


application.use(cors({origin:'htt://localhost:4200'}));

application.listen(5000, () => 
{
    console.log("Server started at port 5000")
}
)