const mongoose = require("mongoose");

function connect() {
  // Connect to the database
  mongoose.connect("mongodb://localhost/expenses-management",
    () => console.log("Connected to expenses-management database."),
    (e: Error) => console.error("Error while connecting to expenses-management database.", e)
  ) 
}

module.exports=connect;