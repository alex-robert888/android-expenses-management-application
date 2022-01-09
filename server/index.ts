import { Request, Response } from 'express';
const express = require("express");
const cors    = require("cors");
const morgan  = require("morgan");

const app = express()
app.use(cors());
app.use(morgan('combined'))


app.get("/", ( _: Request, res: Response) => {
  res.send("Hello world!");
});

const port = 8080;
app.listen(port, () => {
    console.log(`Server started on http://localhost:${ port }.`);
});