import React from "react";
import { Link } from "react-router-dom";
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import './Navbar.css';





function Navbar() {

    let userId = 5;

    return <div>
         <Box sx={{ flexGrow: 1 }}>
        <AppBar  position="static">
            <Toolbar >
                <IconButton
                    size="large"
                    edge="start"
                    color="inherit"
                    aria-label="menu"
                    sx={{ mr: 2 }}
                    className="menu"
                >
                    
                </IconButton>
                <Typography variant="h6" className="title">
                <Link className="link" to="/">Home</Link>
                </Typography>
                <Link  className="link" to={{ pathname: "/users/" + userId }}>User</Link>
            </Toolbar>
        </AppBar>
        </Box>
    </div>




}
export default Navbar;