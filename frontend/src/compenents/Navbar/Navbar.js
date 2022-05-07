import React from "react";
import { Link } from "react-router-dom";
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import LockOpenIcon from '@mui/icons-material/LockOpen';
import './Navbar.css';
import { useHistory } from "react-router-dom";





function Navbar() {

    let history = useHistory();
    const onclick = () => {
        localStorage.removeItem("tokenKey")
      localStorage.removeItem("currentUser")
      localStorage.removeItem("refreshKey")
      localStorage.removeItem("userName")
      history.go(0)
    }
    return <div>
        <Box sx={{ flexGrow: 1 }}>
            <AppBar position="static">
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
                        <a className="link" href="/">Home</a>
                    </Typography>
                    <Typography variant="h6" className="title">
                        {localStorage.getItem("currentUser") == null ?

                            <a  className="login" href="/auth">Login/Register</a>
                            :
                            <div><IconButton onClick={onclick}><LockOpenIcon></LockOpenIcon></IconButton>
                                <a className="link" href={"/users/" + localStorage.getItem("currentUser")}>Profile</a></div>}

                    </Typography>

                </Toolbar>
            </AppBar>
        </Box>
    </div>




}
export default Navbar;