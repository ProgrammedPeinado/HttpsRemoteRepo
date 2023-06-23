const mongoose = require('mongoose');

const Food = mongoose.model('Food', 
{
    name: {type: 'string'},
    category: {type: 'string'},
    tag: {type: 'string'},
    price: {type: 'string'}
});

module.exports = Food;