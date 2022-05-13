import React from "react";
import { styled, alpha } from '@mui/material/styles';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import InputBase from '@mui/material/InputBase';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import LockOpenIcon from '@mui/icons-material/LockOpen';
import EmailIcon from '@mui/icons-material/Email';
import './Navbar.css';
import {Link, useHistory} from "react-router-dom";
import SearchIcon from '@mui/icons-material/Search';

const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
    },
    menuButton: {
        marginRight: theme.spacing(2),
    },
    title: {
        flexGrow: 1,
        textAlign : "left"
    },
    link: {
        textDecoration : "none",
        boxShadow : "none",
        color : "white"
    }
}));

const SearchIconWrapper = styled('div')(({ theme }) => ({
    padding: theme.spacing(0, 2),
    height: '100%',
    position: 'absolute',
    pointerEvents: 'none',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
}));

const Search = styled('div')(({ theme }) => ({
    position: 'relative',
    borderRadius: theme.shape.borderRadius,
    backgroundColor: alpha(theme.palette.common.white, 0.15),
    '&:hover': {
        backgroundColor: alpha(theme.palette.common.white, 0.25),
    },
    width: '100%',
    [theme.breakpoints.up('sm')]: {
        marginLeft: theme.spacing(1),
        width: 'auto',
    },
}));
const StyledInputBase = styled(InputBase)(({ theme }) => ({
    color: 'inherit',
    '& .MuiInputBase-input': {
        padding: theme.spacing(1, 1, 1, 0),
        // vertical padding + font size from searchIcon
        paddingLeft: `calc(1em + ${theme.spacing(50)})`,
        transition: theme.transitions.create('width'),
        width: '100%',
        [theme.breakpoints.up('sm')]: {
            width: '12ch',
            '&:focus': {
                width: '20ch',
            },
        },
    },
}));


function Navbar() {

    const classes = useStyles();
    let history = useHistory();
    const onclick = () => {
        localStorage.removeItem("tokenKey")
        localStorage.removeItem("currentUser")
        localStorage.removeItem("refreshKey")
        localStorage.removeItem("userName")
        localStorage.removeItem("admin")
        localStorage.removeItem("userType")
        console.log("USER SİLİNDİİİİİİ")
        history.go(0)
    }

    return <div>
        <Box sx={{ flexGrow: 1 }}>
            <AppBar position="static">
                <Toolbar >

                    <Typography variant="h6" className="title">
                        <a className="link" href="/">Home</a>
                    </Typography>

                    <Search>
                        <SearchIconWrapper>
                            <SearchIcon />
                        </SearchIconWrapper>
                        <StyledInputBase
                            placeholder="Search…"
                            inputProps={{ 'aria-label': 'search' }}
                        />
                    </Search>
                    <Typography variant="h6" className="logreg">
                        {localStorage.getItem("currentUser") == null ?

                            <a className="login" href="/auth">Login/Register</a>
                            :
                            <div>
                                <a className="link" href={"/emails/" + localStorage.getItem("currentUser")}><EmailIcon></EmailIcon></a>
                                <a className="link" href={"/users/" + localStorage.getItem("currentUser")}>Profile</a>
                                <IconButton onClick={onclick}><LockOpenIcon></LockOpenIcon></IconButton>
                            </div>}

                    </Typography>
                    {localStorage.getItem("userType") === "admin" ? <Typography variant="h6" className="title">
                        <a className="link" href="/admin">Admin</a>
                    </Typography> : null}

                </Toolbar>
            </AppBar>
        </Box>
    </div>




}
export default Navbar;