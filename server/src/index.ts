import { Request, Response, NextFunction } from 'express';
const express   = require("express");
const cors      = require("cors");
const morgan    = require("morgan");
const dbConnect = require("./database/connect");

// .env
require("dotenv").config();

// Routers
const authenticationRouter = require('./routers/authenticationRouter'); 

// Connect to the database
dbConnect();

// Initialize app and middlewares
const app = express()
app.use(cors());
app.use(morgan('combined'))
app.use(express.json());

// Delegate requests to routers
app.use('/auth', authenticationRouter);

app.get("/", (req: Request, res: Response) => {
  res.json({
    message: "Hello World!"
  })
})

// Handle errors
app.use((err: Error, req: Request, res: Response, next: NextFunction) => {
  console.error(err)
  res.status(500).send(err.message)
})

// Start the server on localhost:8080
const PORT = 8080;
app.listen(PORT, () => {
    console.log(`Server started on http://localhost:${ PORT }.`);
});