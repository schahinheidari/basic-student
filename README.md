# basic-student

# React Frontend Setup Guide

This README provides step-by-step instructions to set up and run the React frontend for the SBR application that connects to a Java Spring Boot backend.

## Prerequisites

- Node.js (v14 or later recommended)
- npm (comes with Node.js)
- Java Spring Boot backend running (see backend setup first)

## Backend First

Before starting the frontend:

1. Set up the Spring Boot backend using MVC architecture
2. Ensure your backend is running (typically on `http://localhost:8080` or similar)
3. Verify your API endpoints are working (e.g., `http://localhost:8080/api/v1/students`)

## Frontend Setup Steps

### 1. Create React App

```bash
npx create-react-app sbr-client
cd sbr-client
```

### 2. Install Required Dependencies

Run these commands in your project directory:

```bash
npm install axios
npm install bootstrap --save
npm install react-router-dom
npm install react-icons
```

### 3. Start the Development Server

```bash
npm start
```

This will run the app in development mode and open it in your default browser at `http://localhost:3000`.

## Project Structure Overview

```
sbr-client/
├── node_modules/
├── public/
├── src/
│   ├── components/    # Your React components
│   ├── App.js         # Main application component
│   ├── index.js       # Application entry point
│   └── ...            # Other source files
├── package.json
└── README.md
```

## Connecting to Backend

### Proxy Setup (Optional)

To avoid CORS issues during development, add this to your `package.json`:

```json
"proxy": "http://localhost:8080"
```

Then you can make API calls to `/api/v1/...` instead of the full URL.

### Example API Call

```javascript
import axios from "axios";

// With proxy
const response = await axios.get("/api/v1/students");

// Without proxy
const response = await axios.get("http://localhost:8080/api/v1/students");
```

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.


### `npm run build`

Builds the app for production to the `build` folder.

## Bootstrap Setup

To use Bootstrap in your project, add this to `src/index.js`:

```javascript
import "bootstrap/dist/css/bootstrap.min.css";
```

## Deployment

When ready to deploy:

1. Run `npm run build`
2. The `build` folder will contain optimized production files
3. Deploy the contents to your preferred hosting service

## Troubleshooting

- **CORS Errors**: Ensure your Spring Boot backend has CORS configured
- **Connection Issues**: Verify your backend is running before starting frontend
- **Missing Dependencies**: Run `npm install` if you get module not found errors
