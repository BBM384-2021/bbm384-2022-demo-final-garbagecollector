import { Button } from "@mui/material";
import React, { useState } from "react";
import { useHistory } from "react-router";
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import "./Register.css"
const theme = createTheme();
function Register() {




    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [userType, setuserType] = useState("student")
    const [email, setEmail] = useState("")
    const [confirmPassword, setuconfirmPassword] = useState("")



    let history = useHistory();
    const handleUsername = (value) => {
        setUsername(value)
    }

    const handleEmail = (value) => {
        setEmail(value)
    }
    const handleconfirmPassword = (value) => {
        setuconfirmPassword(value)
    }
    const handleUserType = (value) => {
        setuserType(value);
    }

    const handlePassword = (value) => {
        setPassword(value)
    }

    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            "Accept": 'application/json'
        },
        body: JSON.stringify({
            userName: username,
            password: password,
            confirmPassword: confirmPassword,
            email: email,
            userType: userType

        })
    };
    const sendRequest = (path) => {
        fetch('http://localhost:8080/auth/' + path, requestOptions)
            .then(response => response.json())
            .then(data => {

                if (data.enable === true) {
                    localStorage.setItem("currentUser", data.id);
                    localStorage.setItem("userName", data.userName);
                    localStorage.setItem("userType", data.userType)
                    localStorage.setItem("enable", data.msg);
                    
                    history.go("/auth")
                }
                else {
                    alert("You are not enable to login. Wait for admin approval");
                    history.go("/auth")

                    
                }

            });
    }

    const handleButton = (path) => {
        sendRequest(path);
        setUsername("")
        setPassword("")

    }

    return (
        <ThemeProvider theme={theme}>
            <Grid container component="main" sx={{ height: '100vh' }}>
                <CssBaseline />
                <Grid
                    item
                    xs={false}
                    sm={4}
                    md={7}
                    sx={{
                        backgroundImage: 'url(https://docs.kariyer.net/job/jobtemplate/000/000/223/avatar/22353420200624013537575.jpeg)',
                        backgroundRepeat: 'no-repeat',
                        backgroundColor: (t) =>
                            t.palette.mode === 'light' ? t.palette.grey[50] : t.palette.grey[900],
                        backgroundSize: 'cover',
                        backgroundPosition: 'center',
                    }}
                />
                <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
                    <Box
                        sx={{
                            my: 8,
                            mx: 4,
                            display: 'flex',
                            flexDirection: 'column',
                            alignItems: 'center',
                        }}
                    >

                        <Typography component="h1" variant="h5">
                            Sign Up
                        </Typography>
                        <Box component="form" noValidate sx={{ mt: 1 }}>
                            <TextField
                                onChange={(i) => handleUsername(i.target.value)}
                                margin="normal"
                                required
                                fullWidth
                                id="Username"
                                label="User Name"
                                name="Username"
                                autoComplete="Username"
                                autoFocus
                            />
                            <TextField
                                onChange={(i) => handlePassword(i.target.value)}
                                margin="normal"
                                required
                                fullWidth
                                name="password"
                                label="Password"
                                type="password"
                                id="password"
                                autoComplete="current-password"
                            />

                            <TextField
                                onChange={(i) => handleconfirmPassword(i.target.value)}
                                margin="normal"
                                required
                                fullWidth
                                name="confirmPassword"
                                label="confirmPassword"
                                type="password"
                                id="confirmPassword"
                                autoComplete="current-password"
                            /><TextField
                                onChange={(i) => handleEmail(i.target.value)}
                                margin="normal"
                                required
                                fullWidth
                                name="email"
                                label="Email"
                                type="email"
                                id="email"
                                autoComplete="email"
                            />


                            <select

                                onChange={(i) => { handleUserType(i.target.value) }}>
                                <option value={"student"}>Student</option>
                                <option value={"academician"}>Academician</option>
                            </select>
                            <Button variant="contained" className="contained"
                                style={{
                                    background: 'linear-gradient(45deg, #2196F3 30%, #21CBF3 90%)',
                                    color: 'white'
                                }}
                                onClick={() => handleButton("register")}>Register</Button>
                            <Grid item>
                                <Link href="/auth" variant="body2">
                                    {"You have already an account? Sign in"}
                                </Link>
                            </Grid>
                        </Box>
                    </Box>
                </Grid>
            </Grid>
        </ThemeProvider>

    )
}

export default Register;