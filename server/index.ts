import { Request, Response } from 'express';
const express = require("express");
const cors    = require("cors");
const morgan  = require("morgan");

// Initialize app and middlewares
const app = express()
app.use(cors());
app.use(morgan('combined'))
app.use(express.json());

// Delegate requests & handle errors
app.get("/", ( _: Request, res: Response) => {
  res.send("Hello world!");
});

// Start the server on localhost:8080
const PORT = 8080;
app.listen(PORT, () => {
    console.log(`Server started on http://localhost:${ PORT }.`);
});